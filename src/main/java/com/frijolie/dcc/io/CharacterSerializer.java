package com.frijolie.dcc.io;

import com.frijolie.dcc.model.DCCCharacter;

public class CharacterSerializer {

  public static void writeToJson(DCCCharacter character) {
    JsonWriter.writeToJson(character, "character.json");
  }

}