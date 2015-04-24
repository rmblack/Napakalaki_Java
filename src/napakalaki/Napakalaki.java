
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Napakalaki
 * currentPlayerIndex initializes to -1 to indicate that the game has not
 * started yet
 *  REV: WRONG TURN START, REDO.
 */
public class Napakalaki {
    
    // Attributes
    private static Napakalaki instance = null;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private Monster currentMonster;
    
    // Private Constructor - Singleton build
    private Napakalaki() {
        currentPlayerIndex = -1;
        players = new ArrayList();
        currentPlayer = new Player("null_player");
    }
    
    // Private functions
    private void initPlayers(ArrayList<String> names) {
        for (String name : names) players.add(new Player(name));
    }
    
    public Player nextPlayer() {
        if (currentPlayerIndex == -1) { // first turn
            Random generator = new Random();
            currentPlayerIndex = generator.nextInt(players.size());
        } else {
            currentPlayerIndex = (currentPlayerIndex+1) % players.size();
        }
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }
    
    // Public Functions
    public CombatResult combat() {
        return currentPlayer.combat(currentMonster);
    }
    
    public void discardVisibleTreasure(Treasure t) {
        currentPlayer.discardVisibleTreasure(t);
    }
    
    public void discardHiddenTreasure(Treasure t) {
        currentPlayer.discardVisibleTreasure(t);
    }
    
    public boolean makeTreasureVisible(Treasure t) {
        boolean condition;
        condition = currentPlayer.makeTreasureVisible(t);
        return condition;
    }
    
    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        boolean condition;
        condition = currentPlayer.buyLevels(visible, hidden);
        return condition;
    }
    
    public void initGame(ArrayList<String> players) {
        CardDealer.getInstance().initCards();
        initPlayers(players);
        nextTurn();
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean canMakeTreasureVisible(Treasure t) {
        return currentPlayer.canMakeTreasureVisible(t);
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return currentPlayer.getVisibleTreasures();
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return currentPlayer.getHiddenTreasures();
    }
    
    public boolean nextTurn() {
        boolean condition = false;
        if (nextTurnAllowed()) {
            currentMonster = CardDealer.getInstance().nextMonster();
            currentPlayer = nextPlayer();
            if (currentPlayer.isDead()) {
                currentPlayer.initTreasures();
            }
            condition = true;   
        }
        return condition;
    }
    
    public boolean nextTurnAllowed() {
        return currentPlayer.validState();
    }
    
    public boolean endOfGame(CombatResult result) {
        boolean state = false;
        if (result == CombatResult.WINANDWINGAME) state = true;
        return state;
    }
    
    // Attribute Getters
    public static Napakalaki getInstance() {
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }
}
