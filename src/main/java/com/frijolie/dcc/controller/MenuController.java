package com.frijolie.dcc.controller;

import com.frijolie.dcc.model.DCCCharacter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class MenuController implements Initializable {

  DCCCharacter character;

  public MenuController(DCCCharacter character) {
    this.character = character;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}
