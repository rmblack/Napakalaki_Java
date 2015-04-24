
package napakalaki;

public class Prize {
    
    // Attributes
    private int treasures;
    private int levels;
    
    // Constructors
    Prize (int treasures, int levels){
        this.levels = levels;
        this.treasures = treasures;
    }
    
    // Getters
    int getTreasures() {
        return treasures;
    }
    int getLevels() {
        return levels;
    }
    
    // Setters
    void setTreasures(int treasures){
        this.treasures = treasures;
    }
    void setLevels (int levels){
        this.levels = levels;
    }
    
    // Class methods
    public String toString() {
        return "Treasures = " + Integer.toString(treasures) +
               " Levels = " + Integer.toString(levels);
    }
}
