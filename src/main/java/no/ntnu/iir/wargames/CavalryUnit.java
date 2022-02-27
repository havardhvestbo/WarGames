package no.ntnu.iir.wargames;

/**
 * A subclass of class Unit representing a CavalryUnit
 *
 * @author Håvard H. Vestbø
 * @version snapshot 1.0
 */
public class CavalryUnit extends Unit {

  private int numAttacks = 0;

  /**
   * Creates an instance of CavalryUnit
   * @param name
   * @param health
   * @param attack
   * @param armor
   */
  public CavalryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }
  /**
   * Creates an instance of CavalryUnit with attack and armor.
   * @param name
   * @param health
   */
  public CavalryUnit(String name, int health) {
    super(name, health, 20, 12);
  }
  /**
   * Returns the unit´s attack bonus.
   *
   * @return int
   */
  public int getAttackBonus() {
    if (numAttacks == 0) {
      numAttacks++;
      return 4+2;
    }
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
