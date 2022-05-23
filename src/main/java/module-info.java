module no.ntnu.iir.wargames {
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;

  opens no.ntnu.iir.wargames.ui to javafx.fxml;
  opens no.ntnu.iir.wargames.data to javafx.fxml;
  opens no.ntnu.iir.wargames.service to javafx.fxml;
  opens no.ntnu.iir.wargames.simulation to javafx.fxml;

  exports no.ntnu.iir.wargames.ui;
  exports no.ntnu.iir.wargames.data;
  exports no.ntnu.iir.wargames.service;
  exports no.ntnu.iir.wargames.simulation;
  exports no.ntnu.iir.wargames;

  opens no.ntnu.iir.wargames to javafx.fxml;
}