package no.ntnu.iir.wargames.service;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.CommanderUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.RangedUnit;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.Unit;

public class ArmyFile {
  public static void main(String[] args) throws URISyntaxException, IOException {
    fileReader("Human-Army");
  }

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

  private void test() throws IOException {
    File file = new File("ArmyFile.csv");

    if (!file.isFile()) {
      file.createNewFile();
    }

    System.out.println(file.isFile());

    fileReader("ArmyFile");
  }

  private static void testFileWriting() throws IOException {
    Army army = new Army("Human Army");
    Terrain terrain = Terrain.TEST;
    army.add(new InfantryUnit("Footman", 100, terrain));
    army.add(new CavalryUnit("Knight",100, terrain));
    army.add(new RangedUnit("Archer",100, terrain));
    army.add(new CommanderUnit("Mountain King", 180, terrain));

    fileWriter(army);
  }

}