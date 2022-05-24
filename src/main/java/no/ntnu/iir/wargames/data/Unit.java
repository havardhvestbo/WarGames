package no.ntnu.iir.wargames.data;

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
    private Terrain terrain;

    /**
     * Creates an instance of a Unit.
     *
     * @param name unit' name.
     * @param health unit's health.
     * @param attack unit's attack
     * @param armor unit's armor.
     */
    protected Unit(String name, int health, int attack, int armor, Terrain terrain) {
        if (name == null || name.isBlank() || terrain == null || health <= 0) {
            throw new IllegalArgumentException("Wrong input in parameter");
        }
        else {
            this.name = name;
            this.terrain = terrain;
            this.health = health;
        }
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Changes the health of the oppenent after the units attack.
     *
     * @param  opponent heatlh
     */
    public void attack(Unit opponent){
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
    public String getName() {
        return name;
    }

    /**
     * Returns health of the unit.
     *
     * @return health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the damage a unit deals.
     *
     * @return attack.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the armor level left on the unit
     *
     * @return armor.
     */
    public int getArmor() {
        return armor;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain newTerrain) {
        terrain = newTerrain;
    }

    /**
     * Changes the health of the unit.
     */
    public void setHealth(int newHealth) {
            health = newHealth;
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
