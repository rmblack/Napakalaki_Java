/* File is obsolete, many code has ben moved to class methods
 */
package Model;

import java.util.Arrays;
import java.util.ArrayList;

public class PruebaNapakalaki {

    // * Funciones de Consulta * //
    
    // Indica los munstruos con nivel superior a cierto valor
    public static void consulta_monstruo_nivel_minimo (ArrayList<Monster> monsters, int level ) {
        boolean hay_monstruos = false;
        System.out.println("Monstruos de nivel superior a " + level + ":");
        for (Monster monster : monsters) {
            if ( monster.getCombatLevel() > level) {
                System.out.println( monster.toString());
                hay_monstruos = true;
            }
        }
        if ( !hay_monstruos) {
            System.out.println("No hay ninguno.");
        }
    }
    
    /* UNUSED AUX FUNCTION CODE
    // Indica si se pierden al menos ciertos niveles y tesoros visibles/ocultos
    public static void consulta_malrollo_perdidas(ArrayList<Monster> monsters, int level, int nVisibleTreasures, int nHiddenTreasures ) {
        boolean hay_monstruos = false;
        System.out.println( "Monstruos cuyo mal rollo haga perder al menos " + level + " nivel(es), "
                          + nVisibleTreasures + " tesoro(s) visible(s) y " + nHiddenTreasures + " tesoro(s) oculto(s):"); 
        for (Monster monster : monsters) {
            if ( monster.getBadJuju().getLevels() > level 
                    && monster.getBadJuju().getNVisibleTreasures() > nVisibleTreasures
                    && monster.getBadJuju().getNHiddenTreasures() > nHiddenTreasures){
                System.out.println( monster.toString() );
                hay_monstruos = true;                
            }
        }
        if ( !hay_monstruos){
            System.out.println("No hay ninguno.");
        }
    }
    * UP TO HERE
    */
    
    // Indica si algin Prize de los monstruos da mas de cierto nivel
    public static void consulta_buenrollo_nivel(ArrayList<Monster> monsters, int level) {
        boolean hay_monstruos = false;
        System.out.println("Monstruos cuyo buen rollo aumente el nivel en mas de " + level + ":");
        for (Monster monster : monsters) {
            if (monster.getPrize().getLevels() > level) {
                System.out.println(monster.toString());
                hay_monstruos = true;
            }
        }
        if ( !hay_monstruos ) {
            System.out.println("No hay ninguno.");
        }
    }
    
    // Indica un tipo especifico de tesoro a perder
    public static void consulta_malrollo_especifico (ArrayList<Monster> monsters, TreasureKind specific_treasure) {
        boolean hay_monstruos = false;
        System.out.println ("Monstruos cuyo mal rollo haga perder un objeto de tipo " + specific_treasure );
        for (Monster monster : monsters) {
            if ( (monster.getBadConsequence().getSpecificHiddenTreasures().contains(specific_treasure)) || (monster.getBadConsequence().getSpecificVisibleTreasures().contains(specific_treasure)) ) {
                System.out.println(monster.toString());
                hay_monstruos = true;
            }
        }
        if ( !hay_monstruos ) {
            System.out.println("No hay ninguno.");
        }
    }
    
    // * Main * //
    public static void main(String[] args) {
        
        
        /** FIRST PART TESTING.
          * monster array moved to CardDealer class.
          * 
        // Consulta monstruo nivel>10
        consulta_monstruo_nivel_minimo(monstruos, 10);
        
        // Consulta mal rollo solo pierde niveles
        System.out.println("Monstruos que solo causen pérdida de nivel:");
        for (Monster monster : monstruos) {
            if (monster.getBadConsequence().getLevels() != 0
                    && monster.getBadConsequence().getNHiddenTreasures() == 0 
                    && monster.getBadConsequence().getNVisibleTreasures() == 0) {
                System.out.println(monster.toString());
            }
        }
        
        // Consulta buen rollo da nivel>1
        consulta_buenrollo_nivel(monstruos, 1);
        
        // Consulta mal rollo pierde tesoro ONEHAND (visible u oculto)
        consulta_malrollo_especifico (monstruos, TreasureKind.ONEHAND);
        * UP TO HERE
        */

    }
    
}
        
    /** INITIAL TEST CODE 

    // Declarations
    String text1 = "You die Horribly";
    String text2 = "You lose one level. But he's not a bad guy, so you can keep your treaures";
    String output1 = "output1";
    String output2 = "output2";

    Prize testPrize1 = new Prize (2, 2);
    Prize testPrize2 = new Prize (0, 1);

    BadConsequence testBC1 = new BadConsequence (text1, true);
    BadConsequence testBC2 = new BadConsequence (text2, 1, 0, 0);

    Monster testSubject1 = new Monster("Mortal Marty", 10, testPrize1, testBC1);
    Monster testSubject2 = new Monster("Good Guy Greg", 2, testPrize2, testBC2);

    // Body

    output1= testSubject1.toString();
    output2= testSubject2.toString();

    System.out.println(output1);
    System.out.println(output2);
    * 
    * UP TO HERE
    */
