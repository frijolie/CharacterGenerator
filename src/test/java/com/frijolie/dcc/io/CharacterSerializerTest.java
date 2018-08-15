package com.frijolie.dcc.io;

import com.frijolie.dcc.model.DCCCharacter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharacterSerializerTest {

  DCCCharacter character;

  @BeforeEach
  void setUp() {
    character = new DCCCharacter();
  }

  @AfterEach
  void tearDown() {
    character = null;
  }

  @Test
  void writeCharacterToJson() {
    CharacterSerializer.writeToJson(character);
  }

}