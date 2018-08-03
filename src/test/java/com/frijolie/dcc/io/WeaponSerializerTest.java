package com.frijolie.dcc.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.model.inventory.Weapon;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class WeaponSerializerTest {

  private List<Weapon> weapons;
  private WeaponSerializer weaponSerializer;

  WeaponSerializerTest() {
    weaponSerializer = new WeaponSerializer();
    weapons = new ArrayList<>();
    weapons.addAll(weaponSerializer.getWeaponList());
  }

  @AfterEach
  void tearDownAfterAll() {
    weapons.clear();
    weapons = null;
    weaponSerializer = null;
  }

  @Test
  void readingFromWeaponsJSONShouldContain23Weapons() {
    assertEquals(23, weapons.size(),
        "There should be 23 weapons in the list. Instead there are: " + weapons.size());
  }

  @Test
  void weaponsShouldContainABattleaxe() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .anyMatch(x -> x.equals("Battleaxe")),
        "The list of weapons should include a Battleaxe");
  }

  @Test
  void weaponsShouldContainABlackjack_NeedToStripSpecialCharacter() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .map(x -> x.replaceAll("\\W", ""))
            .anyMatch(x -> x.equals("Blackjack")),
        "The list of weapons should include a Blackjack");
  }

  @Test
  void weaponsShouldContainABlowgun() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .map(x -> x.replaceAll("\\W", ""))
            .anyMatch(x -> x.equals("Blowgun")),
        "The list of weapons should include a Blowgun");
  }

  @Test
  void weaponsShouldContainAClub() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Club")),
        "The list of weapons should include a Club");
  }

  @Test
  void weaponsShouldContainACrossbow() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Crossbow")),
        "The list of weapons should include a Crossbow");
  }

  @Test
  void weaponsShouldContainADagger() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .map(x -> x.replaceAll("\\W", ""))
            .anyMatch(x -> x.equals("Dagger")),
        "The list of weapons should include a Dagger");
  }


  @Test
  void weaponsShouldContainADart() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Dart")),
        "The list of weapons should include a Dart");
  }

  @Test
  void weaponsShouldContainAFlail() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Flail")),
        "The list of weapons should include a Flail");
  }

  @Test
  void weaponsShouldContainAGarrote() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .map(x -> x.replaceAll("\\W", ""))
            .anyMatch(x -> x.equals("Garrote")),
        "The list of weapons should include a Garrote");
  }

  @Test
  void weaponsShouldContainAHandaxe() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Handaxe")),
        "The list of weapons should include a Handaxe");
  }

  @Test
  void weaponsShouldContainAJavelin() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Javelin")),
        "The list of weapons should include a Javelin");
  }

  @Test
  void weaponsShouldContainALongbow() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Longbow")),
        "The list of weapons should include a Longbow");
  }

  @Test
  void weaponsShouldContainALance() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .map(x -> x.replaceAll("\\W", ""))
            .anyMatch(x -> x.equals("Lance")),
        "The list of weapons should include a Lance");
  }

  @Test
  void weaponsShouldContainALongsword() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Longsword")),
        "The list of weapons should include a Longsword");
  }

  @Test
  void weaponsShouldContainAMace() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Mace")),
        "The list of weapons should include a Mace");
  }

  @Test
  void weaponsShouldContainAPolearm() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Polearm")),
        "The list of weapons should include a Polearm");
  }

  @Test
  void weaponsShouldContainAShortbow() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Shortbow")),
        "The list of weapons should include a Shortbow");
  }

  @Test
  void weaponsShouldContainAShortSword() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Short Sword")),
        "The list of weapons should include a Short Sword");
  }

  @Test
  void weaponsShouldContainASling() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Sling")),
        "The list of weapons should include a Sling");
  }

  @Test
  void weaponsShouldContainASpear() {
    assertTrue(weapons.stream()
            .map(Weapon::getName)
            .map(x -> x.replaceAll("\\W", ""))
            .anyMatch(x -> x.equals("Spear")),
        "The list of weapons should include a Spear");
  }

  @Test
  void weaponsShouldContainAStaff() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Staff")),
        "The list of weapons should include a Staff");
  }

  @Test
  void weaponsShouldContainATwoHandedSword() {
    assertTrue(
        weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Two-handed Sword")),
        "The list of weapons should include a Two-handed Sword");
  }

  @Test
  void weaponsShouldContainAWarhammer() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.equals("Warhammer")),
        "The list of weapons should include a Warhammer");
  }

  @Disabled
  @Test
  void writeToJson() {
    weaponSerializer.writeToJson();
  }

}