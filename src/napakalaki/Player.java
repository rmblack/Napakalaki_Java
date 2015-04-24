
package napakalaki;

import java.util.ArrayList;

public class Player {
    
    // Attributes
    private boolean dead;
    private String name;
    private int level;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private static final int MAXHIDDENTREASURES = 4;
    private BadConsequence pendingBadConsequence;
    
    // Constructors
    Player (String name) {
        this.name = name;
        dead = false;
        level = 1;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        pendingBadConsequence = null;
        // REV
    }
    
    //
    // EXAMEN
    public void setVisibleTreasureList(ArrayList<Treasure> list) {
        visibleTreasures = list;
    }
    
    public void setHiddenTreasureList(ArrayList<Treasure> list) {
        visibleTreasures = list;
    }
    // FIN EXAMEN
    //
    
    // Private class functions
    
    private void bringToLive(){
        dead = false;
    }
    
    private void incrementLevels (int l) {
        level += l;
        // REV
    }
    
    private void decrementLevels (int l) {
        level -= l;
        if ( level < 1) level = 1;
    }
    
    private void setPendingBadConsequence (BadConsequence b) {
        pendingBadConsequence.clone(b);
    }
    
    private void die() {
        dead = true;
        level = 1;
        for (Treasure treasure : visibleTreasures) {
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
        visibleTreasures.clear();
        for (Treasure treasure : hiddenTreasures) {
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
        hiddenTreasures.clear();
    }
    
    private void discardNecklaceIfVisible() {
        for (Treasure treasure : visibleTreasures) {
            if (treasure.getType() == TreasureKind.NECKLACE) {
                CardDealer.getInstance().giveTreasureBack(treasure);
                visibleTreasures.remove(treasure);
                
            }
        }
    }
            
    
    private void dieIfNoTreasure() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()) dead = true;
    }
    
    private boolean canIBuyLevels(int l) {
        boolean condition = false;
        if (level + l < 10) condition = true;
        return condition;
    }
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> t) {
        float gold = 0;
        for (Treasure treasure : t) {
            gold += treasure.getGoldCoins();
        }
        return (gold / 1000);
    }
    
    /* ~ Auxiliary method ~
     * returns true if visibleTreasures contains a Treasure of type NECKLACE
     */
    protected boolean hasNecklace() {
        for (Treasure treasure : visibleTreasures) {
            if (treasure.getType() == TreasureKind.NECKLACE) {
                return true;
            }
        }
        return false;
    }
    
    // Public class functions
    
    public void applyPrize(Prize prize) {
        incrementLevels(prize.getLevels());
        for (int i=0; i < prize.getTreasures(); i++) {
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
    }
    
    public CombatResult combat(Monster m) {
        CombatResult result;
        BadConsequence badYuyu;
        boolean amIDead;
        int escape;
        int myLevel = getCombatLevel();
        int levelMonster = m.getCombatLevel();
        
        if ( myLevel > levelMonster) {
            applyPrize(m.getPrize());
            if (this.level == 10) result = CombatResult.WINANDWINGAME;
            else result = CombatResult.WIN;
        }
        else {
            escape = Dice.getInstance().nextNumber();
            if ( escape < 5) {
                badYuyu = m.getBadConsequence();
                amIDead = badYuyu.kills();
                if (amIDead) {
                    die();
                    result = CombatResult.LOSEANDDIE;
                }
                else {
                    applyBadConsequence(badYuyu);
                    result = CombatResult.LOSE;
                }
            }
            else result = CombatResult.LOSEANDESCAPE;
        }
        this.discardNecklaceIfVisible();
        return result;
    }
    
    public void applyBadConsequence(BadConsequence badYuyu) {
        BadConsequence pendingBad;
        decrementLevels(badYuyu.getLevels());
        pendingBad = badYuyu.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    public boolean makeTreasureVisible(Treasure t) {
        boolean condition = false;
        if (canMakeTreasureVisible(t)) {
            getVisibleTreasures().add(t);
            getHiddenTreasures().remove(t);
            condition = true;
        }
        return condition;
    }
    
    public boolean canMakeTreasureVisible(Treasure t) {
        boolean condition = false;
        TreasureKind thisType = t.getType();
        if (hiddenTreasures.contains(t)) { // check if it's in hand
            condition = true;
            // 3 cases according to game rules:
            if ( thisType == TreasureKind.BOTHHANDS) {
                for (Treasure treasure : visibleTreasures) {
                    if ( (treasure.getType() == TreasureKind.BOTHHANDS) 
                      || (treasure.getType() == TreasureKind.ONEHAND)) {
                        condition = false;
                    }
                }
            }
            else if (thisType != TreasureKind.ONEHAND) {
                int handCount = 0;
                for (Treasure treasure : visibleTreasures) {
                    if (treasure.getType() == thisType ) handCount++;
                }
                if (handCount > 1) condition = false;
            }
            else {
                for (Treasure treasure : visibleTreasures) {
                    if (treasure.getType() == thisType) condition = false;
                }
            }
        }
        return condition;
    }
    
    public void discardVisibleTreasure(Treasure t) {
        this.visibleTreasures.remove(t);
        if ( (pendingBadConsequence != null)&&(!pendingBadConsequence.isEmpty())) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        CardDealer.getInstance().giveTreasureBack(t);
        dieIfNoTreasure();
    }
    
    public void discardHiddenTreasure(Treasure t) {
        this.visibleTreasures.remove(t);
        if ( (pendingBadConsequence != null)&&(!pendingBadConsequence.isEmpty())) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        CardDealer.getInstance().giveTreasureBack(t);
        dieIfNoTreasure();
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        float levels;
        boolean canI;
        int intLevels;
        levels = computeGoldCoinsValue(visible);
        levels += computeGoldCoinsValue(hidden);
        intLevels = levels; // round the value
        canI = canIBuyLevels(intLevels);
        if (canI) {
            incrementLevels(intLevels);
            for (Treasure treasure : visible) {
                discardVisibleTreasure(treasure);
            }
            for (Treasure treasure: hidden) {
                discardHiddenTreasure(treasure);
            }
        }
        return canI;
    }
    
    public int getCombatLevel() {
        int output = level;
        if (hasNecklace()) {
            for (Treasure treasure : visibleTreasures) {
                output += treasure.getMaxBonus();
            }
        } else {
            for (Treasure treasure : visibleTreasures) {
                output += treasure.getMinBonus();
            }
        return output;
    }
        
        return level; // + ITEMS 
    }
    
    public boolean validState() {
        boolean condition = false;
        if ( pendingBadConsequence.isEmpty()
             && (hiddenTreasures.size() <= MAXHIDDENTREASURES)) { 
            condition = true;
        }
        return condition;
    }
    
    public /*boolean ->*/void initTreasures() { // REV: return changed.
        int treasureNumber, diceNumber;
        bringToLive();
        diceNumber = Dice.getInstance().nextNumber();
        // REV: use CASE or IF ? // Code from diagram modified to make shorter
        
        if (diceNumber == 1) {
            treasureNumber = 1;
        }
        else if (diceNumber < 6) {
            treasureNumber = 2;
        }
        else /*(number == 6)*/{
            treasureNumber = 3;
        }
        for (int i=0; i<treasureNumber; i++) {
            hiddenTreasures.add( CardDealer.getInstance().nextTreasure() );
        }
    }
    
    public boolean isDead() {
        return dead;
    }
    
    public boolean hasVisibleTreasures() {
        return !visibleTreasures.isEmpty();
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    public String getName() {
        return name;
    }
}





















