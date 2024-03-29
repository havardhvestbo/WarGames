package no.ntnu.iir.wargames.simulation;

import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.CommanderUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.RangedUnit;
import no.ntnu.iir.wargames.data.Terrain;

/**
 * A client running a demo of a battle between two set armys.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class BattleClient {

  public static void main(String[] args) {
    Army army1 = new Army("Human Army");
    Army army2 = new Army("Orcish horde");
    Terrain terrain = Terrain.HILL;
    for (int i = 0; i<500; i++){
      InfantryUnit unit = new InfantryUnit("Footman", 100, terrain);
      army1.add(unit);
    }
    for (int i = 0; i<100; i++) {
      CavalryUnit unit = new CavalryUnit("Knight", 100, terrain);
      army1.add(unit);
    }
    for (int i = 0; i<200; i++) {
      RangedUnit unit = new RangedUnit("Archer", 100, terrain);
      army1.add(unit);
    }
    CommanderUnit unit = new CommanderUnit("Mountain King", 180, terrain);
    army1.add(unit);

    for (int i = 0; i<500; i++) {
      InfantryUnit unitTwo = new InfantryUnit("Grunt", 100, terrain);
      army2.add(unitTwo);
    }
    for (int i = 0; i<100; i++) {
      CavalryUnit unitTwo = new CavalryUnit("Raider", 100, terrain);
      army2.add(unitTwo);
    }
    for (int i = 0; i<200; i++) {
      RangedUnit unitTwo = new RangedUnit("Spearman", 100, terrain);
      army2.add(unitTwo);
    }
    CommanderUnit unitTwo = new CommanderUnit("Gul´dan", 180, terrain);
    army2.add(unitTwo);

    Battle battle = new Battle(army1, army2);
    Army winningArmy = battle.simulate();
    System.out.println("Winner is :" + winningArmy.toString());
  }
}