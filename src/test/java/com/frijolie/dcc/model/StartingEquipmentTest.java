package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class StartingEquipmentTest {

  @Test
  void index1ShouldBeABackpack() {
    assertAll("1st item in startingEquipment should not be null and be a backpack",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(1),
            "index 1 should not be null"),
        () -> assertEquals("Backpack",
            StartingEquipment.startingEquipment.get(1).getName(),
            "The 1st element in startingEquipment should be a backpack")
    );
  }

  @Test
  void index2ShouldBeACandle() {
    assertAll("2nd item in startingEquipment should not be null and be a candle",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(2),
            "index 2 should not be null"),
        () -> assertEquals("Candle", StartingEquipment.startingEquipment.get(2).getName(),
            "The 2nd element in startingEquipment should be a candle")
    );
  }

  @Test
  void index3ShouldBeAChain() {
    assertAll("3rd item in startingEquipment should not be null and be a chain",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(3),
            "index 3 should not be null"),
        () -> assertEquals("Chain, 10'",
            StartingEquipment.startingEquipment.get(3).getName(),
            "The 3rd element in startingEquipment should be a chain")
    );
  }

  @Test
  void index4ShouldBeChalk() {
    assertAll("4th item in startingEquipment should not be null and be chalk",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(4),
            "index 4 should not be null"),
        () -> assertEquals("Chalk, 1 piece",
            StartingEquipment.startingEquipment.get(4).getName(),
            "The 4th element in startingEquipment should be chalk")
    );
  }

  @Test
  void index5ShouldBeAnEmptyChest() {
    assertAll("5th item in startingEquipment should not be null and be an empty chest",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(5),
            "index 5 should not be null"),
        () -> assertEquals("Chest, empty",
            StartingEquipment.startingEquipment.get(5).getName(),
            "The 5th element in startingEquipment should be an empty chest")
    );
  }

  @Test
  void index6ShouldBeACrowbar() {
    assertAll("6th item in startingEquipment should not be null and be a crowbar",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(6),
            "index 6 should not be null"),
        () -> assertEquals("Crowbar", StartingEquipment.startingEquipment.get(6).getName(),
            "The 6th element in startingEquipment should be a crowbar")
    );
  }

  @Test
  void index7ShouldBeAFlask() {
    assertAll("7th item in startingEquipment should not be null and be an empty flask",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(7),
            "index 7 should not be null"),
        () -> assertEquals("Flask, empty",
            StartingEquipment.startingEquipment.get(7).getName(),
            "The 7th element in startingEquipment should be an empty flask")
    );
  }

  @Test
  void index8ShouldBeFlintAndSteel() {
    assertAll("8th item in startingEquipment should not be null and be flint & steel",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(8),
            "index 8 should not be null"),
        () -> assertEquals("Flint & steel",
            StartingEquipment.startingEquipment.get(8).getName(),
            "The 8th element in startingEquipment should be flint & steel")
    );
  }

  @Test
  void index9ShouldBeAGrapplingHook() {
    assertAll("9th item in startingEquipment should not be null and be a grappling hook",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(9),
            "index 9 should not be null"),
        () -> assertEquals("Grappling hook",
            StartingEquipment.startingEquipment.get(9).getName(),
            "The 9th element in startingEquipment should be a grappling hook")
    );
  }

  @Test
  void index10ShouldBeASmallHammer() {
    assertAll("10th item in startingEquipment should not be null and be a small hammer",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(10),
            "index 10 should not be null"),
        () -> assertEquals("Hammer, small",
            StartingEquipment.startingEquipment.get(10).getName(),
            "The 10th element in startingEquipment should be a small hammer")
    );
  }

  @Test
  void index11ShouldBeAHolySymbol() {
    assertAll("11th item in startingEquipment should not be null and be a holy symbol",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(11),
            "index 11 should not be null"),
        () -> assertEquals("Holy symbol",
            StartingEquipment.startingEquipment.get(11).getName(),
            "The 11th element in startingEquipment should be a holy symbol")
    );
  }

  @Test
  void index12ShouldBeHolyWater() {
    assertAll("12th item in startingEquipment should not be null and be holy water",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(12),
            "index 12 should not be null"),
        () -> assertEquals("Holy water, 1 vial**",
            StartingEquipment.startingEquipment.get(12).getName(),
            "The 12th element in startingEquipment should be holy water")
    );
  }

  @Test
  void index13ShouldBeAnIronSpike() {
    assertAll("13th item in startingEquipment should not be null and be an iron spike",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(13),
            "index 13 should not be null"),
        () -> assertEquals("Iron spike",
            StartingEquipment.startingEquipment.get(13).getName(),
            "The 13th element in startingEquipment should be an iron spike")
    );
  }

  @Test
  void index14ShouldBeALantern() {
    assertAll("14th item in startingEquipment should not be null and be a lantern",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(14),
            "index 14 should not be null"),
        () -> assertEquals("Lantern",
            StartingEquipment.startingEquipment.get(14).getName(),
            "The 14th element in startingEquipment should be a lantern")
    );
  }

  @Test
  void index15ShouldBeAMirror() {
    assertAll("15th item in startingEquipment should not be null and be a hand-sized mirror",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(15),
            "index 15 should not be null"),
        () -> assertEquals("Mirror, hand-sized",
            StartingEquipment.startingEquipment.get(15).getName(),
            "The 15th element in startingEquipment should be a hand-sized mirror")
    );
  }

  @Test
  void index16ShouldBeAFlaskOfOil() {
    assertAll("16th item in startingEquipment should not be null and be a flask of oil",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(16),
            "index 16 should not be null"),
        () -> assertEquals("Oil, 1 flask***",
            StartingEquipment.startingEquipment.get(16).getName(),
            "The 16th element in startingEquipment should be a flask of oil")
    );
  }

  @Test
  void index17ShouldBeA10FootPole() {
    assertAll("17th item in startingEquipment should not be null and be a 10-foot pole",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(17),
            "index 17 should not be null"),
        () -> assertEquals("Pole, 10'",
            StartingEquipment.startingEquipment.get(17).getName(),
            "The second element in startingEquipment should be a candle")
    );
  }

  @Test
  void index18ShouldBeRations() {
    assertAll("18th item in startingEquipment should not be null and be rations",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(18),
            "index 2 should not be null"),
        () -> assertEquals("Rations, 1 day",
            StartingEquipment.startingEquipment.get(18).getName(),
            "The 18th element in startingEquipment should be rations")
    );
  }

  @Test
  void index19ShouldBeA50FootRope() {
    assertAll("19th item in startingEquipment should not be null and be a 50-foot rope",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(19),
            "index 19 should not be null"),
        () -> assertEquals("Rope, 50'",
            StartingEquipment.startingEquipment.get(19).getName(),
            "The 19th element in startingEquipment should be a 50-foot rope")
    );
  }

  @Test
  void index20ShouldBeALargeSack() {
    assertAll("20th item in startingEquipment should not be null and be a large sack",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(20),
            "index 20 should not be null"),
        () -> assertEquals("Sack, large",
            StartingEquipment.startingEquipment.get(20).getName(),
            "The 20th element in startingEquipment should be a large sack")
    );
  }

  @Test
  void index21ShouldBeASmallSack() {
    assertAll("21st item in startingEquipment should not be null and be a small sack",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(21),
            "index 21 should not be null"),
        () -> assertEquals("Sack, small",
            StartingEquipment.startingEquipment.get(21).getName(),
            "The second element in startingEquipment should be a small sack")
    );
  }

  @Test
  void index22ShouldBeThievesTools() {
    assertAll("22nd item in startingEquipment should not be null and be thieves tools",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(22),
            "index 22 should not be null"),
        () -> assertEquals("Thieves' tools",
            StartingEquipment.startingEquipment.get(22).getName(),
            "The 22nd element in startingEquipment should be a thieves tools")
    );
  }

  @Test
  void index23ShouldBeATorch() {
    assertAll("23rd item in startingEquipment should not be null and be a torch",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(23),
            "index 23 should not be null"),
        () -> assertEquals("Torch", StartingEquipment.startingEquipment.get(23).getName(),
            "The 23rd element in startingEquipment should be a torch")
    );
  }

  @Test
  void index24ShouldBeAWaterskin() {
    assertAll("24th item in startingEquipment should not be null and be a waterskin",
        () -> assertNotNull(StartingEquipment.startingEquipment.get(24),
            "index 24 should not be null"),
        () -> assertEquals("Waterskin",
            StartingEquipment.startingEquipment.get(24).getName(),
            "The 24th element in startingEquipment should be a waterskin")
    );
  }
}