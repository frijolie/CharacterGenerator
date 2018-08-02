package com.frijolie.dcc.model.characterclass;

public class Halfling extends CharacterClass {

  public Halfling() {
    super.setClassName("Halfling");
    super.setCharacterSpeed(20);
    super.setAttackBonus(0);
    super.setCritDie("d4");
    super.setCritTable("I");
    super.setActionDice("d20");
    super.setRefBonus(0);
    super.setWillBonus(0);
    super.setFortBonus(0);
    super.setInitiativeBonus(0);
    super.setCharacterLevel(0);
    super.setAttackBonus(0);
    super.setHpDicePerLevel(4);
    super.setHpPerLevel("1d4");
    super.setCharacterLevel(0);
    super.setExperiencePoints(0);
  }

  @Override
  void calculateHitPointBonus() {

  }

  @Override
  void calculateTrainedWeapons() {

  }

  @Override
  void calculateAttackBonus() {

  }

  @Override
  void calculateCritDie() {

  }

  @Override
  void calculateCritTable() {

  }

  @Override
  void calculateActionDice() {

  }

  @Override
  void calculateReflexBonus() {

  }

  @Override
  void calculateFortitudeBonus() {

  }

  @Override
  void calculateWillpowerBonus() {

  }
}