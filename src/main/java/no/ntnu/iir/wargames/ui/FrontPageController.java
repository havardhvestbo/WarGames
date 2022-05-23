package no.ntnu.iir.wargames.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FrontPageController {

  @FXML
  private Button createGameButtonPressed;
  @FXML
  private Scene createGameScene;

  public void setCreateGameScene(Scene createGameScene) {
    this.createGameScene = createGameScene;
  }

  @FXML
  protected void createGameButtonPressed(ActionEvent actionEvent) {
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(stage, this.createGameScene);
  }

  private void setScene(Stage stage, Scene newScene) {
    stage.hide();
    stage.setScene(newScene);
    stage.show();
  }
}
