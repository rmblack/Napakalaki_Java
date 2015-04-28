
package Model;

public class Prize {
    
    /* Attributes */
    private int treasures;
    private int levels;
    
    /* Constructors */
    Prize (int treasures, int levels){
        this.levels = levels;
        this.treasures = treasures;
    }
    
    /* Getters */
    public int getTreasures() {
        return treasures;
    }
    public int getLevels() {
        return levels;
    }
    
    /* Setters */
    public void setTreasures(int treasures){
        this.treasures = treasures;
    }
    public void setLevels (int levels){
        this.levels = levels;
    }
    
    /* Functions */
    public String toString() {
        return "Treasures = " + Integer.toString(treasures) +
               " Levels = " + Integer.toString(levels);
    }
}
