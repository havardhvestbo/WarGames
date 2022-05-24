package no.ntnu.iir.wargames.data;

/**
 * A subclass of class Unit representing a InfantryUnit
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class InfantryUnit extends Unit {

  /**
   * Creates an instance of InfantryUnit
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param attack unit's attack.
   * @param armor unit's armor.
   * @param terrain unit's terrain.
   */
  public InfantryUnit(String name, int health, int attack, int armor, Terrain terrain) {
    super(name, health, attack, armor, terrain);
  }

  /**
   * Creates an instance of InfantryUnit with attack and armor.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's Terrain.
   */
  public InfantryUnit(String name, int health, Terrain terrain) {
    super(name, health, 15, 10, terrain);
  }

  @Override
  public int getAttackBonus() {
    int attackBonus = 2;
    if (getTerrain() == Terrain.FOREST) {
      attackBonus++;
    }
    return attackBonus;
  }

  @Override
  public int getResistBonus() {
    int resistBonus = 1;
    if (getTerrain() == Terrain.FOREST) {
      resistBonus++;
    }
    return resistBonus;
  }
}
