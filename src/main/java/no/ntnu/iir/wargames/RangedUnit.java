package no.ntnu.iir.wargames;

/**
 * A subclass of class Unit representing a RangedUnit
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class RangedUnit extends Unit {

  private int numAttacks = 3;

  /**
   * Creates an instance of RangedUnit
   * @param name
   * @param health
   * @param attack
   * @param armor
   */
  public RangedUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Creates an instance of RangedUnit with attack and armor.
   * @param name
   * @param health
   */
  public RangedUnit(String name, int health) {
    super(name, health, 15, 8);
  }

  /**
   * Returns the unit´s attack bonus.
   *
   * @return int
   */
  public int getAttackBonus() {
    return 3;
  }

  /**
   * Returns the unit´s resist bonus.
   *
   * @return int
   */
  public int getResistBonus() {
    int value = numAttacks*2;
    numAttacks--;
    if(value <=2){
      return 2;
    }
    return value;
  }
}
