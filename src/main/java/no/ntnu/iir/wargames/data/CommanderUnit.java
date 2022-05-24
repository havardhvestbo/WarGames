package no.ntnu.iir.wargames.data;

/**
 * A subclass of class CavalryUnit representing a CommanderUnit
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class CommanderUnit extends CavalryUnit {

  /**
   * Creates an instance of CommanderUnit.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param attack unit's attack.
   * @param armor unit's armor.
   * @param terrain unit's terrain.
   */
  public CommanderUnit(String name, int health, int attack, int armor, Terrain terrain) {
    super(name, health, armor, attack, terrain);
  }

  /**
   * Simplified constructor of CommanderUnit with attack and armor.
   *
   * @param name unit's name.
   * @param health unit's health.
   */
  public CommanderUnit(String name, int health, Terrain terrain) {
    super(name, health, 25, 15, terrain);
  }

}
