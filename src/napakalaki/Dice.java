
package napakalaki;

import java.util.Random;
        
public class Dice {
    
    // Attributes
    private static Dice instance = null;
    private static Random generator;
    
    // Private consturctor - Singleton build
    private Dice() {
        Random generator;
    }
    
    // Getters
    public static Dice getInstance() {
        if (instance == null) {
            instance = new Dice();
            generator = new Random();
        }
        return instance;
    }
    
    // Instance functions
    public int nextNumber() {
        return (generator.nextInt(6 + 1) );
    }
    
}
