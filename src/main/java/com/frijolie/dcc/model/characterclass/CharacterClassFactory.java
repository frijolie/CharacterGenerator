package com.frijolie.dcc.model.characterclass;

public class CharacterClassFactory {

  public static CharacterClass getCharacterClass(CharacterClassType type) {
    switch(type) {
      case ZERO_LEVEL:
        return new ZeroLevel();
      case CLERIC:
        return new Cleric();
      case THIEF:
        return new Thief();
      case WARRIOR:
        return new Warrior();
      case WIZARD:
        return new Wizard();
      case DWARF:
        return new Dwarf();
      case ELF:
        return new Elf();
      case HALFLING:
        return new Halfling();
      default:
        return null;
    }
  }
}