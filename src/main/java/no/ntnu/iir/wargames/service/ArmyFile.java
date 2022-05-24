package no.ntnu.iir.wargames.service;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.Unit;

/**
 * A class handling the files of armies. Writing and reading
 *
 *
 */
public class ArmyFile {
  public static void main(String[] args) throws URISyntaxException, IOException {
    fileReader("Human-Army");
  }

  /**
   * A file reader to read existing csv files (saves) and load into the game.
   *
   * @param armyName file/army name.
   * @throws IOException
   */
  public static void fileReader(String armyName) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader( armyName + ".csv"))) {
      String line;
      while ((line= reader.readLine()) != null) {
        String[] unitAsSplitString = line.split(",");
        if (unitAsSplitString.length > 1){
          System.out.println(unitAsSplitString[1]);
        } else {
          System.out.println("The army's name is : " + unitAsSplitString[0]);
        }
      }

    } catch (IOException e) {
      throw e;
    }

  }

  /**
   * A file writer to save current csv files in the game.
   *
   * @param army army to save
   * @throws IOException
   */
  public static void fileWriter(Army army) throws IOException {
    List<Unit> units = army.getAllUnits();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(army.getArmyName()+ ".csv"))){
      writer.write(army.getArmyName());
      writer.newLine();
      for (Unit unit : units) {
        String lineToBeWritten = unit.getClass().getSimpleName()+ "," + unit.getName() + "," + unit.getHealth();
        writer.write(lineToBeWritten);
        writer.newLine();
      }
    } catch (IOException e) {
      throw e;
    }
  }
}