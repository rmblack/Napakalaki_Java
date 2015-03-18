/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Usuario
 */
public class BadConsequence {
    
    // Attributes
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private java.util.ArrayList<TreasureKind> specificHiddenTreasures;
    private java.util.ArrayList<TreasureKind> specificVisibleTreasures;
    
    // Constructors
    BadConsequence(String text, int levels, 
                   int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        // defaults
        this.death = false;
        this.specificHiddenTreasures = new java.util.ArrayList();
        this.specificVisibleTreasures = new java.util.ArrayList();
    }
    BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = true;
        //defaults
        this.levels = 0;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.specificHiddenTreasures = new java.util.ArrayList();
        this.specificVisibleTreasures = new java.util.ArrayList();
    }
    BadConsequence(String text, int levels,
                   java.util.ArrayList<TreasureKind> tVisible,
                   java.util.ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;

        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();
        //defaults
        death = false;
    }
    
   // Getters
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
    public boolean getDeath() {
        return death;
    }
    public java.util.ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    public java.util.ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    // Class methods
    public String toString() { // REV
        return text; 
    /* Does the text contain this info or do I build it ?
    public String toString() {
        String returnValue;
        if (death) {
            returnValue = "You die Horribly";
        } else {
            ...
        }
    }
    */
    }
}