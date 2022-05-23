package no.ntnu.iir.wargames.simulation;

import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.Unit;

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
   * Method simulating the battle between the two armies until one army is empty. Army with remaining units is the winner.
   *
   * @return winning army
   */
  public Army simulate() {

    Army winningArmy = null;

    while (armyOne.hasUnits() && armyTwo.hasUnits()) {
      Unit unitOne = armyOne.getRandom();
      Unit unitTwo = armyTwo.getRandom();

      unitOne.attack(unitTwo);
      if (unitTwo.getHealth() <= 0) {
        armyTwo.remove(unitTwo);
      }
      unitTwo.attack(unitOne);
      if (unitOne.getHealth() <= 0) {
        armyOne.remove(unitOne);
      }

      if (!armyOne.hasUnits()) {
        winningArmy = armyTwo;
      }
      if (!armyTwo.hasUnits()) {
        winningArmy = armyOne;
      }
    }
    return winningArmy;
  }
}
