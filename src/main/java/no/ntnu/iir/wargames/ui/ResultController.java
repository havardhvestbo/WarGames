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
import no.ntnu.iir.wargames.simulation.Battle;

/**
 * Controller for the result page.
 * Linked to the FXML-file representing the view of MVC of JavaFx FXML.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class ResultController implements Initializable {

  private Army army1;
  private Army army2;

  @FXML
  private Scene createGameScene;
  @FXML
  private Button startNewGame;
  @FXML
  private TextField army1Name = new TextField();
  @FXML
  private TextField army2Name = new TextField();
  @FXML
  private TextArea army1Result;
  @FXML
  private TextArea army2Result;
  @FXML
  private TextField result;

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
  protected void startNewGameButtonPressed(ActionEvent actionEvent) {
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

  /**
   * Sets Army
   *
   * @param army1 overwrite army.
   */
  public void setArmy1(Army army1){
    this.army1 = army1;
  }

  /**
   * Sets Army
   *
   * @param army2 overwrite army.
   */
  public void setArmy2(Army army2){
    this.army2 = army2;
  }

  /**
   * Sets text to army's name.
   */
  public void getArmyName1() {
    this.army1Name.setText(army1.getArmyName());
  }

  /**
   * Sets text to army's name.
   */
  public void getArmyName2() {
    this.army2Name.setText(army2.getArmyName());
  }
  /**
   * Sets text to battle's winner.
   */
  public void getBattleResult() {
    Battle battle = new Battle(army1, army2);
    this.result.setText("The winner of the epic war is "+ battle.simulate().getArmyName()+ " !");
  }

  /**
   * Sets text to number remaining units.
   */
  public void getUnitsLeft1() {
      this.army1Result.setText(
          "There are  " + army1.getInfantryUnits().size() + " infantry units left." +
              "\n" + "There are " + army1.getCavalryUnits().size() + " cavalry units left." +
              "\n" + "There are " + army1.getRangedUnits().size() + " ranged units left." +
              "\n" + "There are " + army1.getCommanderUnits().size() + " commander units left." );
    }

  /**
   * Sets text to number remaining units.
   */
  public void getUnitsLeft2() {
    this.army2Result.setText(
        "There are " + army2.getInfantryUnits().size() +  " infantry units left." +
            "\n" + "There are " + army2.getCavalryUnits().size() + " cavalry units left."  +
            "\n" + "There are " + army2.getRangedUnits().size() + " ranged units left." +
            "\n" +  "There are " + army2.getCommanderUnits().size() + " commander units left");
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    this.army1Name.setEditable(false);
    this.army2Name.setEditable(false);
    this.army1Result.setEditable(false);
    this.army2Result.setEditable(false);
  }
}
