module no.ntnu.iir.wargames {
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  opens no.ntnu.iir.wargames.UI to javafx.fxml;
  exports no.ntnu.iir.wargames;
  exports no.ntnu.iir.wargames.data;
  opens no.ntnu.iir.wargames to javafx.fxml;
  exports no.ntnu.iir.wargames.service;
  opens no.ntnu.iir.wargames.service to javafx.fxml;
  exports no.ntnu.iir.wargames.simulation;
  opens no.ntnu.iir.wargames.simulation to javafx.fxml;
}