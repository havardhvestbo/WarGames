package no.ntnu.iir.wargames.data;

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
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param attack unit's attack.
   * @param armor unit's armor.
   * @param terrain unit's terrain.
   */
  public RangedUnit(String name, int health, int attack, int armor, Terrain terrain) {
    super(name, health, attack, armor, terrain);
  }

  /**
   * Creates an instance of RangedUnit with attack and armor.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's Terrain.
   */
  public RangedUnit(String name, int health, Terrain terrain) {
    super(name, health, 15, 8, terrain);
  }

  @Override
  public int getAttackBonus() {
    int attackBonus = 3;
    if (getTerrain() == Terrain.HILL) {
      attackBonus ++;
    }
    else if (getTerrain() == Terrain.FOREST) {
      attackBonus --;
    }
    return attackBonus;
  }

  @Override
  public int getResistBonus() {
    int value = numAttacks*2;
    numAttacks--;
    if(value <=2){
      return 2;
    }
    return value;
  }
}
