
package Model;

import java.util.ArrayList;

public class Player {
    
    /* Attributes */
    private boolean dead;
    private String name;
    private int level;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private static final int MAXHIDDENTREASURES = 4;
    private BadConsequence pendingBadConsequence;
    
    /* Constructors */
    Player (String name) {
        this.name = name;
        this.dead = true; // Debug_1 : Fixed initialization
        this.level = 1;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
        this.pendingBadConsequence = new BadConsequence("", false);
    }
    /* Debug_1 : unnecesary exam code deleted */
    
    /* Private·Protected functions */
    
    private void bringToLive(){
        dead = false;
    }
    
    private void incrementLevels (int lnum) {
        level += lnum;
        if ( level > 10 ) level = 10;
    }
    
    private void decrementLevels (int lnum) {
        level -= lnum;
        if ( level < 1) level = 1;
    }
    
    private void setPendingBadConsequence (BadConsequence b) {
        pendingBadConsequence.clone(b);
        /* REV: clone() unnecesary? argument is alredy a copy.
         * Keep it just in case, setting a player's bc has been
         * problematic in Napakalaki, once the program is finished
         * consider changing this for efficiency
         */
    }
    
    private void die() {
        dead = true;
        level = 1;
        for (Treasure treasure : visibleTreasures) {
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
        for (Treasure treasure : hiddenTreasures) {
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
        visibleTreasures.clear();
        hiddenTreasures.clear();
    }
    
    private void discardNecklaceIfVisible() {
        for (Treasure treasure : visibleTreasures) {
            if (treasure.getType() == TreasureKind.NECKLACE) {
                CardDealer.getInstance().giveTreasureBack(treasure);
                visibleTreasures.remove(treasure);
            }
        }
        /* Does not use hasNeckalce() beacuse the function needs the
         * position where it is
         */
    }
             
    private void dieIfNoTreasure() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()) dead = true;
    }
    
    private boolean canIBuyLevels(int lnum) {
        boolean condition = false;
        if (level + lnum < 10) condition = true;
        return condition;
    }
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> tlist) {
        float gold = 0;
        for (Treasure treasure : tlist) {
            gold += treasure.getGoldCoins();
        }
        return (gold / 1000);
    }
    
    /* Aux method (read changelog) */
    protected boolean hasNecklace() {
        boolean condition = false;
        for (Treasure treasure : visibleTreasures) {
            if (treasure.getType() == TreasureKind.NECKLACE) {
                condition = true;
            }
        }
        return condition;
    }
    
    /* Getters */
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }    
    public String getName() {
        return name;
    }
    public boolean /*getDead*/ isDead() {
        return dead;
    }
    
    /* Public functions */
    
    public void applyPrize(Prize prize) {
        incrementLevels(prize.getLevels());
        for (int i=0; i < prize.getTreasures(); i++) {
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
    }
    
    public void applyBadConsequence(BadConsequence badYuyu) {
        BadConsequence pendingBad;
        decrementLevels(badYuyu.getLevels());
        pendingBad = badYuyu.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if ( (pendingBadConsequence != null)&&(!pendingBadConsequence.isEmpty())) {
            pendingBadConsequence.substractVisibleTreasure(t);
            CardDealer.getInstance().giveTreasureBack(t);
        }
        dieIfNoTreasure();
    }
    
    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t); // Debug_1 : fixed removing from visibleTreasures
        if ( (pendingBadConsequence != null)&&(!pendingBadConsequence.isEmpty())) {
            pendingBadConsequence.substractHiddenTreasure(t);
             CardDealer.getInstance().giveTreasureBack(t);
        }
        dieIfNoTreasure();
    }
      
    public /*boolean ->*/void initTreasures() { // Debug_1 : return changed. (why boolean?)
        int treasureNumber, diceNumber;
        bringToLive();
        diceNumber = Dice.getInstance().nextNumber();
        // use CASE or IF ?
        
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
    
    public boolean makeTreasureVisible(Treasure t) {
        boolean condition = false;
        if (canMakeTreasureVisible(t)) {
            getVisibleTreasures().add(t);
            getHiddenTreasures().remove(t);
            condition = true;
        }
        return condition;
    }
    
    public boolean canMakeTreasureVisible(Treasure t) { // Debug_1 : Rewriten with switch, changed bad implementation
        boolean condition = false;
        TreasureKind thisType = t.getType();
        if (hiddenTreasures.contains(t)) { // check if it's in hand
            condition = true;
            // 3 cases according to game rules:
            switch (thisType) {
                case BOTHHANDS :
                    for (Treasure treasure : visibleTreasures) {
                        if ( (treasure.getType() == TreasureKind.BOTHHANDS) 
                           ||(treasure.getType() == TreasureKind.ONEHAND)) {
                            condition = false;
                        }
                    }
                    break; 
                case ONEHAND:
                    boolean hasOne = false;
                    for (Treasure treasure : visibleTreasures) {
                        if (treasure.getType() == TreasureKind.BOTHHANDS) {
                            condition = false;
                        }
                        if (treasure.getType() == TreasureKind.ONEHAND) {
                            if (!hasOne) {
                                hasOne = true;
                            }
                            else {
                                condition = false;
                            }
                        }
                    }
                    break;
                default:
                    for (Treasure treasure : visibleTreasures) {
                        if (treasure.getType() == thisType){
                            condition = false;
                        }
                    }
                    break;
            }
        }
        return condition;
    }
    
    public boolean hasVisibleTreasures() {
        return !visibleTreasures.isEmpty();
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        float levels;
        boolean canI;
        int intLevels;
        levels = computeGoldCoinsValue(visible);
        levels += computeGoldCoinsValue(hidden);
        intLevels = (int)levels; // Debug_1 : float to int conversino added
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
    
    public boolean validState() {
        boolean condition = false;
        if ( pendingBadConsequence.isEmpty()
             && (hiddenTreasures.size() <= MAXHIDDENTREASURES)) { 
            condition = true;
        }
        return condition;
    }
    
    public int getCombatLevel() { // Debug_1 : Fixed wrong output when hasNecklace()==true (It gave base level)
        int output = level;
        if (hasNecklace()) {
            for (Treasure treasure : visibleTreasures) {
                output += treasure.getMaxBonus();
            }
        } else {
            for (Treasure treasure : visibleTreasures) {
                output += treasure.getMinBonus();
            }
        }
        return output;
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
        
    public String toString() {
        return "\"" + this.name + "\" (Level " + Integer.toString(this.level) + " )";
    }
}





















