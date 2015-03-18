/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */


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
            if ( (monster.getBadJuju().getSpecificHiddenTreasures().contains(specific_treasure)) || (monster.getBadJuju().getSpecificVisibleTreasures().contains(specific_treasure)) ) {
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
        
        // * Declarations * //
        
        int num_monstruos = 19;
        ArrayList<Monster> monstruos = new ArrayList();

    
        /*  Asociamos a cada monstruo un número entero para definir sus variables
         *  Por claridad los haremos seguidos.
         *  Nota: no todos tienen las mismas variables, por eso puede haber
         *        numeros no consecutivos a pesar de estar ordenados.
         */
        
        // Monster name text
        String text_name_1 = "Byakhees de bonanza";
        String text_name_2 = "Chibithulhu";
        String text_name_3 = "El sopor de Dunwich";
        String text_name_4 = "Ángeles de la noche ibicenca";
        String text_name_5 = "El gorrón del umbral";
        String text_name_6 = "H.P. Munchcraft";
        String text_name_7 = "Bichgooth";
        String text_name_8 = "El rey de rosa";
        String text_name_9 = "La que redacta en las tinieblas";
        //
        String text_name_10 = "Los hondos";
        String text_name_11 = "Semillas Cthulhu";
        String text_name_12 = "Dameargo";
        String text_name_13 = "Pollipólipo volante";
        String text_name_14 = "Yskhtihyssg-Goth";
        String text_name_15 = "Familia feliz";
        String text_name_16 = "Roboggoth";
        String text_name_17 = "El espia";
        String text_name_18 = "El Lenguas";
        //
        String text_name_19 = "Bicéfalo";
       
        // Bad Juju text
        String text_badjuju_1 = "Pierdes tu armadura visible y otra oculta.";
        String text_badjuju_2 = "Embobados con el lindo primigenio te descartas de tu casco visible.";
        String text_badjuju_3 = "El primordial bostezo contagioso. Pierdes el calzaco visible.";
        String text_badjuju_4 = "Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.";
        String text_badjuju_5 = "Pierdes todos tus tesoros visibles.";
        String text_badjuju_6 = "Pierdes la armadura visible.";
        String text_badjuju_7 = "Sientes bichos bajo la ropa. Descarta tu mano visible.";
        String text_badjuju_8 = "Pierdes 5 niveles y 3 tesoros visibles.";
        String text_badjuju_9 = "Toses los pulmones y pierdes 2 niveles.";
        //
        String text_badjuju_10 = "Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.";
        String text_badjuju_11 = "Pierdes 2 niveles y 2 tesoros ocultos.";
        String text_badjuju_12 = "Te intentas escaquear. Pierdes una mano visible.";
        String text_badjuju_13 = "Da mucho asquito, Pierdes 3 niveles.";
        String text_badjuju_14 = "No le hace gracia que pronuncien mal su nombre. Estás muerto.";
        String text_badjuju_15 = "La familia te atrapa, Estás muerto.";
        String text_badjuju_16 = "La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.";
        String text_badjuju_17 = "Te asusta en la noche. Pierdes un casco visible.";
        String text_badjuju_18 = "Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.";
        //
        String text_badjuju_19 = "Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.";
         
        // Prize
        Prize prize_1 = new Prize (2, 1);
        Prize prize_2 = new Prize (1, 1);
        Prize prize_3 = new Prize (1, 1);
        Prize prize_4 = new Prize (4, 1);
        Prize prize_5 = new Prize (3, 1);
        Prize prize_6 = new Prize (2, 1);
        Prize prize_7 = new Prize (1, 1);
        Prize prize_8 = new Prize (4, 2);
        Prize prize_9 = new Prize (1, 1);
        //
        Prize prize_10 = new Prize (2, 1);
        Prize prize_11 = new Prize (2, 1);
        Prize prize_12 = new Prize (2, 1);
        Prize prize_13 = new Prize (1, 1);
        Prize prize_14 = new Prize (3, 1);
        Prize prize_15 = new Prize (4, 1);
        Prize prize_16 = new Prize (2, 1);
        Prize prize_17 = new Prize (1, 1);
        Prize prize_18 = new Prize (1, 1);
        //
        Prize prize_19 = new Prize (1, 1);
        
        // ArrayList para tesoros visibles y ocultos
        ArrayList<TreasureKind> list_v_1 = new ArrayList(Arrays.asList(TreasureKind.ARMOR));
        ArrayList<TreasureKind> list_h_1 = new ArrayList(Arrays.asList(TreasureKind.ARMOR));
        ArrayList<TreasureKind> list_v_2 = new ArrayList(Arrays.asList(TreasureKind.HELMET));
        ArrayList<TreasureKind> list_h_2 = new ArrayList();
        ArrayList<TreasureKind> list_v_3 = new ArrayList(Arrays.asList(TreasureKind.SHOE));
        ArrayList<TreasureKind> list_h_3 = new ArrayList();
        ArrayList<TreasureKind> list_v_4 = new ArrayList(Arrays.asList(TreasureKind.ONEHAND));
        ArrayList<TreasureKind> list_h_4 = new ArrayList(Arrays.asList(TreasureKind.ONEHAND));
        ArrayList<TreasureKind> list_v_6 = new ArrayList(Arrays.asList(TreasureKind.ARMOR));
        ArrayList<TreasureKind> list_h_6 = new ArrayList();
        ArrayList<TreasureKind> list_v_7 = new ArrayList(Arrays.asList(TreasureKind.ARMOR));
        ArrayList<TreasureKind> list_h_7 = new ArrayList();
        ArrayList<TreasureKind> list_v_12 = new ArrayList(Arrays.asList(TreasureKind.ONEHAND));
        ArrayList<TreasureKind> list_h_12 = new ArrayList();
        ArrayList<TreasureKind> list_v_16 = new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS));
        ArrayList<TreasureKind> list_h_16 = new ArrayList();
        ArrayList<TreasureKind> list_v_17 = new ArrayList(Arrays.asList(TreasureKind.HELMET));
        ArrayList<TreasureKind> list_h_17 = new ArrayList();
        ArrayList<TreasureKind> list_v_19 = new ArrayList(Arrays.asList(TreasureKind.ONEHAND , TreasureKind.BOTHHANDS));
        ArrayList<TreasureKind> list_h_19 = new ArrayList();
        
        // BadConsequence
        BadConsequence bc_1 = new BadConsequence(text_badjuju_1, 0, list_v_1, list_h_1);
        BadConsequence bc_2 = new BadConsequence(text_badjuju_2, 0, list_v_2, list_h_2);
        BadConsequence bc_3 = new BadConsequence(text_badjuju_3, 0, list_v_3, list_h_3);
        BadConsequence bc_4 = new BadConsequence(text_badjuju_4, 0, list_v_4, list_h_4);
        BadConsequence bc_5 = new BadConsequence(text_badjuju_5, 0, Integer.MAX_VALUE, 0);
        BadConsequence bc_6 = new BadConsequence(text_badjuju_6, 0, list_v_6, list_h_6);
        BadConsequence bc_7 = new BadConsequence(text_badjuju_7, 0, list_v_7, list_h_7);
        BadConsequence bc_8 = new BadConsequence(text_badjuju_8, 5, 3, 0);
        BadConsequence bc_9 = new BadConsequence(text_badjuju_9, 2, 0, 0);
        //
        BadConsequence bc_10 = new BadConsequence(text_badjuju_10, true);
        BadConsequence bc_11 = new BadConsequence(text_badjuju_11, 2, 0, 2);
        BadConsequence bc_12 = new BadConsequence(text_badjuju_12, 0, list_v_12, list_h_12);
        BadConsequence bc_13 = new BadConsequence(text_badjuju_13, 3, 0, 0);
        BadConsequence bc_14 = new BadConsequence(text_badjuju_14, true);
        BadConsequence bc_15 = new BadConsequence(text_badjuju_15, true);
        BadConsequence bc_16 = new BadConsequence(text_badjuju_16, 2, list_v_16, list_h_16);
        BadConsequence bc_17 = new BadConsequence(text_badjuju_17, 0, list_v_17, list_h_17);
        BadConsequence bc_18 = new BadConsequence(text_badjuju_18, 2, 5, 0);
        //
        BadConsequence bc_19 = new BadConsequence(text_badjuju_19, 3, list_v_19, list_h_19);
        
        // Monstruos 
        /* cada Prize y Badconsequence es distinto, por lo que éstos no se han
         * escrito en un array debido a que no hay relación entre ellos.
         * En consecuencia los Monster no se declaranen un array por la falta de
         * iteradores a la hora de cambiar los parámetros de sus constructores
         */
        Monster monstruo_1 = new Monster(text_name_1, 8, prize_1, bc_1);
        Monster monstruo_2 = new Monster(text_name_2, 2, prize_2, bc_2);
        Monster monstruo_3 = new Monster(text_name_3, 2, prize_3, bc_3);
        Monster monstruo_4 = new Monster(text_name_4, 14, prize_4, bc_4);
        Monster monstruo_5 = new Monster(text_name_5, 10, prize_5, bc_5);
        Monster monstruo_6 = new Monster(text_name_6, 6, prize_6, bc_6);
        Monster monstruo_7 = new Monster(text_name_7, 2, prize_7, bc_7);
        Monster monstruo_8 = new Monster(text_name_8, 13, prize_8, bc_8);
        Monster monstruo_9 = new Monster(text_name_9, 2, prize_9, bc_9);
        Monster monstruo_10 = new Monster(text_name_10, 8, prize_10, bc_10);
        Monster monstruo_11 = new Monster(text_name_11, 4, prize_11, bc_11);
        Monster monstruo_12 = new Monster(text_name_12, 1, prize_12, bc_12);
        Monster monstruo_13 = new Monster(text_name_13, 3, prize_13, bc_13);
        Monster monstruo_14 = new Monster(text_name_14, 12, prize_14, bc_14);
        Monster monstruo_15 = new Monster(text_name_15, 1, prize_15, bc_15);
        Monster monstruo_16 = new Monster(text_name_16, 8, prize_16, bc_16);
        Monster monstruo_17 = new Monster(text_name_17, 5, prize_17, bc_17);
        Monster monstruo_18 = new Monster(text_name_18, 20, prize_18, bc_18);
        Monster monstruo_19 = new Monster(text_name_19, 20, prize_19, bc_19);
        
        
        // * Body * //
        
        monstruos.add(monstruo_1);
        monstruos.add(monstruo_2);
        monstruos.add(monstruo_3);
        monstruos.add(monstruo_4);
        monstruos.add(monstruo_5);
        monstruos.add(monstruo_6);
        monstruos.add(monstruo_7);
        monstruos.add(monstruo_8);
        monstruos.add(monstruo_9);
        monstruos.add(monstruo_10);
        monstruos.add(monstruo_11);
        monstruos.add(monstruo_12);
        monstruos.add(monstruo_13);
        monstruos.add(monstruo_14);
        monstruos.add(monstruo_15);
        monstruos.add(monstruo_16);
        monstruos.add(monstruo_17);
        monstruos.add(monstruo_18);
        monstruos.add(monstruo_19);

        // Consulta monstruo nivel>10
        consulta_monstruo_nivel_minimo(monstruos, 10);
        
        // Consulta mal rollo solo pierde niveles
        System.out.println("Monstruos que solo causen pérdida de nivel:");
        for (Monster monster : monstruos) {
            if (monster.getBadJuju().getLevels() != 0
                    && monster.getBadJuju().getNHiddenTreasures() == 0 
                    && monster.getBadJuju().getNVisibleTreasures() == 0) {
                System.out.println(monster.toString());
            }
        }
        
        // Consulta buen rollo da nivel>1
        consulta_buenrollo_nivel(monstruos, 1);
        
        // Consulta mal rollo pierde tesoro ONEHAND (visible u oculto)
        consulta_malrollo_especifico (monstruos, TreasureKind.ONEHAND);
        

    }
    
}
        
    /* INITIAL TEST CODE 

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
