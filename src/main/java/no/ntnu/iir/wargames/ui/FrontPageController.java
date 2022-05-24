package no.ntnu.iir.wargames.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for the front page.
 * Linked to the FXML-file representing the view of MVC of JavaFx FXML.
 *
 * @author Håvard H. Vestbø
 * @version 1.0
 */
public class FrontPageController {

  @FXML
  private Button createGameButtonPressed;
  @FXML
  private Scene createGameScene;

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
}
