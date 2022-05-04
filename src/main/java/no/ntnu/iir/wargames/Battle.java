package no.ntnu.iir.wargames;

/**
 * Class simulating the battle between two armies. Returning the winner.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class Battle {

  private Army armyOne;
  private Army armyTwo;

    /**
     * Constructing the battle between the armies.
     *
     * @param armyOne
     * @param armyTwo
     */
  public Battle(Army armyOne, Army armyTwo) {

    this.armyOne = armyOne;
    this.armyTwo = armyTwo;
  }

  /**
   * Method simulating the battle between the two armies.
   *
   * @return winning army
   */
  public Army simulate() {

    while(armyOne.hasUnits() && armyTwo.hasUnits()) {

      Unit unitOne = armyOne.getRandom();
      Unit unitTwo = armyTwo.getRandom();
      unitTwo.attack(unitOne);
      unitOne.attack(unitTwo);
      if (unitTwo.getHealth() == 0) {
        armyTwo.remove(unitTwo);
      }

      if (unitOne.getHealth() == 0) {
        armyOne.remove(unitOne);
      }
    }

    if (armyOne.getAllUnits().isEmpty()) {
      return armyTwo;
    } else if (armyTwo.getAllUnits().isEmpty()) {
      return armyOne;
    } else {
      return null;
    }
  }

}
