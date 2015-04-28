
package Model;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {
    
    /* Attributes */
    private static Napakalaki instance = null;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private Monster currentMonster;
    
    /* Private Constructor - Singleton build */
    private Napakalaki() {
        currentPlayerIndex = -1; // Indicates game is unstarted
        players = new ArrayList();
        currentPlayer = new Player("null_player");
    }
    
    /* Private functions */
    
    private void initPlayers(ArrayList<String> names) {
        for (String name : names) {
            players.add(new Player(name));
        }
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
    
    /* Public functions */
    
    public void initGame(ArrayList<String> players) {
        CardDealer.getInstance().initCards();
        initPlayers(players);
        nextTurn();
    }
    
    public void discardVisibleTreasure(Treasure t) {
        currentPlayer.discardVisibleTreasure(t);
    }
    
    public void discardHiddenTreasure(Treasure t) {
        currentPlayer.discardVisibleTreasure(t);
    }
    
    public boolean makeTreasureVisible(Treasure t) {
        return currentPlayer.makeTreasureVisible(t);
    }
    
    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        return currentPlayer.buyLevels(visible, hidden);
    }

    public boolean canMakeTreasureVisible(Treasure t) {
        return currentPlayer.canMakeTreasureVisible(t);
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
        boolean condition = true;
        if ( currentPlayer != null ) condition = currentPlayer.validState(); // Debug_1 - When first executed, player is still null
        return condition;
    }
    
    public boolean endOfGame(CombatResult result) {
        boolean state = false;
        if (result == CombatResult.WINANDWINGAME) state = true;
        return state;
    }

    public CombatResult combat() {
        return currentPlayer.combat(currentMonster);
    }
    
    /* Getters */
    public static Napakalaki getInstance() {
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    public ArrayList<Treasure> getVisibleTreasures() {
        return currentPlayer.getVisibleTreasures();
    }  
    public ArrayList<Treasure> getHiddenTreasures() {
        return currentPlayer.getHiddenTreasures();
    }
    
}
