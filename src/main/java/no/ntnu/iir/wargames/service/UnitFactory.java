package no.ntnu.iir.wargames.service;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.CommanderUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.RangedUnit;
import no.ntnu.iir.wargames.data.Unit;

/**
 * The factory creates an object of a specific type of Unit.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class UnitFactory {

  public static Unit createUnit(UnitType unitType, String name, int health, Terrain terrain) {
    Unit returnUnit = null;
    switch (unitType) {
      case INFANTRY -> {
        returnUnit = createInfantryUnit(name, health, terrain);
      }
      case CAVALRY -> {
        returnUnit = createCavalryUnit(name, health, terrain);
      }
      case RANGED -> {
        returnUnit = createRangedUnit(name, health, terrain);
      }
      case COMMANDER -> {
        returnUnit = createCommanderUnit(name, health, terrain);
      }
      default ->
        throw new IllegalArgumentException("No such type of units exist. ");
    }
    return returnUnit;
  }


  private static InfantryUnit createInfantryUnit(String name, int health, Terrain terrain) {
    return new InfantryUnit(name, health, terrain); }

  private static CavalryUnit createCavalryUnit(String name, int health, Terrain terrain) {
    return new CavalryUnit(name, health, terrain); }

  private static RangedUnit createRangedUnit(String name, int health, Terrain terrain) {
    return new RangedUnit(name, health, terrain); }

  private static CommanderUnit createCommanderUnit(String name, int health, Terrain terrain) {
    return new CommanderUnit(name, health, terrain); }

  public List<Unit> createUnits(UnitType unitType, String name, int health, Terrain terrain, int numUnits) {
    List<Unit> listOfUnits = new ArrayList<>();
    if(numUnits > 0 || !name.isBlank() || name != null || health > 0 || terrain != null) {
      for (int index = 1; index <= numUnits; index++) {
        listOfUnits.add(createUnit(unitType , name, health, terrain));
      }
    }
    else {
      throw new IllegalArgumentException("Invalid parameter");
    }
    return listOfUnits;
  }
}

