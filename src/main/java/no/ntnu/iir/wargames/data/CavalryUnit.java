package no.ntnu.iir.wargames.data;

/**
 * A subclass of class Unit representing a CavalryUnit
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class CavalryUnit extends Unit {

  private int numAttacks = 0;

  /**
   * Creates an instance of CavalryUnit.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param attack unit's attack.
   * @param armor unit's armor.
   * @param terrain unit's terrain.
   */
  public CavalryUnit(String name, int health, int attack, int armor, Terrain terrain) {
    super(name, health, attack, armor, terrain);
  }
  /**
   * Simplified constructor of CavalryUnit with set attack and armor.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's Terrain.
   */
  public CavalryUnit(String name, int health, Terrain terrain) {
    super(name, health, 20, 12, terrain);
  }
  @Override
  public int getAttackBonus() {
    int attackBonus = 2;
    if(numAttacks < 1) {
      numAttacks = numAttacks + 1;
      attackBonus = 6;
    }
    if(getTerrain() == Terrain.PLAIN) {
      attackBonus ++;
    }
    return attackBonus;
  }

  @Override
  public int getResistBonus() {
    int resistBonus = 1;
    if(getTerrain() == Terrain.FOREST) {
      resistBonus = 0;
    }
    return resistBonus;
  }
}
