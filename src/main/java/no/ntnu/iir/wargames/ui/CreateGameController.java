package no.ntnu.iir.wargames.ui;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.iir.wargames.data.Army;
import no.ntnu.iir.wargames.data.Terrain;
import no.ntnu.iir.wargames.data.Unit;
import no.ntnu.iir.wargames.service.UnitFactory;
import no.ntnu.iir.wargames.service.UnitType;

/**
 * Controller for the create game page.
 * Linked to the FXML-file representing the view of MVC of JavaFx FXML.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class CreateGameController {

  private Army army1;
  private Army army2;
  private Terrain terrain = Terrain.NOTERRAIN;
  private ResultController resultController;
  private ArmyDetailsController armyDetailsController;

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
  private Button saveArmies;
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
  @FXML
  private Scene armyDetailsScene;

  /**
   * Set a scene for ResultScene.fxml in current class.
   *
   * @param resultScene resultScene's scene.
   */
  public  void setResultScene(Scene resultScene) {
    this.resultScene = resultScene;
  }

  /**
   * Set a scene for ArmyDetailsScene.fxml in current class.
   *
   * @param armyDetailsScene armyDetail's scene.
   */
  public  void setArmyDetailsScene(Scene armyDetailsScene) {
    this.armyDetailsScene = armyDetailsScene;
  }

  private void alertForCheckedButton() {
    Alert alertChecked = new Alert(Alert.AlertType.ERROR);
    alertChecked.setTitle("Army not saved ");
    alertChecked.setHeaderText(" Please save a full file before choosing terrain");
    alertChecked.setContentText("Fill in text for army name and included troops. Plus whole positive number for values. ");
    alertChecked.show();
  }
  /**
   * Hills chosen when checkbox is chosen.
   */
  @FXML
  protected void hillsChecked() {
    try {this.hills.isSelected() ;
      this.forrest.setSelected(false);
      this.plains.setSelected(false);
      army1.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.HILL));
      army2.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.HILL));
    } catch (NullPointerException n) {
      alertForCheckedButton();
    }
  }

  /**
   * Forrest chosen when checkbox is chosen.
   */
  @FXML
  protected void forrestChecked() {
    try {this.forrest.isSelected();
      this.hills.setSelected(false);
      this.plains.setSelected(false);
      army1.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.FOREST));
      army2.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.FOREST));
    } catch (NullPointerException n) {
      alertForCheckedButton();
    }
  }

  /**
   * Plains chosen when checkbox is chosen.
   */
  @FXML
  protected void plainsChecked() {
    try {this.plains.isSelected();
      this.hills.setSelected(false);
      this.forrest.setSelected(false);
      army1.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.PLAIN));
      army2.getAllUnits().forEach(unit -> unit.setTerrain(Terrain.PLAIN));
    } catch (NullPointerException n) {
      alertForCheckedButton();
    }
  }

  /**
   * Alert for wrong input in text areas and text fields.
   */
  private void alertForWrongInput() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Wrong input. ");
    alert.setHeaderText("One or more of the inputs are wrong. ");
    alert.setContentText("Check if health and number of units are a positive integer (no decimal) and contains no text (String) .  ");
    alert.show();
  }

  /**
   * Changes scene and sets the next scene based on input form user.
   *
   * @param actionEvent when button is pressed.
   */
  @FXML
  protected void startGameButtonPressed(ActionEvent actionEvent) {
    try {
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
  } catch (NumberFormatException e)  {
    alertForWrongInput();
  }
  }

  /**
   * Changes scene and sets the next scene based on input form user.
   *
   * @param actionEvent when button is pressed.
   */
  @FXML
  protected void armyDetailsButton1Pressed(ActionEvent actionEvent) {
    this.armyDetailsController.setArmy1(army1);
    this.armyDetailsController.getArmyName1();
    this.armyDetailsController.getInfantryUnitName1();
    this.armyDetailsController.getCavalryUnitName1();
    this.armyDetailsController.getRangedUnitName1();
    this.armyDetailsController.getCommanderUnitName1();
    this.armyDetailsController.getInfantryDetails1();
    this.armyDetailsController.getCavalryDetails1();
    this.armyDetailsController.getRangedDetails1();
    this.armyDetailsController.getCommanderDetails1();

    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(stage, this.armyDetailsScene);
  }

  /**
   * Changes scene and sets the next scene based on input form user.
   *
   * @param actionEvent when button is pressed.
   */
  @FXML
  protected void armyDetailsButton2Pressed(ActionEvent actionEvent) {
    this.armyDetailsController.setArmy2(army2);
    this.armyDetailsController.getArmyName2();
    this.armyDetailsController.getInfantryUnitName2();
    this.armyDetailsController.getCavalryUnitName2();
    this.armyDetailsController.getRangedUnitName2();
    this.armyDetailsController.getCommanderUnitName2();
    this.armyDetailsController.getInfantryDetails2();
    this.armyDetailsController.getCavalryDetails2();
    this.armyDetailsController.getRangedDetails2();
    this.armyDetailsController.getCommanderDetails2();

    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(stage, this.armyDetailsScene);
  }

  /**
   * Saves the armies based on input form user.
   *
   * @param actionEvent when button is pressed.
   */
  @FXML
  protected void saveArmiesButtonPressed(ActionEvent actionEvent) {
    try {
      createArmy1();
      createArmy2();
    } catch (NumberFormatException e) {
      alertForWrongInput();
    }
  }

  /**
   * Change the scene in a stage.
   *
   * @param stage stage for scene.
   * @param newScene new scene.
   */
  private void setScene(Stage stage, Scene newScene) {
    stage.hide();
    stage.setScene(newScene);
    stage.show();
  }


  /**
   * Creates an army with values based on user's input.
   */
  private void createArmy1() {
    List<Unit> units = new ArrayList<>();
    this.army1 = new Army(armyName1.getText());
    createInfantryUnits1(units);
    createCavalryUnits1(units);
    createRangedUnits1(units);
    createCommanderUnits1(units);
  }

  /**
   * Creates an army with values based on user's input.
   */
  private void createArmy2() {
    List<Unit> units = new ArrayList<>();
    this.army2 = new Army(armyName2.getText());
    createInfantryUnits2(units);
    createCavalryUnits2(units);
    createRangedUnits2(units);
    createCommanderUnits2(units);
  }

  /**
   * Set a scene for Result.fxml in current class.
   *
   * @param resultController Result's scene.
   */
  public void setResultController(ResultController resultController) {
    this.resultController = resultController;
  }

  /**
   * Set a scene for ArmyDetails.fxml in current class.
   *
   * @param armyDetailsController Army Details' scene
   */
  public void setArmyDetailsController(ArmyDetailsController armyDetailsController) {
    this.armyDetailsController = armyDetailsController;
  }

  /**
   * Create infantry units with values based on the user's input.
   *
   * @param units list of infantry units.
   */
  private void createInfantryUnits1( List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.INFANTRY, this.nameInfantryUnit1.getText(), Integer.parseInt(this.healthInfantryUnits1.getText()), terrain, Integer.parseInt(numUnitsInfantryUnits1.getText()));
    army1.addAll(units);
  }

  /**
   * Create infantry units with values based on the user's input.
   *
   * @param units list of infantry units.
   */
  private void createInfantryUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.INFANTRY, this.nameInfantryUnit2.getText(), Integer.parseInt(this.healthInfantryUnits2.getText()), terrain, Integer.parseInt(numUnitsInfantryUnits2.getText()));
    army2.addAll(units);
  }

  /**
   * Create cavalry units with values based on the user's input.
   *
   * @param units list of cavalry units.
   */
  private void createCavalryUnits1(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.CAVALRY, this.nameCavalryUnit1.getText(), Integer.parseInt(this.healthCavalryUnits1.getText()), terrain, Integer.parseInt(numUnitsCavalryUnits1.getText()));
    army1.addAll(units);
  }

  /**
   * Create cavalry units with values based on the user's input.
   *
   * @param units list of cavalry units.
   */
  private void createCavalryUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.CAVALRY, this.nameCavalryUnit2.getText(), Integer.parseInt(this.healthCavalryUnits2.getText()), terrain, Integer.parseInt(numUnitsCavalryUnits2.getText()));
    army2.addAll(units);
  }

  /**
   * Create ranged units with values based on the user's input.
   *
   * @param units list of ranged units.
   */
  private void createRangedUnits1(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.RANGED, this.nameRangedUnit1.getText(), Integer.parseInt(this.healthRangedUnits1.getText()), terrain, Integer.parseInt(numUnitsRangedUnit1.getText()));
    army1.addAll(units);
  }

  /**
   * Create ranged units with values based on the user's input.
   *
   * @param units list of ranged units.
   */
  private void createRangedUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.RANGED, this.nameRangedUnit2.getText(), Integer.parseInt(this.healthRangedUnits2.getText()), terrain, Integer.parseInt(numUnitsRangedUnit2.getText()));
    army2.addAll(units);
  }

  /**
   * Create commander units with values based on the user's input.
   *
   * @param units list of commander units.
   */
  private void createCommanderUnits1(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.COMMANDER, this.nameCommanderUnit1.getText(), Integer.parseInt(this.healthCommanderUnits1.getText()), terrain, Integer.parseInt(numUnitsCommanderUnit1.getText()));
    army1.addAll(units);
  }

  /**
   * Create commander units with values based on the user's input.
   *
   * @param units list of commander units.
   */
  private void createCommanderUnits2(List<Unit> units) {
    UnitFactory unitFactory = new UnitFactory();
    units = unitFactory.createUnits(UnitType.COMMANDER, this.nameCommanderUnit2.getText(), Integer.parseInt(this.healthCommanderUnits2.getText()), terrain, Integer.parseInt(numUnitsCommanderUnit2.getText()));
    army2.addAll(units);
  }
}
