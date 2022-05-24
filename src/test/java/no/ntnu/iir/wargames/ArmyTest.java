package no.ntnu.iir.wargames;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.CommanderUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.RangedUnit;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.Unit;
import org.junit.jupiter.api.Test;

public class ArmyTest {

  private Terrain terrain = Terrain.TEST;

  public ArmyTest() {
    }

  /**
   * Test army constructor with String name value.
   */
  @Test
    public void createInstanceOfArmy() {
      Army army = new Army("Human Army");
      assertEquals("Human Army", army.getArmyName());
    }

  /**
   * Test add unit to army method.
   */
  @Test
    public void testAdd() {
      Army army = new Army("Human Army");
      InfantryUnit footman = new InfantryUnit("footman", 100, terrain);
      army.add(footman);
      assertEquals(true, army.hasUnits());
    }

  /**
   * Test add list of units to army.
   */
  @Test
    public void testAddAll() {
     List<Unit> units = new ArrayList<>();
      Army army = new Army("Human Army", units);
      InfantryUnit infantryUnit = new InfantryUnit("Footman", 100, terrain);
      CavalryUnit cavalryUnit = new CavalryUnit("Knight", 100, terrain);
      RangedUnit rangedUnit = new RangedUnit("Archer", 100, terrain);
      CommanderUnit commanderUnit = new CommanderUnit("Mountain King", 100, terrain);

      ArrayList<Unit> unitList = new ArrayList<>();
      unitList.add(infantryUnit);
      unitList.add(cavalryUnit);
      unitList.add(rangedUnit);
      unitList.add(commanderUnit);
      army.addAll(unitList);
      assertEquals(4, units.size());
    }

  /**
   * Test remove unit from army.
   */
  @Test
    public void testRemove() {
      Army army = new Army("Human Army");
      InfantryUnit footman = new InfantryUnit("footman", 100, terrain);
      army.add(footman);
      assertTrue(army.hasUnits());
      army.remove(footman);
      assertFalse(army.hasUnits());
    }

  /**
   * Test method for returning every unit in army.
   */
  @Test
    public void testGetAllUnits() {
      Army army = new Army("Human Army");
      InfantryUnit infantryUnit = new InfantryUnit("Footman", 100, terrain);
      CavalryUnit cavalryUnit = new CavalryUnit("Knight", 100, terrain);
      RangedUnit rangedUnit = new RangedUnit("Archer", 100, terrain);
      CommanderUnit commanderUnit = new CommanderUnit("Mountain King", 100, terrain);
      army.add(infantryUnit);
      army.add(cavalryUnit);
      army.add(rangedUnit);
      army.add(commanderUnit);

      ArrayList<Unit> expResult = new ArrayList<>();
      expResult.add(infantryUnit);
      expResult.add(cavalryUnit);
      expResult.add(rangedUnit);
      expResult.add(commanderUnit);

      assertEquals(expResult,army.getAllUnits());
    }

  /**
   * Test get a random unit from army.
   */
  @Test
    public void testGetRandom() {
      System.out.println("getRandom");
      Army army = new Army("Human");
      Unit unit1 = new CavalryUnit("Cavalry Unit 1", 100, 50, 60, terrain);
      Unit unit2 = new CommanderUnit("Commander Unit 1", 100, 50, 60, terrain);
      Unit unit3 = new RangedUnit("Ranged Unit 1", 100, 50, 60, terrain);

      List<Unit> units = new ArrayList<>();
      units.add(unit1);
      units.add(unit2);
      units.add(unit3);
      army.addAll(units);

      Unit result = army.getRandom();
      boolean expResult = units.contains(result);
      assertTrue(expResult);
    }

  /**
   * Test get instance of unit from army.
   */
  @Test
  public void testGetInstanceOfUnit() {
    Army army = new Army("Human");
    Unit unit1 = new CavalryUnit("Cavalry Unit 1", 100, 50, 60, terrain);
    Unit unit2 = new CommanderUnit("Commander Unit 1", 100, 50, 60, terrain);
    Unit unit3 = new RangedUnit("Ranged Unit 1", 100, 50, 60, terrain);
    Unit unit4 = new InfantryUnit("Footman", 100,50,60, terrain);
      army.add(unit1);
      army.add(unit2);
      army.add(unit3);
      army.add(unit4);

    List<Unit> expResult1 = new ArrayList<>();
    expResult1.add(unit4);
    assertEquals(expResult1, army.getInfantryUnits());

    List<Unit> expResult2 = new ArrayList<>();
    expResult2.add(unit1);
    assertEquals(expResult2, army.getCavalryUnits());

    List<Unit> expResult3 = new ArrayList<>();
    expResult3.add(unit2);
    assertEquals(expResult3, army.getCommanderUnits());

    List<Unit> expResult4 = new ArrayList<>();
    expResult4.add(unit3);
    assertEquals(expResult4, army.getRangedUnits());
    }
}
