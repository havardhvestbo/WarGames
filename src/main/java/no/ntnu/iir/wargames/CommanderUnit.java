package no.ntnu.iir.wargames;

/**
 * A subclass of class CavalryUnit representing a CommanderUnit
 *
 * @author Håvard H. Vestbø
 * @version snapshot 1.0
 */
public class CommanderUnit extends CavalryUnit {

  /**
   * Creates an instance of CommanderUnit
   * @param name
   * @param health
   * @param attack
   * @param armor
   */
  public CommanderUnit(String name, int health, int attack, int armor) {
    super(name, health, armor, attack);
  }

  /**
   * Creates an instance of CommanderUnit with attack and armor.
   * @param name
   * @param health
   */
  public CommanderUnit(String name, int health) {
    super(name, health, 25, 15);
  }

}
