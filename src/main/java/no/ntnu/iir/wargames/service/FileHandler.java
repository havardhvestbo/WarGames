package no.ntnu.iir.wargames.service;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.Unit;

/**
 * A class handling the files of armies. Writing and reading
 *
 *
 */

public class FileHandler {

  /**
   * A file saver to save current csv files in the game.
   *
   * @param army army to save.
   * @param fileName name of file.
   * @throws FileNotFoundException
   */
  public void saveFile(Army army, String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    PrintWriter printWriter = new PrintWriter(file);
    printWriter.println(army.getArmyName());
    for (Unit unit : army.getAllUnits()) {
      printWriter.println(unit.getClass().getSimpleName()+ "," +
          unit.getName() + "," + unit.getHealth() + "," + unit.getTerrain());
      printWriter.close();
    }
  }

  /**
   * A file loader to read existing csv files (saves) and load into the game.
   *
   * @param fileName name of file.
   * @return army.
   */
  public Army loadFile(String fileName) {
    Path stringToPath = Paths.get(fileName);
    Army army = new Army("name");
    UnitFactory unitFactory = new UnitFactory();

    try (BufferedReader bufferedReader = Files.newBufferedReader(stringToPath)) {
      String line = bufferedReader.readLine();
      while (line !=null) {
        String[] armyDataFile = line.split(",");
        if(armyDataFile.length == 1) {
          army.setArmyName(armyDataFile[0]);
        }
        else if (armyDataFile.length == 4) {
          UnitType unitType = null;
          if (armyDataFile[0].equals("InfantryUnit")) {
            unitType = UnitType.INFANTRY;
          }
          if (armyDataFile[0].equals("CavalryUnit")) {
            unitType = UnitType.CAVALRY;
          }
          if (armyDataFile[0].equals("RangedUnit")) {
            unitType = UnitType.RANGED;
          }
          if (armyDataFile[0].equals("CommanderUnit")) {
            unitType = UnitType.COMMANDER;
          }
          Unit unit = unitFactory.createUnit(unitType ,armyDataFile[1], Integer.parseInt(armyDataFile[2]),
              Terrain.NOTERRAIN);
          army.add(unit);
        }
        else{
          throw new IllegalArgumentException("Some Thing Wrong With The File");
        }
        line = bufferedReader.readLine();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return army;
  }
}
