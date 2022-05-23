package no.ntnu.iir.wargames.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A War game application. The application lets the player create a game between two armies.
 * The player can choose to load a file of an already existing army or create a army in the GUI.
 * When the player starts the battle, the GUI returns the winner and the remaining units.
 */
public class WarGamesApp extends Application {

  private Scene frontPageScene;
  private Scene createGameScene;
  private Scene armyDetailsScene;
  private Scene resultScene;
  private FrontPageController frontPageController;
  private CreateGameController createGameController;
  private ArmyDetailsController armyDetailsController;
  private ResultController resultController;

  @Override
  public void start(Stage stage) {
    try {
      FXMLLoader frontPageLoader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
      Parent frontPageRoot = frontPageLoader.load();
      this.frontPageScene = new Scene(frontPageRoot, 757, 443);
      this.frontPageController = frontPageLoader.getController();

      FXMLLoader createGameLoader = new FXMLLoader(getClass().getResource("CreateGame.fxml"));
      Parent createGameRoot = createGameLoader.load();
      this.createGameScene = new Scene(createGameRoot, 800, 600);
      this.createGameController = createGameLoader.getController();

      FXMLLoader armyDetailsLoader = new FXMLLoader(getClass().getResource("ArmyDetails.fxml"));
      Parent armyDetailsRoot = armyDetailsLoader.load();
      this.armyDetailsScene = new Scene(armyDetailsRoot, 800, 600);
      this.armyDetailsController = armyDetailsLoader.getController();

      FXMLLoader resultLoader = new FXMLLoader(getClass().getResource("Result.fxml"));
      Parent resultRoot = resultLoader.load();
      this.resultScene = new Scene(resultRoot, 800, 600);
      this.resultController = resultLoader.getController();

      this.frontPageController.setCreateGameScene(this.createGameScene);
      this.resultController.setCreateGameScene(this.createGameScene);
      this.createGameController.setResultScene(this.resultScene);
      this.createGameController.setResultController(this.resultController);

      stage.setTitle("War Games");
      stage.setScene(frontPageScene);
      stage.setResizable(false);
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
