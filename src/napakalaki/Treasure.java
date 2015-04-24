
package napakalaki;

public class Treasure {
    
    // Attributes
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    // Constructors
    Treasure(String name, int goldCoins, int minBonus,
             int maxBonus, TreasureKind type) {
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }
    
    // Getters
    String getName() {
        return name;
    }
    int getGoldCoins() {
        return goldCoins;
    }
    int getMinBonus() {
        return minBonus;
    }
    int getMaxBonus() {
        return maxBonus;
    }
    TreasureKind getType() {
        return type;
    }
    
}
