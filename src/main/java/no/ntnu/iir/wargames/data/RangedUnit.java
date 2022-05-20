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
   * @param name
   * @param health
   * @param attack
   * @param armor
   */
  public RangedUnit(String name, int health, int attack, int armor, Terrain terrain) {
    super(name, health, attack, armor, terrain);
  }

  /**
   * Creates an instance of RangedUnit with attack and armor.
   * @param name
   * @param health
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
