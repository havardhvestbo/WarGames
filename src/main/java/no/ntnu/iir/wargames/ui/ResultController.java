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

  public void setCreateGameScene(Scene createGameScene) {
    this.createGameScene = createGameScene;
  }

  @FXML
  protected void startNewGameButtonPressed(ActionEvent actionEvent) {
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(stage, this.createGameScene);
  }

  private void setScene(Stage stage, Scene newScene) {
    stage.hide();
    stage.setScene(newScene);
    stage.show();
  }

  public void setArmy1(Army army1){
    this.army1 = army1;
  }

  public void setArmy2(Army army2){
    this.army2 = army2;
  }

  public void getArmyName1() {
    this.army1Name.setText(army1.getArmyName());
  }

  public void getArmyName2() {
    this.army2Name.setText(army2.getArmyName());
  }

  public void getBattleResult() {
    Battle battle = new Battle(army1, army2);
    this.result.setText("The winner of the grand war is "+ battle.simulate().getArmyName()+ " !");
  }

  public void getUnitsLeft1() {
      this.army1Result.setText(
          "There are  " + army1.getInfantryUnits().size() + " infantry units left" +
              "\n " + "There are " + army1.getCavalryUnits().size() + " cavalry units left" +
              "\n " + "There are " + army1.getRangedUnits().size() + " ranged units left" +
              "\n" + "There are " + army1.getCommanderUnits().size() + " commander units left" );
    }

  public void getUnitsLeft2() {
    this.army2Result.setText(
        army2.getInfantryUnits().size() + " " + army2.getInfantryUnits().get(0).getName() +
            "\n " + "There are " + army2.getCavalryUnits().size() + " " + army2.getCavalryUnits().get(0).getName() +
            "\n " + army2.getRangedUnits().size() + " " + army2.getRangedUnits().get(0).getName() +
            "\n" + army2.getCommanderUnits().size() + " " + army2.getCommanderUnits().get(0).getName());
  }



  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    this.army1Name.setEditable(false);
    this.army2Name.setEditable(false);
    this.army1Result.setEditable(false);
    this.army2Result.setEditable(false);
  }
}
