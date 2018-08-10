package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.model.DiceRoller;

public class LanguageFactory {

  public static String getZeroLevelLanguage() {
    var randomRoll = DiceRoller.rollDice(1, 100);
    if (randomRoll >= 1 && randomRoll <= 20) {
      return Language.ALIGNMENT_TONGUE.toString();
    } else if (randomRoll >= 21 && randomRoll <= 30) {
      return Language.DWARF.toString();
    } else if (randomRoll >= 31 && randomRoll <= 35) {
      return Language.ELF.toString();
    } else if (randomRoll >= 36 && randomRoll <= 40) {
      return Language.HALFLING.toString();
    } else if (randomRoll >= 41 && randomRoll <= 45) {
      return Language.GNOME.toString();
    } else if (randomRoll >= 46 && randomRoll <= 47) {
      return Language.BUGBEAR.toString();
    } else if (randomRoll >= 48 && randomRoll <= 57) {
      return Language.GOBLIN.toString();
    } else if (randomRoll >= 58 && randomRoll <= 60) {
      return Language.GNOLL.toString();
    } else if (randomRoll >= 61 && randomRoll <= 65) {
      return Language.HARPY.toString();
    } else if (randomRoll >= 66 && randomRoll <= 75) {
      return Language.KOBOLD.toString();
    } else if (randomRoll >= 76 && randomRoll <= 80) {
      return Language.LIZARD_MAN.toString();
    } else if (randomRoll == 81) {
      return Language.MINOTAUR.toString();
    } else if (randomRoll >= 82 && randomRoll <= 83) {
      return Language.OGRE.toString();
    } else if (randomRoll >= 84 && randomRoll <= 93) {
      return Language.ORC.toString();
    } else if (randomRoll >= 94 && randomRoll <= 99) {
      return Language.TROGLODYTE.toString();
    } else if (randomRoll == 100) {
      return Language.GIANT.toString();
    } else {
      throw new IllegalStateException(
          "A 0-level language could not be determined with a roll of : " + randomRoll);
    }
  }

  public enum Language {
    ALIGNMENT_TONGUE,
    DWARF,
    ELF,
    HALFLING,
    GNOME,
    BUGBEAR,
    GOBLIN,
    GNOLL,
    HARPY,
    HOBGOBLIN,
    KOBOLD,
    LIZARD_MAN,
    MINOTAUR,
    OGRE,
    ORC,
    SERPENT_MAN,
    TROGLODYTE,
    ANGELIC,
    CENTAUR,
    DEMONIC,
    DOPPELGANGER,
    DRAGON,
    PIXIE,
    GIANT,
    GRIFFON,
    NAGA,
    BEAR,
    EAGLE,
    FERRET,
    HORSE,
    WOLF,
    SPIDER,
    UNDERCOMMON;

    @Override
    public String toString() {
      String name = name().replaceAll("_", " ");
      return name.charAt(0) + name.substring(1).toLowerCase();
    }
  }

}