package com.frijolie.dcc.model.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.io.ArmorSerializer;
import com.frijolie.dcc.model.inventory.DCCCurrency.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ArmorTest {

  private List<Armor> armorList;

  ArmorTest() {
    DCCCurrency gold = new DCCCurrency(Type.GOLD);
    DCCCurrency silver = new DCCCurrency(Type.SILVER);
    DCCCurrency copper = new DCCCurrency(Type.COPPER);
    armorList = new ArrayList<>();
    ArmorSerializer armorSerializer = new ArmorSerializer();
    armorList.addAll(armorSerializer.getArmorList());
  }

  @Test
  void armorListShouldHave11Elements() {
    assertEquals(11, armorList.size(),
        "ArmorList should have 11 elements. Instead it has: " + armorList.size());
  }

  @Test
  void armorListShouldContainUnarmoredArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Unarmored")),
        "The list of armor should contain Unarmored");
  }

  @Test
  void armorListShouldContainLeatherArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Leather")),
        "The list of armor should contain Leather");
  }

  @Test
  void armorListShouldContainStuddedLeatherArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Studded leather")),
        "The list of armor should contain Studded leather");
  }

  @Test
  void armorListShouldContainHideArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Hide")),
        "The list of armor should contain Hide");
  }

  @Test
  void armorListShouldContainScaleMailArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Scale mail")),
        "The list of armor should contain Scale mail");
  }

  @Test
  void armorListShouldContainChainmailArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Chainmail")),
        "The list of armor should contain Chainmail");
  }

  @Test
  void armorListShouldContainBandedMailArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Banded mail")),
        "The list of armor should contain Banded mail");
  }

  @Test
  void armorListShouldContainHalfPlateArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Half-plate")),
        "The list of armor should contain Half-plate");
  }

  @Test
  void armorListShouldContainFullPlateArmor() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Full plate")),
        "The list of armor should contain Full plate");
  }

  @Test
  void armorListShouldContainAShield() {
    assertTrue(armorList.stream().map(Armor::getName).anyMatch(armor -> armor.equals("Shield")),
        "The list of armor should contain a Shield");
  }

  @Test
  void equals_aShieldShouldEqualAnotherShield() {
    Armor shield = armorList.stream()
        .filter(armor -> armor.getName().equals("Shield"))
        .findFirst()
        .orElseThrow();
    assertEquals(shield, shield);
  }

  @Test
  void equals_aShieldShouldNotEqualUnarmored() {
    Armor unarmored = armorList.stream()
        .filter(armor -> armor.getName().equals("Unarmored"))
        .findFirst()
        .orElseThrow();
    Armor shield = armorList.stream()
        .filter(armor -> armor.getName().equals("Shield"))
        .findFirst()
        .orElseThrow();
    assertNotEquals(unarmored, shield);
  }

}