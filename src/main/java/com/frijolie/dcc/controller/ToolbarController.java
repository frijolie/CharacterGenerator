package com.frijolie.dcc.controller;

import com.frijolie.dcc.model.DCCCharacter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ToolbarController implements Initializable {

  @FXML
  private Button regenerateButton;

  DCCCharacter character;

  public ToolbarController(DCCCharacter character) {
    this.character = character;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    regenerateButton.setOnAction(event -> regenerateCharacter());
  }

  private void regenerateCharacter() {
    character.refresh();
  }
}
