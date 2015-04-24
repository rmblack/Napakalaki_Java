
package napakalaki;
    
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
    public BadConsequence getBadConsequence() {
        return badJuju;
    }
    
    // Class methods
    public String toString() {
        return "Name = \"" + name + "\" Combat Level = " + Integer.toString(combatLevel) +
               "; Prize: " + prize.toString() + " ; Bad Juju: " + badJuju.toString();
    }
}
