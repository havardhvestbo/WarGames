package no.ntnu.iir.wargames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.iir.wargames.UI.FrontPageController;

public class WarGamesApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
      Parent root = fxmlLoader.load();
      FrontPageController frontPageController = fxmlLoader.getController();
      Scene scene = new Scene(root, 600, 400);
      primaryStage.setTitle("War Games");
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();
    } catch (Exception e) {
      System.out.println("ERROR:"  + e.getMessage());
    }
  }
  private void setScene(Stage stage, Scene newScene) {
    stage.hide();
    stage.setScene(newScene);
    stage.show();
  }
}
