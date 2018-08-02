package com.frijolie.dcc;

import com.frijolie.dcc.controller.CharacterSheetController;
import com.frijolie.dcc.controller.MenuController;
import com.frijolie.dcc.controller.ToolbarController;
import com.frijolie.dcc.model.DCCCharacter;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
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

  @Override
  public void init() {
    character = new DCCCharacter();
  }

  @Override
  public void start(Stage primaryStage) {
    Platform.runLater(() -> {
      primaryStage.getIcons().add(new Image("/images/d20.png"));
      primaryStage.setTitle("Character Sheet Generator");
      primaryStage.setResizable(false);
      primaryStage.centerOnScreen();
      primaryStage.setScene(createScene());
      primaryStage.toFront();
      primaryStage.show();
    });
  }

  private Scene createScene() {
    BorderPane borderPane = new BorderPane();
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
    MenuBar menubar = createMenuBar();
    ToolBar toolBar = createToolBar();
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