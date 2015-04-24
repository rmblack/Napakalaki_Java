
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardDealer {
    
    // Attributes
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private static final int NUM_MONSTRUOS = 19; // ADDED
    
    // Private Constructor - Singleton build
    private CardDealer() {
    unusedMonsters = new ArrayList<Monster>();
    usedMonsters = new ArrayList<Monster>();
    unusedTreasures = new ArrayList<Treasure>();
    usedTreasures = new ArrayList<Treasure>();
    }

    // Private functions
    
    private void initMonsterCardDeck() {
        /*  Asociamos a cada monstruo un número entero para identificar sus atributos
         *  empezando por el 1 hasta el numero total de monstruos
         *  Nota: no todos tienen los mismos atributos
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
        String text_name_10 = "Los hondos";
        String text_name_11 = "Semillas Cthulhu";
        String text_name_12 = "Dameargo";
        String text_name_13 = "Pollipólipo volante";
        String text_name_14 = "Yskhtihyssg-Goth";
        String text_name_15 = "Familia feliz";
        String text_name_16 = "Roboggoth";
        String text_name_17 = "El espia";
        String text_name_18 = "El Lenguas";
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
        String text_badjuju_10 = "Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.";
        String text_badjuju_11 = "Pierdes 2 niveles y 2 tesoros ocultos.";
        String text_badjuju_12 = "Te intentas escaquear. Pierdes una mano visible.";
        String text_badjuju_13 = "Da mucho asquito, Pierdes 3 niveles.";
        String text_badjuju_14 = "No le hace gracia que pronuncien mal su nombre. Estás muerto.";
        String text_badjuju_15 = "La familia te atrapa, Estás muerto.";
        String text_badjuju_16 = "La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.";
        String text_badjuju_17 = "Te asusta en la noche. Pierdes un casco visible.";
        String text_badjuju_18 = "Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.";
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
        BadConsequence bc_9 = new BadConsequence(text_badjuju_9, 2, 0, 0);        //
        BadConsequence bc_10 = new BadConsequence(text_badjuju_10, true);
        BadConsequence bc_11 = new BadConsequence(text_badjuju_11, 2, 0, 2);
        BadConsequence bc_12 = new BadConsequence(text_badjuju_12, 0, list_v_12, list_h_12);
        BadConsequence bc_13 = new BadConsequence(text_badjuju_13, 3, 0, 0);
        BadConsequence bc_14 = new BadConsequence(text_badjuju_14, true);
        BadConsequence bc_15 = new BadConsequence(text_badjuju_15, true);
        BadConsequence bc_16 = new BadConsequence(text_badjuju_16, 2, list_v_16, list_h_16);
        BadConsequence bc_17 = new BadConsequence(text_badjuju_17, 0, list_v_17, list_h_17);
        BadConsequence bc_18 = new BadConsequence(text_badjuju_18, 2, 5, 0);
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

        unusedMonsters.add(monstruo_1);
        unusedMonsters.add(monstruo_2);
        unusedMonsters.add(monstruo_3);
        unusedMonsters.add(monstruo_4);
        unusedMonsters.add(monstruo_5);
        unusedMonsters.add(monstruo_6);
        unusedMonsters.add(monstruo_7);
        unusedMonsters.add(monstruo_8);
        unusedMonsters.add(monstruo_9);
        unusedMonsters.add(monstruo_10);
        unusedMonsters.add(monstruo_11);
        unusedMonsters.add(monstruo_12);
        unusedMonsters.add(monstruo_13);
        unusedMonsters.add(monstruo_14);
        unusedMonsters.add(monstruo_15);
        unusedMonsters.add(monstruo_16);
        unusedMonsters.add(monstruo_17);
        unusedMonsters.add(monstruo_18);
        unusedMonsters.add(monstruo_19);

    }
    
    private void initTreasureCardDeck() {
        
        String text_treasure_1 = "¡Sí mi amo!";
        String text_treasure_2 = "Botas de investigación";
        String text_treasure_3 = "Capucha de Cthulhu";
        String text_treasure_4 = "A prueba de babas";
        String text_treasure_5 = "Botas de lluvia ácida";
        String text_treasure_6 = "Casco minero";
        String text_treasure_7 = "Ametrallaoora Thompson";
        String text_treasure_8 = "Camiseta de la UGR";
        String text_treasure_9 = "Clavo de rail ferroviario";
        String text_treasure_10 = "Cuchillo de sushi arcano";
        String text_treasure_11 = "Fez alópodo";
        String text_treasure_12 = "Hacha prehistórica";
        String text_treasure_13 = "El apartado del Pr. Tesla";
        String text_treasure_14 = "Gaita";
        String text_treasure_15 = "Insecticida";
        String text_treasure_16 = "Escopeta de 3 cañones";
        String text_treasure_17 = "Garabato místico";
        String text_treasure_18 = "La fuerza de Mr.T";
        String text_treasure_19 = "La rebeca metálica";
        String text_treasure_20 = "Mazo de los antiguos";
        String text_treasure_21 = "Necro-playboycón";
        String text_treasure_22 = "Lanzallamas";
        String text_treasure_23 = "Necrocomicón";
        String text_treasure_24 = "Necronomicón";
        String text_treasure_25 = "Linterna a 2 manos";
        String text_treasure_26 = "Necro-gnomicón";
        String text_treasure_27 = "Necrotelecom";
        String text_treasure_28 = "Porra preternatural";
        String text_treasure_29 = "Tentáculo de pega";
        String text_treasure_30 = "Zapato deja-amigos";
        String text_treasure_31 = "Shogulador";
        String text_treasure_32 = "Varita de atizamiento";
        
        Treasure treasure_1  = new Treasure(text_treasure_1, 0, 4, 7, TreasureKind.HELMET);
        Treasure treasure_2  = new Treasure(text_treasure_2, 600, 3, 4, TreasureKind.SHOE);
        Treasure treasure_3  = new Treasure(text_treasure_3, 500, 3, 5, TreasureKind.HELMET);
        Treasure treasure_4  = new Treasure(text_treasure_4, 400, 2, 5, TreasureKind.ARMOR);
        Treasure treasure_5  = new Treasure(text_treasure_5, 800, 1, 1, TreasureKind.SHOE);
        Treasure treasure_6  = new Treasure(text_treasure_6, 400, 2, 4, TreasureKind.HELMET);
        Treasure treasure_7  = new Treasure(text_treasure_7, 600, 4, 8, TreasureKind.BOTHHANDS);
        Treasure treasure_8  = new Treasure(text_treasure_8, 100, 1, 7, TreasureKind.ARMOR);
        Treasure treasure_9  = new Treasure(text_treasure_9, 400, 3, 6, TreasureKind.ONEHAND);
        Treasure treasure_10 = new Treasure(text_treasure_10, 300, 2, 3, TreasureKind.ONEHAND);
        Treasure treasure_11 = new Treasure(text_treasure_11, 700, 3, 5, TreasureKind.HELMET);
        Treasure treasure_12 = new Treasure(text_treasure_12, 500, 2, 5, TreasureKind.ONEHAND);
        Treasure treasure_13 = new Treasure(text_treasure_13, 900, 4, 8, TreasureKind.ARMOR);
        Treasure treasure_14 = new Treasure(text_treasure_14, 500, 4, 5, TreasureKind.BOTHHANDS);
        Treasure treasure_15 = new Treasure(text_treasure_15, 300, 2, 3, TreasureKind.ONEHAND);
        Treasure treasure_16 = new Treasure(text_treasure_16, 700, 4, 6, TreasureKind.BOTHHANDS);
        Treasure treasure_17 = new Treasure(text_treasure_17, 300, 2, 2, TreasureKind.ONEHAND);
        Treasure treasure_18 = new Treasure(text_treasure_18, 1000, 0, 0, TreasureKind.NECKLACE);
        Treasure treasure_19 = new Treasure(text_treasure_19, 400, 2, 3, TreasureKind.ARMOR);
        Treasure treasure_20 = new Treasure(text_treasure_20, 200, 3, 4, TreasureKind.ONEHAND);
        Treasure treasure_21 = new Treasure(text_treasure_21, 300, 3, 5, TreasureKind.ONEHAND);
        Treasure treasure_22 = new Treasure(text_treasure_22, 800, 4, 8, TreasureKind.BOTHHANDS);
        Treasure treasure_23 = new Treasure(text_treasure_23, 100, 1, 1, TreasureKind.ONEHAND);
        Treasure treasure_24 = new Treasure(text_treasure_24, 800, 5, 7, TreasureKind.BOTHHANDS);
        Treasure treasure_25 = new Treasure(text_treasure_25, 400, 3, 6, TreasureKind.BOTHHANDS);
        Treasure treasure_26 = new Treasure(text_treasure_26, 200, 2, 4, TreasureKind.ONEHAND);
        Treasure treasure_27 = new Treasure(text_treasure_27, 300, 2, 3, TreasureKind.HELMET);
        Treasure treasure_28 = new Treasure(text_treasure_28, 200, 2, 3, TreasureKind.ONEHAND);
        Treasure treasure_29 = new Treasure(text_treasure_29, 200, 0, 1, TreasureKind.HELMET);
        Treasure treasure_30 = new Treasure(text_treasure_30, 500, 0, 1, TreasureKind.SHOE);
        Treasure treasure_31 = new Treasure(text_treasure_31, 600, 1, 1, TreasureKind.BOTHHANDS); 
        Treasure treasure_32 = new Treasure(text_treasure_32, 400, 3, 4, TreasureKind.ONEHAND);        
        
        unusedTreasures.add(treasure_1);
        unusedTreasures.add(treasure_2);
        unusedTreasures.add(treasure_3);
        unusedTreasures.add(treasure_4);
        unusedTreasures.add(treasure_5);
        unusedTreasures.add(treasure_6);
        unusedTreasures.add(treasure_7);
        unusedTreasures.add(treasure_8);
        unusedTreasures.add(treasure_9);
        unusedTreasures.add(treasure_10);
        unusedTreasures.add(treasure_11);
        unusedTreasures.add(treasure_12);
        unusedTreasures.add(treasure_13);
        unusedTreasures.add(treasure_14);
        unusedTreasures.add(treasure_15);
        unusedTreasures.add(treasure_16);
        unusedTreasures.add(treasure_17);
        unusedTreasures.add(treasure_18);
        unusedTreasures.add(treasure_19);
        unusedTreasures.add(treasure_20);
        unusedTreasures.add(treasure_21);
        unusedTreasures.add(treasure_22);
        unusedTreasures.add(treasure_23);
        unusedTreasures.add(treasure_24);
        unusedTreasures.add(treasure_25);
        unusedTreasures.add(treasure_26);
        unusedTreasures.add(treasure_27);
        unusedTreasures.add(treasure_28);
        unusedTreasures.add(treasure_29);
        unusedTreasures.add(treasure_30);
        unusedTreasures.add(treasure_31);
        unusedTreasures.add(treasure_32);
    
    }
    
    private void shuffleTreasures() {
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters() {
        Collections.shuffle(unusedMonsters);
    }
    
    // Public functions
    public Treasure nextTreasure() {
        int lastTreasureIndex = unusedTreasures.size()-1;
        Treasure next = unusedTreasures.get(lastTreasureIndex);
        unusedTreasures.remove(lastTreasureIndex);
        if (lastTreasureIndex == 0) {
            ArrayList<Treasure> swap;
            swap = usedTreasures;
            usedTreasures = unusedTreasures;
            unusedTreasures = swap;
        }
        return next;
    }
    
    public Monster nextMonster() { // REV: DOES NOT TAKE next to usedMonsters
        int lastMonsterIndex = unusedMonsters.size()-1;
        Monster next = unusedMonsters.get(lastMonsterIndex);
        unusedMonsters.remove(lastMonsterIndex);
        if (lastMonsterIndex == 0) {
            ArrayList<Monster> swap;
            swap = unusedMonsters;
            unusedMonsters = usedMonsters;
            usedMonsters = swap;
        }
        return next;
        
    }
    
    public void giveTreasureBack(Treasure t) { // NOT ENTRY SAFE
        usedTreasures.add(t);
        unusedTreasures.remove(t);
    }
    public void giveMonsterBack (Monster m) { // NOT ENTRY SAFE
        usedMonsters.add(m);
        unusedMonsters.remove(m);
    }
    public void initCards() {
        initMonsterCardDeck();
        initTreasureCardDeck();
    }
    
    // Singleton build
            
    public static CardDealer getInstance() {
        if (instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }
    
}
