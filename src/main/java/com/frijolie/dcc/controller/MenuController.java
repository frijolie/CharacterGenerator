package com.frijolie.dcc.controller;

import com.frijolie.dcc.io.DefaultProperties;
import com.frijolie.dcc.model.DCCCharacter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;

public class MenuController implements Initializable {

  DCCCharacter character;
  ToolbarController toolbarController;

  @FXML
  private CheckMenuItem toolBarMenuItem;

  public MenuController(DCCCharacter character) {
    this.character = character;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    toolBarMenuItem.setSelected(DefaultProperties.getCheckMenuItem("toolBarMenuItem"));
  }

  public void setToolbarController(ToolbarController controller) {
    toolbarController = controller;
  }
}
