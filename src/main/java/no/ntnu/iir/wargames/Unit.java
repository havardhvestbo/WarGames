package no.ntnu.iir.wargames;

/**
 * A class representing shared characteristics of Units
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public abstract class Unit {

    private String name;
    private int health;
    private int attack;
    private int armor;

    /**
     * Creates an instance of a Unit.
     *
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        if (health > 0) {
            this.health = health;
        }
        else {
            this.health = 0;
        }
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Changes the health of the oppenent after the units attack.
     *
     * @param  opponent heatlh
     */
    protected void attack(Unit opponent){
        int damageAndResistance = opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armor + opponent.getResistBonus());
        opponent.setHealth(damageAndResistance);
        if (damageAndResistance < 0) {
            int opponentsNewHealth = opponent.getHealth() + damageAndResistance;
            opponent.setHealth(opponentsNewHealth);
        }
    }

    /**
     * Returns the name of the unit.
     *
     * @return name og unit.
     */
    protected String getName() {
        return name;
    }

    /**
     * Returns health of the unit.
     *
     * @return health.
     */
    protected int getHealth() {
        return health;
    }

    /**
     * Returns the damage a unit deals.
     *
     * @return attack.
     */
    protected int getAttack() {
        return attack;
    }

    /**
     * Returns the armor level left on the unit
     *
     * @return armor.
     */
    protected int getArmor() {
        return armor;
    }

    /**
     * Changes the health of the unit.
     */
    protected void setHealth(int newHealth) {
       // if (newHealth < 0) {
       //     throw new IllegalArgumentException("Health is invalid");
        //}
        //else {
            health = newHealth;
        //}
    }

    /**
     * Returns information about the unit in form of a string
     *
     * @return a string relevant to the unit.
     */
    @Override
    public String toString() {
        return name+". Health: "+health+". Armor: " + armor+". Attack: "+ attack;

    }

    /**
     * Abstract method of getAttackBonus.
     *
     * @return attackBonus.
     */
    abstract protected int getAttackBonus();

    /**
     * Abstract method of getRessistBonud.
     *
     * @return resistBonus.
     */
    abstract protected int getResistBonus();







}
