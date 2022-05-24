package no.ntnu.iir.wargames;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.Unit;
import no.ntnu.iir.wargames.service.UnitFactory;
import no.ntnu.iir.wargames.service.UnitType;
import org.junit.jupiter.api.Test;

public class UnitFactoryTest {

  public UnitFactoryTest() {

  }

  @Test
  public void testCreationOfAUnit() {
    CavalryUnit cavalryUnit = new CavalryUnit("Knight", 100, Terrain.TEST);
    UnitFactory unitFactory = new UnitFactory();
    Unit unit = unitFactory.createUnit(UnitType.CAVALRY, "Knight", 100, Terrain.TEST);
    assertEquals(unit.getClass(), cavalryUnit.getClass());

  }

  @Test
  public void testCreationOfOneHundredUnits() {
    UnitFactory unitFactory = new UnitFactory();
    InfantryUnit infantryUnit = new InfantryUnit("Footman",100,Terrain.TEST);
    List<Unit> units;
    units = unitFactory.createUnits(UnitType.INFANTRY,"Footman",100, Terrain.TEST,100);
    assertEquals(100, units.size());
    assertEquals(infantryUnit.getClass(), units.get(0).getClass());
  }

}



