package no.ntnu.iir.wargames.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A class representing a collection of units called Army.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */

public class Army {

  private String armyName;
  private List<Unit> units;

  /**
   * Simplified constructor of Army.
   *
   * @param armyName army's name.
   */
  public Army(String armyName) {
    if (armyName == null || armyName.isBlank()) {
      throw new IllegalArgumentException("Invalid input.");
    }
    else {
      this.armyName = armyName;
    }
      this.units = new ArrayList<>();
  }

  /**
   * Creates an instance of Army.
   *
   * @param armyName army's name.
   * @param units list of units in army.
   */
  public Army(String armyName, List<Unit> units) {
    if (armyName == null || armyName.isBlank() || units == null) {
      throw  new IllegalArgumentException("Invalid input.");
    }
    else {
      this.armyName = armyName;
      this.units = units;
    }
  }

  /**
   * Returns a string of the Army´s name.
   *
   * @return armyName army's name.
   */
  public String getArmyName() {
    return armyName;
  }

  /**
   * Changes army name.
   *
   * @param armyName new army name;
   */
  public void setArmyName(String armyName) {
    this.armyName = armyName;
  }

  /**
   * Adds a unit to list units
   *
   * @param unit to add to list units.
   */
  public void add(Unit unit) {
    this.units.add(unit);
  }

  /**
   * Adds a list of units to list units.
   *
   * @param unitList list of units to add to list units.
   */
  public void addAll(List<Unit> unitList) {
    this.units.addAll(unitList);
  }

  /**
   * Removes a unit from list units.
   *
   * @param unit to remove from list.
   */
  public void remove(Unit unit) {
    this.units.remove(unit);
  }

  /**
   * Returns true if the list contains any units.
   *
   * @return boolean true if army has units, false if empty
   */
  public boolean hasUnits() {
    if (units.isEmpty()) {
      return false;
    }
      return true;
  }

  /**
   * Returns every unit in the list units.
   *
   * @return all units in list units.
   */
  public List<Unit> getAllUnits() {
    return units;
  }

  /**
   * Returns a random unit from list units.
   *
   * @return random unit from list units.
   */
  public Unit getRandom() {
    Random rand = new Random();
    int upperbound = units.size();
    int intRandom = rand.nextInt(upperbound);
    Unit randomUnit = units.get(intRandom);
    return randomUnit;
  }
  @Override
  public String toString() {
    return "Army: " + armyName + '\'' + ", units left: " + units.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Army army = (Army) o;
    return Objects.equals(armyName, army.armyName) && Objects.equals(units, army.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(armyName, units);
  }

  /**
   * Return units of type infantryUnit to a List.
   *
   * @return List containing infantryUnits.
   */
  public List<Unit> getInfantryUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(InfantryUnit.class))
        .collect(Collectors.toList());
  }

  /**
   * Return units of type cavalryUnit to a List.
   *
   * @return List containing infantryUnits.
   */
  public List<Unit> getCavalryUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(CavalryUnit.class))
        .collect(Collectors.toList());
  }

  /**
   * Return units of type rangedUnit to a List.
   *
   * @return List containing rangedUnits.
   */
  public List<Unit> getRangedUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(RangedUnit.class))
        .collect(Collectors.toList());
  }

  /**
   * Return units of type commanderUnit to a List.
   *
   * @return List containing commanderUnits.
   */
  public List<Unit> getCommanderUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(CommanderUnit.class))
        .collect(Collectors.toList());
  }

}



