package com.frijolie.dcc.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.model.inventory.Ammunition;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AmmunitionSerializerTest {

  private List<Ammunition> ammoList;
  private AmmunitionSerializer ammoSerializer;

  @BeforeEach
  void setUp() {
    ammoSerializer = new AmmunitionSerializer();
    ammoList = new ArrayList<>(ammoSerializer.getAmmoList());
  }

  @AfterEach
  void tearDown() {
    ammoList.clear();
    ammoList = null;
    ammoSerializer = null;
  }

  @Test
  void ammoListShouldContainFourElements() {
    assertEquals(4, ammoList.size(),
        "ammoList should have four elements. Instead it has " + ammoList.size());
  }

  @Test
  void ammoListShouldContainAmmoArrows() {
    assertTrue(ammoList.stream().anyMatch(a -> a.getName().equals("Arrows")),
        "ammoList does not contain 'Arrows'");
  }

  @Test
  void ammoListShouldContainSilverTippedArrows() {
    assertTrue(ammoList.stream().anyMatch(a -> a.getName().contains("silver")),
        "ammoList does not contain silver-tipped arrows");
  }

  @Test
  void ammoListShouldContainQuarrels() {
    assertTrue(ammoList.stream().anyMatch(a -> a.getName().contains("Quarrels")),
        "ammoList does not contain quarrels");
  }

  @Test
  void ammoListShouldContainSlingStones() {
    assertTrue(ammoList.stream().anyMatch(a -> a.getName().contains("Sling")),
        "ammoList does not contain sling stones");
  }

  @Disabled
  @Test
  void writeToJson() {
    ammoSerializer.writeToJson();
  }
}