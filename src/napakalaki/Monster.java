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
public class Monster {
    
    // Attributes
    private String name;
    private int combatLevel;
    Prize prize;
    BadConsequence badJuju; 
    
    // Constructors
    Monster (String name, int combatLevel, Prize prize, BadConsequence badJuju) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badJuju = badJuju;        
    }
    
    // Getters
    public String getName() {
        return name;
    }
    public int getCombatLevel() {
        return combatLevel;
    }
    public Prize getPrize() {
        return prize;
    }
    public BadConsequence getBadJuju() {
        return badJuju;
    }
    
    // Class methods
    public String toString() {
        return "Name = \"" + name + "\" Combat Level = " + Integer.toString(combatLevel) +
               "; Prize: " + prize.toString() + " ; Bad Juju: " + badJuju.toString();
    }
}
