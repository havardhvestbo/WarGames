package no.ntnu.iir.wargames.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.Unit;
import no.ntnu.iir.wargames.service.UnitFactory;
import no.ntnu.iir.wargames.service.UnitType;

public class CreateGameController {

  private Army army1;
  private Army army2;

  private Terrain terrain = Terrain.NOTERRAIN;
  private ResultController resultController;

  @FXML
  private TextField armyName1;
  @FXML
  private TextField armyName2;
  @FXML
  private TextField nameInfantryUnit1;
  @FXML
  private TextField nameInfantryUnit2;
  @FXML
  private TextField nameCavalryUnit1;
  @FXML
  private TextField nameCavalryUnit2;
  @FXML
  private TextField nameRangedUnit1;
  @FXML
  private TextField nameRangedUnit2;
  @FXML
  private TextField nameCommanderUnit1;
  @FXML
  private TextField nameCommanderUnit2;
  @FXML
  private TextField healthInfantryUnits1;
  @FXML
  private TextField healthInfantryUnits2;
  @FXML
  private TextField healthCavalryUnits1;
  @FXML
  private TextField healthCavalryUnits2;
  @FXML
  private TextField healthRangedUnits1;
  @FXML
  private TextField healthRangedUnits2;
  @FXML
  private TextField healthCommanderUnits1;
  @FXML
  private TextField healthCommanderUnits2;
  @FXML
  private TextField numUnitsInfantryUnits1;
  @FXML
  private TextField numUnitsInfantryUnits2;
  @FXML
  private TextField numUnitsCavalryUnits1;
  @FXML
  private TextField numUnitsCavalryUnits2;
  @FXML
  private TextField numUnitsRangedUnit1;
  @FXML
  private TextField numUnitsRangedUnit2;
  @FXML
  private TextField numUnitsCommanderUnit1;
  @FXML
  private TextField numUnitsCommanderUnit2;
  @FXML
  private Button armyDetails1;
  @FXML
  private Button armyDetails2;
  @FXML
  private Button saveArmy1;
  @FXML
  private Button saveArmy2;
  @FXML
  private Button loadExistingArmy1;
  @FXML
  private Button loadExistingArmy2;
  @FXML
  private Button startGame;
  @FXML
  private CheckBox hills;
  @FXML
  private CheckBox forrest;
  @FXML
  private CheckBox plains;
  @FXML
  private Scene resultScene;

  public  void setResultScene(Scene resultScene) {
    this.resultScene = resultScene;
  }
  @FXML
  protected void hillsChecked() {
    if(this.hills.isSelected()) {
      this.forrest.setSelected(false);
      this.plains.setSelected(false);
      army1.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.HILL));
      army2.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.HILL));
    }
  }


  @FXML
  protected void forrestChecked() {
    if(this.forrest.isSelected()) {
      this.hills.setSelected(false);
      this.plains.setSelected(false);
      army1.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.FOREST));
      army2.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.FOREST));
    }
  }

  @FXML
  protected void plainsChecked() {
    if (this.forrest.isSelected()) {
      this.hills.setSelected(false);
      this.plains.setSelected(false);
      army1.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.PLAIN));
      army2.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.PLAIN));
    }
  }

  @FXML
  protected void startGameButtonPressed(ActionEvent actionEvent) {
    createArmy1();
    createArmy2();
    this.resultController.setArmy1(army1);
    this.resultController.setArmy2(army2);
    this.resultController.getArmyName1();
    this.resultController.getArmyName2();
    this.resultController.getBattleResult();
    this.resultController.getUnitsLeft1();
    this.resultController.getUnitsLeft2();
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(stage, this.resultScene);
  }

  private void setScene(Stage stage, Scene newScene) {
    stage.hide();
    stage.setScene(newScene);
    stage.show();
  }

  @FXML
  protected void createArmy1() {
    List<Unit> units = new ArrayList<>();
    this.army1 = new Army(armyName1.getText());
    createInfantryUnits1(units);
    createCavalryUnits1(units);
    createRangedUnits1(units);
    createCommanderUnits1(units);
  }

  @FXML
  protected void createArmy2() {
    List<Unit> units = new ArrayList<>();
    this.army2 = new Army(armyName2.getText());
    createInfantryUnits2(units);
    createCavalryUnits2(units);
    createRangedUnits2(units);
    createCommanderUnits2(units);
  }

  public void setResultController(ResultController resultController) {
    this.resultController = resultController;
  }

  private void createInfantryUnits1( List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.INFANTRY, this.nameInfantryUnit1.getText(), Integer.parseInt(this.healthInfantryUnits1.getText()), terrain, Integer.parseInt(numUnitsInfantryUnits1.getText()));
    army1.addAll(units);
  }

  private void createInfantryUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.INFANTRY, this.nameInfantryUnit2.getText(), Integer.parseInt(this.healthInfantryUnits2.getText()), terrain, Integer.parseInt(numUnitsInfantryUnits2.getText()));
    army2.addAll(units);
  }

  private void createCavalryUnits1(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.CAVALRY, this.nameCavalryUnit1.getText(), Integer.parseInt(this.healthCavalryUnits1.getText()), terrain, Integer.parseInt(numUnitsCavalryUnits1.getText()));
    army1.addAll(units);
  }

  private void createCavalryUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.CAVALRY, this.nameCavalryUnit2.getText(), Integer.parseInt(this.healthCavalryUnits2.getText()), terrain, Integer.parseInt(numUnitsCavalryUnits2.getText()));
    army2.addAll(units);
  }

  private void createRangedUnits1(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.RANGED, this.nameRangedUnit1.getText(), Integer.parseInt(this.healthRangedUnits1.getText()), terrain, Integer.parseInt(numUnitsRangedUnit1.getText()));
    army1.addAll(units);
  }

  private void createRangedUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.RANGED, this.nameRangedUnit2.getText(), Integer.parseInt(this.healthRangedUnits2.getText()), terrain, Integer.parseInt(numUnitsRangedUnit2.getText()));
    army2.addAll(units);
  }

  private void createCommanderUnits1(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.COMMANDER, this.nameCommanderUnit1.getText(), Integer.parseInt(this.healthCommanderUnits1.getText()), terrain, Integer.parseInt(numUnitsCommanderUnit1.getText()));
    army1.addAll(units);
  }

  private void createCommanderUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.COMMANDER, this.nameCommanderUnit2.getText(), Integer.parseInt(this.healthCommanderUnits2.getText()), terrain, Integer.parseInt(numUnitsCommanderUnit2.getText()));
    army2.addAll(units);
  }

}
