module CharacterGenerator {
  requires javafx.graphics;
  requires javafx.fxml;
  requires javafx.controls;
  requires gson;
  requires java.sql;
  requires fx.gson;
  exports com.frijolie.dcc;
  opens com.frijolie.dcc.controller;
  opens com.frijolie.dcc.view;
  opens com.frijolie.dcc.model;
}