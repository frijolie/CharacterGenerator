package com.frijolie.dcc.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.frijolie.dcc.model.inventory.Occupation;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OccupationSerializerTest {

  private OccupationSerializer occupationSerializer;
  private List<Occupation> occupationList;

  @BeforeEach
  void setUp() {
    occupationSerializer = new OccupationSerializer();
  }

  @AfterEach
  void tearDown() {
    occupationSerializer = null;
  }

  @Disabled
  @Test
  void writeToJson() {
    occupationSerializer.writeToJson();
  }

  @Test
  void occupationListShouldContain80Occupations() {
    assertEquals(80, occupationSerializer.getOccupationList().size(),
        "OccupationList should contain 80 occupations. Instead it contains: " +
            occupationSerializer.getOccupationList().size());
  }
}