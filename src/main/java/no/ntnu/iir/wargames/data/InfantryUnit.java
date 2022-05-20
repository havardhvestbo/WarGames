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
   * @param name
   * @param health
   * @param attack
   * @param armor
   */
  public InfantryUnit(String name, int health, int attack, int armor, Terrain terrain) {
    super(name, health, attack, armor, terrain);
  }

  /**
   * Creates an instance of InfantryUnit with attack and armor.
   *
   * @param name
   * @param health
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
