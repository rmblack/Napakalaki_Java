
package Model;

import java.util.ArrayList;
        
public class BadConsequence {
    
    /* Attributes */
    private String text;
    private int levels;
    private int nVisibleTreasures; // | Theese do not count the ArrayLists
    private int nHiddenTreasures;  // | with specific treasures.
    private boolean death;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    
    /* Constructors */
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
    }
    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        this.levels = 0;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
    }
    public BadConsequence(String text, int levels,
                   ArrayList<TreasureKind> tVisible,
                   ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;

        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        death = false;
    }
    public BadConsequence(BadConsequence original) { // Copy constructor
        this.death = original.death;
        this.levels = original.levels;
        this.nVisibleTreasures = original.nVisibleTreasures;
        this.nHiddenTreasures = original.nHiddenTreasures;
        this.text = original.text;
        this.specificHiddenTreasures = new ArrayList<TreasureKind>(original.specificHiddenTreasures);
        this.specificVisibleTreasures = new ArrayList<TreasureKind>(original.specificVisibleTreasures);
    }
    
   /* Getters */
    public String getText() {
        return text;
    }
    public int getLevels() {
        return levels;
    }
    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }
    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }
    public boolean /*getDeath*/ kills() {
        return death;
    }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    /* Public functions */
    
    public void clone(BadConsequence original) {
        this.death = original.death;
        this.levels = original.levels;
        this.nVisibleTreasures = original.nVisibleTreasures;
        this.nHiddenTreasures = original.nHiddenTreasures;
        this.text = original.text;
        this.specificHiddenTreasures.addAll(original.specificHiddenTreasures);
        this.specificVisibleTreasures.addAll(original.specificVisibleTreasures);
    }
    
    public void substractVisibleTreasure(Treasure t) {
        TreasureKind type = t.getType();
        if (specificVisibleTreasures.contains(type)) { // REV: Does remove fail¿?
            specificVisibleTreasures.remove(type);
        }
        this.nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure(Treasure t) {
        TreasureKind type = t.getType();
        if (specificHiddenTreasures.contains(type)) { // REV: Does remove fail ¿?
            specificHiddenTreasures.remove(type);
        }
        this.nHiddenTreasures--;
    }

    public boolean isEmpty() {
        boolean output = false;
        if (levels == 0 &
            nVisibleTreasures <= 0 &  // Player may choose to discard more treasures than needed
            nHiddenTreasures <= 0 &   // "
            specificVisibleTreasures.isEmpty() &
            specificHiddenTreasures.isEmpty() &
            !death) {
            output = true;
        }
        return output;
    }
 
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        BadConsequence pendingBC;
        if ( this.nHiddenTreasures == 0 & this.nVisibleTreasures == 0) {
            ArrayList<TreasureKind> vKind = new ArrayList();
            ArrayList<TreasureKind> hKind = new ArrayList();
            ArrayList<TreasureKind> pendingVisible = new ArrayList();
            ArrayList<TreasureKind> pendingHidden = new ArrayList();
            // Form Arrays with the visible & hidden TreasureKinds
            for (Treasure t : v) {
                vKind.add(t.getType());
            }
            for (Treasure t : h) {
                hKind.add(t.getType());
            }
            // If they share a TreasureKind with this, it's added to the pending Array
            for (TreasureKind type : this.specificVisibleTreasures) {
                if (vKind.contains(type)) pendingVisible.add(type);
            }
            for (TreasureKind type : this.specificHiddenTreasures) {
                if (hKind.contains(type)) pendingHidden.add(type);
            }
            /* Edit: "fails to discard two of kind :ONEHAND"
             * Gamre rules do not mix both constructs
             */    
            pendingBC = new BadConsequence("", 0, pendingVisible, pendingHidden);
        }
        else { /* There's no specifics, just use the maximum possible number */
            int vNum = (this.nVisibleTreasures < v.size()) ? this.nVisibleTreasures : v.size();
            int hNum = (this.nHiddenTreasures < h.size()) ? this.nHiddenTreasures : h.size();
            pendingBC = new BadConsequence("", 0, vNum, hNum);
        }
        return pendingBC;
    }
    
    public String toString() {
        return text;
    }
}