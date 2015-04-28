
package Model;

import java.util.Random;
        
public class Dice {
    
    /* Attributes */
    private static final boolean CHEATMODE = true; /* Used to Debug */
    private static final int CHEATNUMBER = 6;      /* ------------- */
    private static Dice instance = null;
    private static Random generator;
    
    /* Private consturctor - Singleton build */
    private Dice() {
        Random generator;
    }
    
    /* Getters */
    public static Dice getInstance() {
        if (instance == null) {
            instance = new Dice();
            generator = new Random();
        }
        return instance;
    }
    
    /* Instance functions */
    public int nextNumber() {
        if (!CHEATMODE)
        {
        return (generator.nextInt(6 + 1) );
        }
        else
        {
        return CHEATNUMBER;
        }
    }
    
}
