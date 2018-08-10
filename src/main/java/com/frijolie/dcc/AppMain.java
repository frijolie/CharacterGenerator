package com.frijolie.dcc;

import com.frijolie.dcc.controller.CharacterSheetController;
import com.frijolie.dcc.controller.MenuController;
import com.frijolie.dcc.controller.ToolbarController;
import com.frijolie.dcc.model.DCCCharacter;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AppMain extends Application {

  DCCCharacter character;
  BorderPane borderPane;
  MenuBar menubar;
  ToolBar toolBar;

  @Override
  public void start(Stage primaryStage) {
    // TODO need to execute a number of read tasks which populate factories
    // TODO onSuccess() of the read and loads, then create the model class and start the GUI
    character = new DCCCharacter();
    URL appIconURL = getClass().getResource("/images/d20.png");
    Image appIcon = new Image(appIconURL.toString());
    primaryStage.getIcons().add(appIcon);
    primaryStage.setTitle("Character Sheet Generator");
    primaryStage.setResizable(false);
    primaryStage.centerOnScreen();
    primaryStage.setScene(createScene());
    String toolbarStylesheet = getClass().getResource("/css/Toolbar.css").toString();
    toolBar.getStylesheets().add(toolbarStylesheet);
    String mainStylesheet = getClass().getResource("/css/CharacterSheet.css").toString();
    borderPane.getStylesheets().add(mainStylesheet);
    primaryStage.toFront();
    primaryStage.show();
  }

  private Scene createScene() {
    borderPane = new BorderPane();
    borderPane.setTop(createMenus());
    borderPane.setCenter(createMainContent());
    Scene scene = new Scene(borderPane);
    scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Aclonica");
    return scene;
  }

  private AnchorPane createMainContent() {
    FXMLLoader sheetLoader = new FXMLLoader(getClass().getResource("/fxml/CharacterSheet.fxml"));
    sheetLoader.setController(new CharacterSheetController(character));
    try {
      return sheetLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Could not load /fxml/CharacterSheet.fxml");
    }
    return null;
  }

  private VBox createMenus() {
    VBox vbox = new VBox();
    menubar = createMenuBar();
    toolBar = createToolBar();
    vbox.getChildren().addAll(menubar, toolBar);
    return vbox;
  }

  private ToolBar createToolBar() {
    FXMLLoader toolbarLoader = new FXMLLoader(getClass().getResource("/fxml/Toolbar.fxml"));
    toolbarLoader.setController(new ToolbarController(character));
    try {
      return toolbarLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Could not load /fxml/Toolbar.fxml");
    }
    return null;
  }

  private MenuBar createMenuBar() {
    FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
    menuLoader.setController(new MenuController(character));
    try {
      return menuLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Could not load /fxml/Menu.fxml");
    }
    return null;
  }

}