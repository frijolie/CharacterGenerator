package com.frijolie.dcc.model.inventory;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class ArmorFactoryTest {

  @Test
  void getByName_Unarmored_ShouldReturnUnarmoredArmor() {
    Armor armor = ArmorFactory.getByName("Unarmored");
    assertAll("Asking for Unarmored armor should return Unarmored armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Unarmored", armor.getName(),
            "Unarmored armor name should be 'Unarmored'"),
        () -> assertEquals(0, armor.getAcBonus(),
            "unarmored ac bonus should = 0"),
        () -> assertEquals(0, armor.getCostInCopper(),
            "unarmored costInCopper should equal 0"),
        () -> assertEquals(0, armor.getCheckPenalty(),
            "Unarmored check penalty should be 0"),
        () -> assertEquals(0, armor.getSpeedPenalty(),
            "Unarmored speed penalty should be 0"),
        () -> assertEquals("d4", armor.getFumbleDie(),
            "Unarmored fumble die should be a 'd4'")
    );
  }

  @Test
  void getByName_Padded_ShouldReturnPaddedArmor() {
    Armor armor = ArmorFactory.getByName("Padded");
    assertAll("Asking for Padded armor should return Padded armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Padded", armor.getName(),
            "Padded armor name should be 'Padded'"),
        () -> assertEquals(1, armor.getAcBonus(),
            "Padded ac bonus should = 1"),
        () -> assertEquals(500, armor.getCostInCopper(),
            "Padded costInCopper should equal 500"),
        () -> assertEquals(0, armor.getCheckPenalty(),
            "Unarmored check penalty should be 0"),
        () -> assertEquals(0, armor.getSpeedPenalty(),
            "Unarmored speed penalty should be 0"),
        () -> assertEquals("d8", armor.getFumbleDie(),
            "Unarmored fumble die should be a 'd8'")
    );
  }

  @Test
  void getByName_Leather_ShouldReturnLeatherArmor() {
    Armor armor = ArmorFactory.getByName("Leather");
    assertAll("Asking for Leather armor should return Leather armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Leather", armor.getName(),
            "Leather armor name should be 'Leather'"),
        () -> assertEquals(2, armor.getAcBonus(),
            "Leather ac bonus should = 2"),
        () -> assertEquals(2000, armor.getCostInCopper(),
            "Leather costInCopper should equal 2,000"),
        () -> assertEquals(-1, armor.getCheckPenalty(),
            "Leather check penalty should be -1"),
        () -> assertEquals(0, armor.getSpeedPenalty(),
            "Leather speed penalty should be 0"),
        () -> assertEquals("d8", armor.getFumbleDie(),
            "Leather fumble die should be a 'd8'")
    );
  }

  @Test
  void getByName_StuddedLeather_ShouldReturnStuddedLeatherArmor() {
    Armor armor = ArmorFactory.getByName("Studded leather");
    assertAll(
        "Asking for Studded leather armor should return Studded leather armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Studded leather", armor.getName(),
            "Studded leather armor name should be 'Studded leather'"),
        () -> assertEquals(3, armor.getAcBonus(),
            "Studded leather ac bonus should = 3"),
        () -> assertEquals(4500, armor.getCostInCopper(),
            "Studded leather costInCopper should equal 4,500"),
        () -> assertEquals(-2, armor.getCheckPenalty(),
            "Studded leather check penalty should be -2"),
        () -> assertEquals(0, armor.getSpeedPenalty(),
            "Studded leather speed penalty should be 0"),
        () -> assertEquals("d8", armor.getFumbleDie(),
            "Studded leather fumble die should be a 'd8'")
    );
  }

  @Test
  void getByName_Hide_ShouldReturnHideArmor() {
    Armor armor = ArmorFactory.getByName("Hide");
    assertAll("Asking for Hide armor should return Hide armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Hide", armor.getName(),
            "Hide armor name should be 'Hide'"),
        () -> assertEquals(3, armor.getAcBonus(),
            "Hide ac bonus should = 3"),
        () -> assertEquals(3000, armor.getCostInCopper(),
            "Hide costInCopper should equal 3,000"),
        () -> assertEquals(-3, armor.getCheckPenalty(),
            "Hide check penalty should be -3"),
        () -> assertEquals(0, armor.getSpeedPenalty(),
            "Hide speed penalty should be 0"),
        () -> assertEquals("d12", armor.getFumbleDie(),
            "Hide fumble die should be a 'd12'")
    );
  }

  @Test
  void getByName_ScaleMail_ShouldReturnScaleMailArmor() {
    Armor armor = ArmorFactory.getByName("Scale mail");
    assertAll("Asking for Scale mail armor should return Scale mail armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Scale mail", armor.getName(),
            "Scale mail armor name should be 'Scale mail'"),
        () -> assertEquals(4, armor.getAcBonus(),
            "Scale mail ac bonus should = 4"),
        () -> assertEquals(8000, armor.getCostInCopper(),
            "Scale mail costInCopper should equal 8,000"),
        () -> assertEquals(-4, armor.getCheckPenalty(),
            "Scale mail check penalty should be -4"),
        () -> assertEquals(-5, armor.getSpeedPenalty(),
            "Scale mail speed penalty should be -5"),
        () -> assertEquals("d12", armor.getFumbleDie(),
            "Scale mail fumble die should be a 'd12'")
    );
  }

  @Test
  void getByName_Chainmail_ShouldReturnChainmailArmor() {
    Armor armor = ArmorFactory.getByName("Chainmail");
    assertAll("Asking for Chainmail armor should return Chainmail armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Chainmail", armor.getName(),
            "Chainmail armor name should be 'Chainmail'"),
        () -> assertEquals(5, armor.getAcBonus(),
            "Chainmail ac bonus should = 5"),
        () -> assertEquals(15000, armor.getCostInCopper(),
            "Chainmail costInCopper should equal 15,000"),
        () -> assertEquals(-5, armor.getCheckPenalty(),
            "Chainmail check penalty should be -5"),
        () -> assertEquals(-5, armor.getSpeedPenalty(),
            "Chainmail speed penalty should be -5"),
        () -> assertEquals("d12", armor.getFumbleDie(),
            "Chainmail fumble die should be a 'd12'")
    );
  }

  @Test
  void getByName_BandedMail_ShouldReturnBandedMailArmor() {
    Armor armor = ArmorFactory.getByName("Banded mail");
    assertAll("Asking for Banded mail armor should return Banded mail armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Banded mail", armor.getName(),
            "Banded mail armor name should be 'Banded mail'"),
        () -> assertEquals(6, armor.getAcBonus(),
            "Banded mail ac bonus should = 6"),
        () -> assertEquals(25000, armor.getCostInCopper(),
            "Banded mail costInCopper should equal 25,000"),
        () -> assertEquals(-6, armor.getCheckPenalty(),
            "Banded mail check penalty should be -5"),
        () -> assertEquals(-5, armor.getSpeedPenalty(),
            "Banded mail speed penalty should be -5"),
        () -> assertEquals("d16", armor.getFumbleDie(),
            "Banded mail fumble die should be a 'd16'")
    );
  }

  @Test
  void getByName_HalfPlate_ShouldReturnHalfPlateArmor() {
    Armor armor = ArmorFactory.getByName("Half-plate");
    assertAll("Asking for Half-plate armor should return Half-plate armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Half-plate", armor.getName(),
            "Half-plate armor name should be 'Half-plate'"),
        () -> assertEquals(7, armor.getAcBonus(),
            "Half-plate ac bonus should = 7"),
        () -> assertEquals(55000, armor.getCostInCopper(),
            "Half-plate costInCopper should equal 55,000"),
        () -> assertEquals(-7, armor.getCheckPenalty(),
            "Half-plate check penalty should be -7"),
        () -> assertEquals(-10, armor.getSpeedPenalty(),
            "Half-plate speed penalty should be -10"),
        () -> assertEquals("d16", armor.getFumbleDie(),
            "Half-plate fumble die should be a 'd16'")
    );
  }

  @Test
  void getByName_FullPlate_ShouldReturnFullPlateArmor() {
    Armor armor = ArmorFactory.getByName("Full plate");
    assertAll("Asking for Full plate armor should return Full plate armor with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Full plate", armor.getName(),
            "Full plate armor name should be 'Full plate'"),
        () -> assertEquals(8, armor.getAcBonus(),
            "Full plate ac bonus should = 8"),
        () -> assertEquals(120000, armor.getCostInCopper(),
            "Full plate costInCopper should equal 120,000"),
        () -> assertEquals(-8, armor.getCheckPenalty(),
            "Full plate check penalty should be -8"),
        () -> assertEquals(-10, armor.getSpeedPenalty(),
            "Full plate speed penalty should be -10"),
        () -> assertEquals("d16", armor.getFumbleDie(),
            "Full plate fumble die should be a 'd16'")
    );
  }

  @Test
  void getByName_Shield_ShouldReturnAShield() {
    Armor armor = ArmorFactory.getByName("Shield");
    assertAll("Asking for a Shield should return a Shield with correct stats",
        () -> assertNotNull(armor, "armor should not be null"),
        () -> assertEquals("Shield", armor.getName(),
            "Shield armor name should be 'Shield'"),
        () -> assertEquals(1, armor.getAcBonus(),
            "Shield ac bonus should = 1"),
        () -> assertEquals(1000, armor.getCostInCopper(),
            "Shield costInCopper should equal 1,000"),
        () -> assertEquals(-1, armor.getCheckPenalty(),
            "Shield check penalty should be -1"),
        () -> assertEquals(0, armor.getSpeedPenalty(),
            "Shield speed penalty should be 0"),
        () -> assertEquals("d8", armor.getFumbleDie(),
            "Shield fumble die should be a 'd8'")
    );
  }

  @Test
  void getByName_PassingANullParamShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> ArmorFactory.getByName(null),
        "Passing a null param should throw a NullPointerException");
  }

  @Test
  void getByName_RequestingANonExistentArmorShouldThrowNoSuchElementException() {
    assertThrows(NoSuchElementException.class, () -> ArmorFactory.getByName("Impenetrable Armor"),
        "Requesting a non-existent armor should throw a NoSuchElement Exception");
  }
}