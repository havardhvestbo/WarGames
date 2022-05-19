package no.ntnu.iir.wargames.service;

import no.ntnu.iir.wargames.CavalryUnit;
import no.ntnu.iir.wargames.CommanderUnit;
import no.ntnu.iir.wargames.InfantryUnit;
import no.ntnu.iir.wargames.RangedUnit;
import no.ntnu.iir.wargames.Unit;

/**
 * The factory creates a object of a spesific type of a Unit.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class UnitFactory {

  public static Unit getUnit(UnitType unitType) {
    Unit returnUnit = null;
    switch (unitType) {
      case INFANTRY -> {
        returnUnit = createInfantryUnit();
      }
      case CAVALRY -> {
        returnUnit = createCavalryUnit();
      }
      case RANGED -> {
        returnUnit = createRangedUnit();
      }
      case COMMANDER -> {
        returnUnit = createCommanderUnit();
      }
    }
    return returnUnit;
  }

  private static InfantryUnit createInfantryUnit() { return new InfantryUnit("Footman",100); }

  private static CavalryUnit createCavalryUnit() { return new CavalryUnit("Knight", 100); }

  private static RangedUnit createRangedUnit() { return new RangedUnit("Archer",100); }

  private static CommanderUnit createCommanderUnit() { return new CommanderUnit("Mountain King",180); }

}
