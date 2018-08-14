package com.frijolie.dcc.controller;

import com.frijolie.dcc.io.DefaultProperties;
import com.frijolie.dcc.model.DCCCharacter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuController implements Initializable {

  DCCCharacter character;
  ToolbarController toolbarController;
  @FXML
  private MenuItem quitMenuItem, newMenuItem, openMenuItem, saveMenuItem, jsonMenuItem, pdfMenuItem;

  @FXML
  private CheckMenuItem toolBarMenuItem;
  @FXML
  private MenuItem preferencesMenuItem, supportMenuItem, aboutMenuItem;
  @FXML
  private Menu exportMenu;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    toolBarMenuItem.setSelected(DefaultProperties.getCheckMenuItem("toolBarMenuItem"));
    boolean showMenuIcons = DefaultProperties.getBooleanValue("displayMenuIcons");
    if (showMenuIcons) {
      setMenuItemGraphics(getIconSize());
    } else {
      clearMenuItemGraphics();
    }
  }

  public MenuController(DCCCharacter character) {
    this.character = character;
  }

  private void setMenuItemGraphics(int size) {
    ImageView newImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/new.png")));
    newImage.setFitWidth(size);
    newImage.setFitHeight(size);
    newMenuItem.setGraphic(newImage);
    ImageView openImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/open.png")));
    openImage.setFitWidth(size);
    openImage.setFitHeight(size);
    openMenuItem.setGraphic(openImage);
    ImageView saveImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/save.png")));
    saveImage.setFitHeight(size);
    saveImage.setFitWidth(size);
    saveMenuItem.setGraphic(saveImage);
    ImageView quitImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/quit.png")));
    quitImage.setFitHeight(size);
    quitImage.setFitWidth(size);
    quitMenuItem.setGraphic(quitImage);
    ImageView jsonImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/json.png")));
    jsonImage.setFitWidth(size);
    jsonImage.setFitHeight(size);
    jsonMenuItem.setGraphic(jsonImage);
    ImageView pdfImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/pdf.png")));
    pdfImage.setFitWidth(size);
    pdfImage.setFitHeight(size);
    pdfMenuItem.setGraphic(pdfImage);
    ImageView preferencesImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/preferences.png")));
    preferencesImage.setFitHeight(size);
    preferencesImage.setFitWidth(size);
    preferencesMenuItem.setGraphic(preferencesImage);
    ImageView exportImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/export.png")));
    exportImage.setFitWidth(size);
    exportImage.setFitHeight(size);
    exportMenu.setGraphic(exportImage);
    ImageView supportImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/support.png")));
    supportImage.setFitHeight(size);
    supportImage.setFitWidth(size);
    supportMenuItem.setGraphic(supportImage);
    ImageView aboutImage = new ImageView(
        new Image(getClass().getResourceAsStream("/images/about.png")));
    aboutImage.setFitWidth(size);
    aboutImage.setFitHeight(size);
    aboutMenuItem.setGraphic(aboutImage);
  }

  private int getIconSize() {
    String size = DefaultProperties.getCustomProperty("menuIconSize");
    switch (size.toLowerCase()) {
      case "small":
        return IconSize.SMALL.getSize();
      case "medium":
        return IconSize.MEDIUM.getSize();
      case "large":
        return IconSize.LARGE.getSize();
      default:
        return IconSize.MEDIUM.getSize();
    }
  }

  private void clearMenuItemGraphics() {
    supportMenuItem.setGraphic(null);
    aboutMenuItem.setGraphic(null);
  }

  private enum IconSize {
    SMALL(16), MEDIUM(32), LARGE(64);
    private int size;

    IconSize(int size) {
      this.size = size;
    }

    public int getSize() {
      return size;
    }
  }

  public void setToolbarController(ToolbarController controller) {
    toolbarController = controller;
  }
}
