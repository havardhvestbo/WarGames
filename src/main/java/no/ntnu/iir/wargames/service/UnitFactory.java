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
 * A Factory design patter
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class UnitFactory {

  /**
   * Implemented a factory pattern to create a unit of a specific type.
   *
   * @param unitType type of unit
   * @param name unit's name
   * @param health unit's health.
   * @param terrain unit's terrain.
   * @return returnUnit
   */
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

  /**
   * Private method for the factory to create a infantryUnit.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's terrain
   * @return InfantryUnit
   */
  private static InfantryUnit createInfantryUnit(String name, int health, Terrain terrain) {
    return new InfantryUnit(name, health, terrain); }

  /**
   * Private method for the factory to create a cavalryUnit.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's terrain.
   * @return CavalryUnit
   */
  private static CavalryUnit createCavalryUnit(String name, int health, Terrain terrain) {
    return new CavalryUnit(name, health, terrain); }

  /**
   * Private method for the factory to create a rangedUnit.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's terrain.
   * @return RangedUnit
   */
  private static RangedUnit createRangedUnit(String name, int health, Terrain terrain) {
    return new RangedUnit(name, health, terrain); }

  /**
   * Private method for the factory to create a rangedUnit.
   *
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's terrain.
   * @return RangedUnit.
   */
  private static CommanderUnit createCommanderUnit(String name, int health, Terrain terrain) {
    return new CommanderUnit(name, health, terrain); }

  /**
   * Creating a specific number of  a specific unit type. Choose amount of units in parameter with stats.
   *
   * @param unitType the type of unit.
   * @param name unit's name.
   * @param health unit's health.
   * @param terrain unit's terrain.
   * @param numUnits amount of units to create.
   * @return listOfUnits with given specifications.
   */
  public List<Unit> createUnits(UnitType unitType, String name, int health, Terrain terrain, int numUnits) {
    List<Unit> listOfUnits = new ArrayList<>();
      for (int index = 1; index <= numUnits; index++) {
        listOfUnits.add(createUnit(unitType , name, health, terrain));
      }
     return listOfUnits;
  }
}

