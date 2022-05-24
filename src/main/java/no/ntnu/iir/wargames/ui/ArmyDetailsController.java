package no.ntnu.iir.wargames.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.iir.wargames.data.Army;

/**
 * Controller for the army details page.
 * Linked to the FXML-file representing the view of MVC of JavaFx FXML.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class ArmyDetailsController implements Initializable {

  Army army1;
  Army army2;

  @FXML
  private Button goBackButton;
  @FXML
  private Scene createGameScene;
  @FXML
  private TextField armyName = new TextField();
  @FXML
  private TextField infantryUnitName = new TextField();
  @FXML
  private TextField cavalryUnitName = new TextField();
  @FXML
  private TextField rangedUnitName = new TextField();
  @FXML
  private TextField commanderUnitName = new TextField();
  @FXML
  private TextArea infantryUnitDetails = new TextArea();
  @FXML
  private TextArea cavalryUnitDetails = new TextArea();
  @FXML
  private TextArea rangedUnitDetails = new TextArea();
  @FXML
  private TextArea commanderUnitDetails = new TextArea();

  /**
   * Set a scene for CreateGame.fxml in current class.
   *
   * @param createGameScene createGame's scene.
   */
  public void setCreateGameScene(Scene createGameScene) {
    this.createGameScene = createGameScene;
  }

  /**
   * Changes scene when button is pressed.
   *
   * @param actionEvent when button is pressed.
   */
  @FXML
  protected void createGameButtonPressed(ActionEvent actionEvent) {
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(stage, this.createGameScene);
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

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    this.armyName.setEditable(false);
    this.infantryUnitName.setEditable(false);
    this.cavalryUnitName.setEditable(false);
    this.rangedUnitName.setEditable(false);
    this.commanderUnitName.setEditable(false);
    this.infantryUnitDetails.setEditable(false);
    this.cavalryUnitDetails.setEditable(false);
    this.rangedUnitDetails.setEditable(false);
    this.commanderUnitDetails.setEditable(false);
  }

  /**
   * Sets Army
   *
   * @param army1 overwrite army.
   */
  public void setArmy1(Army army1) {
    this.army1 = army1;
  }

  /**
   * Sets Army
   *
   * @param army2 overwrite army.
   */
  public void setArmy2(Army army2) {
    this.army2 = army2;
  }

  /**
   * Sets text to army's name.
   */
  public void getArmyName1() {
    this.armyName.setText(army1.getArmyName());
  }

  /**
   * Sets text to army's name.
   */
  public void getArmyName2() {
    this.armyName.setText(army2.getArmyName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getInfantryUnitName1() {
    this.infantryUnitName.setText(army1.getInfantryUnits().get(0).getName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getInfantryUnitName2() {
    this.infantryUnitName.setText(army2.getInfantryUnits().get(0).getName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getCavalryUnitName1() {
    this.cavalryUnitName.setText(army1.getCavalryUnits().get(0).getName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getCavalryUnitName2() {
    this.cavalryUnitName.setText(army2.getCavalryUnits().get(0).getName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getRangedUnitName1() {
    this.rangedUnitName.setText(army1.getRangedUnits().get(0).getName());
  }

  public void getRangedUnitName2() {
    this.rangedUnitName.setText(army2.getRangedUnits().get(0).getName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getCommanderUnitName1() {
    this.commanderUnitName.setText(army1.getCommanderUnits().get(0).getName());
  }

  /**
   * Sets text to unit's name.
   */
  public void getCommanderUnitName2() {
    this.commanderUnitName.setText(army2.getCommanderUnits().get(0).getName());
  }

  /**
   * Sets text to unit's stats.
   */
  public void getInfantryDetails1() {
    this.infantryUnitDetails.setText("Health: " + army1.getInfantryUnits().get(0).getHealth() + "\n" +
        "Armor " + army1.getInfantryUnits().get(0).getArmor() + "\n" +
        "Attack" + army1.getInfantryUnits().get(0).getAttack());
    }

  /**
   * Sets text to unit's stats.
   */
  public void getInfantryDetails2() {
    this.infantryUnitDetails.setText("Health: " + army2.getInfantryUnits().get(0).getHealth() + "\n" +
        "Armor " + army2.getInfantryUnits().get(0).getArmor() + "\n" +
        "Attack" + army2.getInfantryUnits().get(0).getAttack());
  }

  /**
   * Sets text to unit's stats.
   */
  public void getCavalryDetails1() {
    this.cavalryUnitDetails.setText("Health: " + army1.getCavalryUnits().get(0).getHealth() + "\n" +
        "Armor " + army1.getCavalryUnits().get(0).getArmor() + "\n" +
        "Attack" + army1.getCavalryUnits().get(0).getAttack());
  }

  /**
   * Sets text to unit's stats.
   */
  public void getCavalryDetails2() {
    this.cavalryUnitDetails.setText("Health: " + army2.getCavalryUnits().get(0).getHealth() + "\n" + "Armor " +
        army2.getCavalryUnits().get(0).getArmor() + "\n" + "Attack" +
        army2.getCavalryUnits().get(0).getAttack());
  }

  /**
   * Sets text to unit's stats.
   */
  public void getRangedDetails1() {
    this.rangedUnitDetails.setText("Health: " + army1.getRangedUnits().get(0).getHealth() + "\n" +
        "Armor " + army1.getRangedUnits().get(0).getArmor() + "\n" +
        "Attack" + army1.getRangedUnits().get(0).getAttack());
    }

  /**
   * Sets text to unit's stats.
   */
  public void getRangedDetails2() {
    this.rangedUnitDetails.setText("Health: " + army2.getRangedUnits().get(0).getHealth() + "\n" + "Armor " +
        army2.getRangedUnits().get(0).getArmor() + "\n" + "Attack" +
        army2.getRangedUnits().get(0).getAttack());
    }

  /**
   * Sets text to unit's stats.
   */
    public void getCommanderDetails1() {
      this.commanderUnitDetails.setText("Health: " + army1.getCommanderUnits().get(0).getHealth() + "\n" +
          "Armor " + army1.getCommanderUnits().get(0).getArmor() + "\n" +
          "Attack" + army1.getCommanderUnits().get(0).getAttack());
      }

  /**
   * Sets text to unit's stats.
   */
      public void getCommanderDetails2() {
        this.commanderUnitDetails.setText("Health: " + army2.getCommanderUnits().get(0).getHealth() + "\n" + "Armor " +
            army2.getInfantryUnits().get(0).getArmor() + "\n" + "Attack" +
            army2.getInfantryUnits().get(0).getAttack());
      }
}
