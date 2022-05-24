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

  private Army army1;
  private Army army2;

  /**
   * Constructing the battle between the armies.
   *
   * @param army1
   * @param army2
   */
  public Battle(Army army1, Army army2) {

    this.army1 = army1;
    this.army2 = army2;
  }

  /**
   * Method simulating the battle between the two armies until one army is empty. Army with remaining units is the winner.
   *
   * @return winning army
   */
  public Army simulate() {

    Army winningArmy = null;

    while (army1.hasUnits() && army2.hasUnits()) {
      Unit unitOne = army1.getRandom();
      Unit unitTwo = army2.getRandom();

      unitOne.attack(unitTwo);
      if (unitTwo.getHealth() <= 0) {
        army2.remove(unitTwo);
      }
      unitTwo.attack(unitOne);
      if (unitOne.getHealth() <= 0) {
        army1.remove(unitOne);
      }

      if (!army1.hasUnits()) {
        winningArmy = army2;
      }
      if (!army2.hasUnits()) {
        winningArmy = army1;
      }
    }
    return winningArmy;
  }
}
