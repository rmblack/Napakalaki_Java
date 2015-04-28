
package Model;
    
public class Monster {
    
    /* Attributes */
    private String name;
    private int combatLevel;
    Prize prize;
    BadConsequence badJuju; 
    
    /* Constructors */
    Monster (String name, int combatLevel, Prize prize, BadConsequence badJuju) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badJuju = badJuju;        
    }
    
    /* Getters */
    public String getName() {
        return name;
    }
    public int getCombatLevel() {
        return combatLevel;
    }
    public Prize getPrize() {
        return prize;
    }
    public BadConsequence getBadConsequence() {
        return badJuju;
    }
    
    /* Class methods */
    public String toString() {
        return "Name = \"" + this.name + "\"\nCombat Level = " + Integer.toString(this.combatLevel) +
               "\nPrize: " + this.prize.toString() + "\nBad Juju: " + this.badJuju.toString();
    }
}
