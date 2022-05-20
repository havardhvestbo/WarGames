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

  @Test

  public void testBattleSimulation() {
      Army armyOne = new Army("Human Army");
      Army armyTwo = new Army("Orcish horde");
    Terrain terrain = Terrain.TEST;
      for (int i = 0; i<500; i++){
        InfantryUnit unit = new InfantryUnit("Footman", 100,terrain);
        armyOne.add(unit);
      }
      for (int i = 0; i<100; i++){
        CavalryUnit unit = new CavalryUnit("Knight", 100, terrain);
        armyOne.add(unit);
      }
      for (int i = 0; i<200; i++){
        RangedUnit unit = new RangedUnit("Archer", 100, terrain);
        armyOne.add(unit);
      }
      CommanderUnit unit = new CommanderUnit("Mountain King", 180, terrain);
      armyOne.add(unit);

      for (int i = 0; i<500; i++){
        InfantryUnit unitTwo = new InfantryUnit("Grunt", 10, terrain);
        armyTwo.add(unitTwo);
      }
      for (int i = 0; i<100; i++){
        CavalryUnit unitTwo = new CavalryUnit("Raider", 10, terrain);
        armyTwo.add(unitTwo);
      }
      for (int i = 0; i<200; i++){
        RangedUnit unitTwo = new RangedUnit("Spearman", 10, terrain);
        armyTwo.add(unitTwo);
      }
      CommanderUnit unitTwo = new CommanderUnit("Gul´dan", 18, terrain);
      armyTwo.add(unitTwo);

      Battle battle = new Battle(armyOne, armyTwo);
      Army winningArmy = battle.simulate();
      assertEquals(armyOne, winningArmy);
    }
  }

