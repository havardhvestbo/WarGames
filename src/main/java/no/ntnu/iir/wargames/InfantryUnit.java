package no.ntnu.iir.wargames;

/**
 * A subclass of class Unit representing a InfantryUnit
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class InfantryUnit extends Unit {

  /**
   * Creates an instance of InfantryUnit
   * @param name
   * @param health
   * @param attack
   * @param armor
   */
  public InfantryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Creates an instance of InfantryUnit with attack and armor.
   * @param name
   * @param health
   */
  public InfantryUnit(String name, int health) {
    super(name, health, 15, 10);
  }

  /**
   * Returns the unit´s attack bonus.
   *
   * @return int
   */
  public int getAttackBonus() {
    return 2;
  }

  /**
   * Returns the unit´s resist bonus.
   *
   * @return int
   */
  public int getResistBonus() {
    return 1;
  }
}
