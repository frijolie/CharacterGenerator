package com.frijolie.dcc.controller;

import com.frijolie.dcc.model.DCCCharacter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    regenerateButton.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
      if (event.getCode() == KeyCode.F5) {
        regenerateCharacter();
      }
    });
  }

  private void regenerateCharacter() {
    character.refresh();
  }
}
