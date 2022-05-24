package no.ntnu.iir.wargames;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.CommanderUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.RangedUnit;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.simulation.Battle;
import org.junit.jupiter.api.Test;

public class BattleTest {

  public BattleTest() {
  }

  /**
   * Tests the battle simulation. Fixed to return arm1 as winner.
   */
  @Test
  public void testBattleSimulation() {
      Army army1 = new Army("Human Army");
      Army army2 = new Army("Orcish horde");
    Terrain terrain = Terrain.TEST;
      for (int i = 0; i<100; i++){
        InfantryUnit unit = new InfantryUnit("Footman", 10,terrain);
        army1.add(unit);
      }
      for (int i = 0; i<100; i++){
        CavalryUnit unit = new CavalryUnit("Knight", 10, terrain);
        army1.add(unit);
      }
      for (int i = 0; i<100; i++){
        RangedUnit unit = new RangedUnit("Archer", 10, terrain);
        army1.add(unit);
      }
      CommanderUnit unit = new CommanderUnit("Mountain King", 18, terrain);
      army1.add(unit);

      for (int i = 0; i<2; i++){
        InfantryUnit unitTwo = new InfantryUnit("Grunt", 10, terrain);
        army2.add(unitTwo);
      }
      for (int i = 0; i<2; i++){
        CavalryUnit unitTwo = new CavalryUnit("Raider", 10, terrain);
        army2.add(unitTwo);
      }
      for (int i = 0; i<2; i++){
        RangedUnit unitTwo = new RangedUnit("Spearman", 10, terrain);
        army2.add(unitTwo);
      }
      CommanderUnit unitTwo = new CommanderUnit("Gul´dan", 18, terrain);
      army2.add(unitTwo);

      Battle battle = new Battle(army1, army2);
      Army winningArmy = battle.simulate();
      assertEquals(army1, winningArmy);
    }
  }

