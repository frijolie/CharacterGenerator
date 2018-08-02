package com.frijolie.dcc.controller;

import com.frijolie.dcc.model.DCCCharacter;
import com.frijolie.dcc.model.inventory.Armor;
import com.frijolie.dcc.model.inventory.DCCCurrency;
import com.frijolie.dcc.model.inventory.Item;
import com.frijolie.dcc.model.inventory.Weapon;
import com.frijolie.dcc.view.AbilityScoreTextField;
import com.frijolie.dcc.view.PositivePrefixTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

public class CharacterSheetController implements Initializable {

  @FXML
  private AnchorPane characterSheet;

  @FXML
  private TextField charName, charTitle, occupation, charClass, speed, level, xp, armorClass;

  @FXML
  private TextField hitPoints, actionDie, critDie, critTable, luckyRoll, maxHP;

  @FXML
  private PositivePrefixTextField initiative, strengthMod, agilityMod, staminaMod, personalityMod;

  @FXML
  private PositivePrefixTextField luckMod, intelligenceMod, refSave, fortSave, willSave, meleeAttack;

  @FXML
  private PositivePrefixTextField meleeDamage, missileAttack, missileDamage, attack;

  @FXML
  private AbilityScoreTextField strength, agility, luck, intelligence, personality, stamina;

  @FXML
  private ListView<String> charNotes;

  @FXML
  private ListView<Armor> charArmor;

  @FXML
  private TableView<DCCCurrency> charTreasure;

  @FXML
  private TableColumn<DCCCurrency, String> treasureName;

  @FXML
  private TableColumn<DCCCurrency, String> treasureQty;

  @FXML
  private ListView<Weapon> charWeapons;

  @FXML
  private ListView<Item> charEquipment;


  DCCCharacter character;

  public CharacterSheetController(DCCCharacter character) {
    this.character = character;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    strength.textProperty().bind(character.getStrength().scoreProperty().asString());
    strengthMod.textProperty().bind(character.getStrengthMod().modifierProperty().asString());
    agility.textProperty().bind(character.getAgility().scoreProperty().asString());
    agilityMod.textProperty().bind(character.getAgilityMod().modifierProperty().asString());
    stamina.textProperty().bind(character.getStamina().scoreProperty().asString());
    staminaMod.textProperty().bind(character.getStaminaMod().modifierProperty().asString());
    intelligence.textProperty().bind(character.getIntelligence().scoreProperty().asString());
    intelligenceMod.textProperty().bind(character.getIntelligenceMod().modifierProperty().asString());
    personality.textProperty().bind(character.getPersonality().scoreProperty().asString());
    personalityMod.textProperty().bind(character.getPersonalityMod().modifierProperty().asString());
    luck.textProperty().bind(character.getLuck().scoreProperty().asString());
    luckMod.textProperty().bind(character.getLuckMod().modifierProperty().asString());
    luckyRoll.textProperty().bind(character.getLuckyRoll().rollResultProperty().asString());
    charNotes.setItems(character.getNotes());
    refSave.textProperty().bind(character.getReflexSave().savingThrowProperty().asString());
    Tooltip refSaveToolTip = new Tooltip("Ref Save = AgilityMod + Class (Level) Bonus"
        + " + LuckMod (if lucky roll applies)");
    refSave.setTooltip(refSaveToolTip);
    willSave.textProperty().bind(character.getWillpowerSave().savingThrowProperty().asString());
    Tooltip willSaveTooltip = new Tooltip("Will Save = PersonalityMod + Class (Level) Bonus"
        + " + LuckMod (if lucky roll applies)");
    willSave.setTooltip(willSaveTooltip);
    fortSave.textProperty().bind(character.getFortitudeSave().savingThrowProperty().asString());
    Tooltip fortSaveTooltip = new Tooltip("Fort Save = StaminaMod + Class (Level) Bonus"
        + " + LuckMod (if lucky roll applies)");
    fortSave.setTooltip(fortSaveTooltip);
    critDie.textProperty().bind(character.getCharacterClass().critDieProperty());
    critTable.textProperty().bind(character.getCharacterClass().critTableProperty());
    actionDie.textProperty().bind(character.getCharacterClass().actionDiceProperty());
    attack.textProperty().bind(character.getCharacterClass().attackBonusProperty().asString());
    xp.textProperty().bind(character.getCharacterClass().experiencePointsProperty().asString());
    level.textProperty().bind(character.getCharacterClass().characterLevelProperty().asString());
    speed.textProperty().bind(character.getCharacterClass().characterSpeedProperty().asString());
    maxHP.textProperty().bind(character.getHitPoints().hitPointsProperty().asString());
    Tooltip maxHPTooltip = new Tooltip("0-level MaxHP = 1d4 + StaminaMod. Must be at least 1");
    hitPoints.textProperty().bind(character.getHitPoints().hitPointsProperty().asString());
    hitPoints.setTooltip(maxHPTooltip);
    maxHP.setTooltip(maxHPTooltip);
    meleeAttack.textProperty().bind(character.getMeleeAttack().bonusProperty().asString());
    meleeDamage.textProperty().bind(character.getMeleeDamage().bonusProperty().asString());
    missileAttack.textProperty().bind(character.getMissileAttack().bonusProperty().asString());
    missileDamage.textProperty().bind(character.getMissileDamage().bonusProperty().asString());
    armorClass.textProperty().bind(character.getArmorClass().armorClassProperty().asString());
    Tooltip acToolTip = new Tooltip("AC = 10 + AgilityModifier + Armor Bonus(es) + Magical Modifiers ");
    armorClass.setTooltip(acToolTip);
    charArmor.setItems(character.getEquippedArmor().getArmorList());
    charArmor.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Armor armor, boolean empty) {
        super.updateItem(armor, empty);
        if (empty || armor == null) {
          setText(null);
        } else {
          setText(armor.getName());
        }
      }
    });
    charTreasure.setColumnResizePolicy((param) -> false);
    treasureName.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
    treasureQty.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asString());
    charTreasure.setItems(character.getTreasure());
    charEquipment.setItems(character.getEquipment());
    charEquipment.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item == null) {
          setText(null);
        } else {
          setText(item.getName());
        }
      }
    });
    charWeapons.setItems(character.getWeaponList());
    charWeapons.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Weapon weapon, boolean empty) {
        super.updateItem(weapon, empty);
        if(empty || weapon == null) {
          setText(null);
        } else {
          setText(weapon.getName());
        }
      }
    });
    charClass.setText(character.getCharacterClass().getClassName());
    occupation.setText(character.getOccupation().getName());
    character.characterClassProperty().addListener(((observable, oldValue, newValue) -> {
      charClass.setText(newValue.getClassName());
    }));
    character.occupationProperty().addListener(((observable, oldValue, newValue) -> {
      occupation.setText(newValue.getName());
    }));
  }
}
