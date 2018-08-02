package com.frijolie.dcc.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OccupationSerializerTest {

  private OccupationSerializer os;

  @BeforeEach
  void setUp() {
    os = new OccupationSerializer();
  }

  @AfterEach
  void tearDown() {
    os = null;
  }

  @Test
  void writeToJson() {
    os.writeToJson();
  }

  @Test
  void occupationListShouldContain80Occupations() {
    assertEquals(80, os.getOccupationList().size(),
        "OccupationList should contain 79 occupations. instead it contained: " +
        os.getOccupationList().size());
  }
}