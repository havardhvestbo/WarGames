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
//  public static void main(String[] args) throws URISyntaxException, IOException {
//    fileReader("Human-Army");
//  }
//
//  /**
//   * A file reader to read existing csv files (saves) and load into the game.
//   *
//   * @param armyName file/army name.
//   * @throws IOException
//   */
//  public static void fileReader(String armyName) throws IOException {
//    try (BufferedReader reader = new BufferedReader(new FileReader( armyName + ".csv"))) {
//      String line;
//      while ((line= reader.readLine()) != null) {
//        String[] unitAsSplitString = line.split(",");
//        if (unitAsSplitString.length > 1){
//          System.out.println(unitAsSplitString[1]);
//        } else {
//          System.out.println("The army's name is : " + unitAsSplitString[0]);
//        }
//      }
//
//    } catch (IOException e) {
//      throw e;
//    }
//  }
//
//  /**
//   * A file writer to save current csv files in the game.
//   *
//   * @param army army to save
//   * @throws IOException
//   */
//  public static void fileWriter(Army army) throws IOException {
//    List<Unit> units = army.getAllUnits();
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter(army.getArmyName()+ ".csv"))){
//      writer.write(army.getArmyName());
//      writer.newLine();
//      for (Unit unit : units) {
//        String lineToBeWritten = unit.getClass().getSimpleName()+ "," + unit.getName() + "," + unit.getHealth();
//        writer.write(lineToBeWritten);
//        writer.newLine();
//      }
//    } catch (IOException e) {
//      throw e;
//    }
//  }
//}