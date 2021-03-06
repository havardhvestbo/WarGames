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
   * Creates an instance of Army
   *
   * @param armyName
   */
  public Army(String armyName) {
    this.armyName = armyName;
    this.units = new ArrayList<>();
  }

  /**
   * Creates an instance of Army.
   *
   * @param armyName
   * @param units
   */
  public Army(String armyName, List<Unit> units) {
    this.armyName = armyName;
    this.units = units;
  }

  /**
   * Returns a string of the Army´s name
   *
   * @return armyName
   */
  public String getArmyName() {
    return armyName;
  }

  /**
   * Adds a unit to list units
   *
   * @param unit
   */
  public void add(Unit unit) {
    this.units.add(unit);
  }

  /**
   * Adds a list of units to list units.
   *
   * @param unitList
   */
  public void addAll(List<Unit> unitList) {
    this.units.addAll(unitList);
  }

  /**
   * Removes a unit from list units.
   *
   * @param unit
   */
  public void remove(Unit unit) {
    this.units.remove(unit);
  }

  /**
   * Returns true if the list contains any units.
   *
   * @return
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
   * @return all units
   */
  public List<Unit> getAllUnits() {
    return units;
  }

  /**
   * Returns a random unit from list units.
   *
   * @return
   */
  public Unit getRandom() {
    Random rand = new Random();
    int upperbound = units.size();
    int intRandom = rand.nextInt(upperbound);
    Unit randomUnit = units.get(intRandom);
    return randomUnit;
  }

  /**
   * Returns information about the Army in a String.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Army{" + "armyName='" + armyName + '\'' + ", units=" + units + '}';
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


  public List<Unit> getInfantryUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(InfantryUnit.class))
        .collect(Collectors.toList());
  }

  public List<Unit> getCavalryUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(CavalryUnit.class))
        .collect(Collectors.toList());
  }

  public List<Unit> getRangedUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(RangedUnit.class))
        .collect(Collectors.toList());
  }

  public List<Unit> getCommanderUnits() {
    return this.units.stream()
        .filter(unit -> unit.getClass().equals(CommanderUnit.class))
        .collect(Collectors.toList());
  }

}



