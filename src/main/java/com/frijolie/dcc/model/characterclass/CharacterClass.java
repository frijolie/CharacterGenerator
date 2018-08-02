package com.frijolie.dcc.model.characterclass;

import com.frijolie.dcc.model.inventory.Weapon;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class CharacterClass {

  ReadOnlyIntegerWrapper hitPointBonus;
  ObservableList<Weapon> trainedWeapons;
  ObservableList<String> classAbilities;
  ReadOnlyIntegerWrapper attackBonus;
  ReadOnlyStringWrapper critDie;
  ReadOnlyStringWrapper critTable;
  ReadOnlyStringWrapper actionDice;
  ReadOnlyIntegerWrapper reflexBonus;
  ReadOnlyIntegerWrapper fortitudeBonus;
  ReadOnlyIntegerWrapper willpowerBonus;
  ReadOnlyStringWrapper className;
  ReadOnlyIntegerWrapper initiativeBonus;
  ReadOnlyIntegerWrapper characterLevel;
  ReadOnlyIntegerWrapper experiencePoints;
  ReadOnlyIntegerWrapper characterSpeed;
  int defaultSpeed;
  String hpPerLevel;
  int hpDicePerLevel;

  public CharacterClass() {
    this(0);
  }

  public CharacterClass(int level) {
    trainedWeapons = FXCollections.observableArrayList();
    classAbilities = FXCollections.observableArrayList();
    hitPointBonus = new ReadOnlyIntegerWrapper();
    attackBonus = new ReadOnlyIntegerWrapper();
    critDie = new ReadOnlyStringWrapper();
    critTable = new ReadOnlyStringWrapper();
    actionDice = new ReadOnlyStringWrapper();
    reflexBonus = new ReadOnlyIntegerWrapper();
    fortitudeBonus = new ReadOnlyIntegerWrapper();
    willpowerBonus = new ReadOnlyIntegerWrapper();
    className = new ReadOnlyStringWrapper();
    initiativeBonus = new ReadOnlyIntegerWrapper();
    characterLevel = new ReadOnlyIntegerWrapper();
    experiencePoints = new ReadOnlyIntegerWrapper();
    characterSpeed = new ReadOnlyIntegerWrapper();
    setCharacterLevel(level);
    calculateHitPointBonus();
    calculateTrainedWeapons();
    calculateAttackBonus();
    calculateCritDie();
    calculateCritTable();
    calculateActionDice();
    calculateReflexBonus();
    calculateFortitudeBonus();
    calculateWillpowerBonus();
  }

  abstract void calculateHitPointBonus();
  abstract void calculateTrainedWeapons();
  abstract void calculateAttackBonus();
  abstract void calculateCritDie();
  abstract void calculateCritTable();
  abstract void calculateActionDice();
  abstract void calculateReflexBonus();
  abstract void calculateFortitudeBonus();
  abstract void calculateWillpowerBonus();

  public int getHitPointBonus() {
    return hitPointBonus.get();
  }

  public ReadOnlyIntegerWrapper hitPointBonusProperty() {
    return hitPointBonus;
  }

  public void setHitPointBonus(int hitPointBonus) {
    this.hitPointBonus.set(hitPointBonus);
  }

  public ObservableList<String> getClassAbilities() {
    return classAbilities;
  }

  public void setClassAbilities(ObservableList<String> classAbilities) {
    this.classAbilities = classAbilities;
  }

  public int getAttackBonus() {
    return attackBonus.get();
  }

  public ReadOnlyIntegerWrapper attackBonusProperty() {
    return attackBonus;
  }

  public void setAttackBonus(int attackBonus) {
    this.attackBonus.set(attackBonus);
  }

  public String getCritDie() {
    return critDie.get();
  }

  public ReadOnlyStringWrapper critDieProperty() {
    return critDie;
  }

  public void setCritDie(String critDie) {
    this.critDie.set(critDie);
  }

  public String getCritTable() {
    return critTable.get();
  }

  public ReadOnlyStringWrapper critTableProperty() {
    return critTable;
  }

  public void setCritTable(String critTable) {
    this.critTable.set(critTable);
  }

  public String getActionDice() {
    return actionDice.get();
  }

  public ReadOnlyStringWrapper actionDiceProperty() {
    return actionDice;
  }

  public void setActionDice(String actionDice) {
    this.actionDice.set(actionDice);
  }

  public int getReflexBonus() {
    return reflexBonus.get();
  }

  public ReadOnlyIntegerWrapper refBonusProperty() {
    return reflexBonus;
  }

  public void setRefBonus(int refBonus) {
    this.reflexBonus.set(refBonus);
  }

  public int getFortBonus() {
    return fortitudeBonus.get();
  }

  public ReadOnlyIntegerWrapper fortBonusProperty() {
    return fortitudeBonus;
  }

  public void setFortBonus(int fortitudeBonus) {
    this.fortitudeBonus.set(fortitudeBonus);
  }

  public int getWillBonus() {
    return willpowerBonus.get();
  }

  public ReadOnlyIntegerWrapper willBonusProperty() {
    return willpowerBonus;
  }

  public void setWillBonus(int willpowerBonus) {
    this.willpowerBonus.set(willpowerBonus);
  }

  public String getClassName() {
    return className.get();
  }

  public ReadOnlyStringWrapper classNameProperty() {
    return className;
  }

  public void setClassName(String className) {
    this.className.set(className);
  }

  public int getInitiativeBonus() {
    return initiativeBonus.get();
  }

  public ReadOnlyIntegerWrapper initiativeBonusProperty() {
    return initiativeBonus;
  }

  public void setInitiativeBonus(int initiativeBonus) {
    this.initiativeBonus.set(initiativeBonus);
  }

  public int getCharacterLevel() {
    return characterLevel.get();
  }

  public ReadOnlyIntegerWrapper characterLevelProperty() {
    return characterLevel;
  }

  public void setCharacterLevel(int characterLevel) {
    this.characterLevel.set(characterLevel);
  }

  public int getExperiencePoints() {
    return experiencePoints.get();
  }

  public ReadOnlyIntegerWrapper experiencePointsProperty() {
    return experiencePoints;
  }

  public void setExperiencePoints(int experiencePoints) {
    this.experiencePoints.set(experiencePoints);
  }

  public int getCharacterSpeed() {
    return characterSpeed.get();
  }

  public ReadOnlyIntegerWrapper characterSpeedProperty() {
    return characterSpeed;
  }

  public void setCharacterSpeed(int characterSpeed) {
    this.characterSpeed.set(characterSpeed);
  }

  public int getDefaultSpeed() {
    return defaultSpeed;
  }

  public void setDefaultSpeed(int defaultSpeed) {
    this.defaultSpeed = defaultSpeed;
  }

  public String getHpPerLevel() {
    return hpPerLevel;
  }

  public void setHpPerLevel(String hpPerLevel) {
    this.hpPerLevel = hpPerLevel;
  }

  public int getHpDicePerLevel() {
    return hpDicePerLevel;
  }

  public void setHpDicePerLevel(int hpDicePerLevel) {
    this.hpDicePerLevel = hpDicePerLevel;
  }


}