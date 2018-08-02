package com.frijolie.dcc.model.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.io.WeaponSerializer;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private List<Weapon> weapons;
  private WeaponSerializer weaponSerializer;

  WeaponTest() {
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
            .anyMatch(x -> x.equals("Oil, 1 flask")),
        "The list of weapons should include a Blackjack");
  }

  @Test
  void weaponsShouldContainABlowgun() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Blowgun")),
        "The list of weapons should include a Blowgun");
  }

  @Test
  void weaponsShouldContainAClub() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Club")),
        "The list of weapons should include a Club");
  }

  @Test
  void weaponsShouldContainACrossbow() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Crossbow")),
        "The list of weapons should include a Crossbow");
  }

  @Test
  void weaponsShouldContainADagger() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Dagger")),
        "The list of weapons should include a Dagger");
  }


  @Test
  void weaponsShouldContainADart() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Dart")),
        "The list of weapons should include a Dart");
  }

  @Test
  void weaponsShouldContainAFlail() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Flail")),
        "The list of weapons should include a Flail");
  }

  @Test
  void weaponsShouldContainAGarrote() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Garrote")),
        "The list of weapons should include a Garrote");
  }

  @Test
  void weaponsShouldContainAHandaxe() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Handaxe")),
        "The list of weapons should include a Handaxe");
  }

  @Test
  void weaponsShouldContainAJavelin() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Javelin")),
        "The list of weapons should include a Javelin");
  }

  @Test
  void weaponsShouldContainALongbow() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Longbow")),
        "The list of weapons should include a Longbow");
  }

  @Test
  void weaponsShouldContainALance() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Lance")),
        "The list of weapons should include a Lance");
  }

  @Test
  void weaponsShouldContainALongsword() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Longsword")),
        "The list of weapons should include a Longsword");
  }

  @Test
  void weaponsShouldContainAMace() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Mace")),
        "The list of weapons should include a Mace");
  }

  @Test
  void weaponsShouldContainAPolearm() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Polearm")),
        "The list of weapons should include a Polearm");
  }

  @Test
  void weaponsShouldContainAShortbow() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Shortbow")),
        "The list of weapons should include a Shortbow");
  }

  @Test
  void weaponsShouldContainAShortSword() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Short Sword")),
        "The list of weapons should include a Short Sword");
  }

  @Test
  void weaponsShouldContainASling() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Sling")),
        "The list of weapons should include a Sling");
  }

  @Test
  void weaponsShouldContainASpear() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Spear")),
        "The list of weapons should include a Spear");
  }

  @Test
  void weaponsShouldContainAStaff() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Staff")),
        "The list of weapons should include a Staff");
  }

  @Test
  void weaponsShouldContainATwoHandedSword() {
    assertTrue(
        weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Two-handed Sword")),
        "The list of weapons should include a Two-handed Sword");
  }

  @Test
  void weaponsShouldContainAWarhammer() {
    assertTrue(weapons.stream().map(Weapon::getName).anyMatch(x -> x.contains("Warhammer")),
        "The list of weapons should include a Warhammer");
  }

}