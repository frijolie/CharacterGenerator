package com.frijolie.dcc.io;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.model.inventory.MeleeRangedWeapon;
import com.frijolie.dcc.model.inventory.MeleeWeapon;
import com.frijolie.dcc.model.inventory.RangedWeapon;
import com.frijolie.dcc.model.inventory.Weapon;
import com.frijolie.dcc.model.inventory.Weapon.Type;
import com.frijolie.dcc.model.inventory.Weapon.Wield;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class WeaponDeserializerTest {

  private static List<Weapon> weaponList;

  private WeaponDeserializerTest() {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Weapon.class, new WeaponDeserializer());
    JsonReader reader = new JsonReader(new InputStreamReader(
        getClass().getResourceAsStream("/json/weapons.json"), StandardCharsets.UTF_8));
    Gson gson = builder.create();
    Weapon[] weapons = gson.fromJson(reader, Weapon[].class);
    weaponList = new ArrayList<>();
    weaponList.addAll(Arrays.asList(weapons));
  }

  @AfterAll
  static void tearDown() {
    weaponList.clear();
    weaponList = null;
  }

  @Test
  void parseWeapons_weaponListShouldContain23Weapons() {
    assertAll("After parsing, weaponList should contain 23 weapons and not be null",
        () -> assertNotNull(weaponList, "weaponList should not be null"),
        () -> assertEquals(23, weaponList.size(),
            "weaponList should contain 23 weapons")
    );
  }

  @Test
  void weaponListShouldContainA_Battleaxe() {
    MeleeWeapon battleaxe = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Battleaxe")).findFirst().orElse(null);
    assertAll("weaponList should contain a battleaxe with all the proper stats",
        () -> assertNotNull(battleaxe, "battleaxe should not be null"),
        () -> assertEquals(Type.MELEE, battleaxe.getWeaponType(),
            "A battleaxe should be of itemType MELEE, instead it is: " + battleaxe.getWeaponType()),
        () -> assertEquals(Wield.TWO_HANDED, battleaxe.getWield(),
            "A battleaxe should be two-handed, instead it is: " + battleaxe.getWield()),
        () -> assertTrue(battleaxe.getName().contains("Battleaxe"),
            "a battleaxe should have the name of 'Battleaxe', instead it is: "
                + battleaxe.getName()),
        () -> assertEquals("1d10", battleaxe.getMeleeDamage(),
            "A battleaxe should do '1d10' melee damage, instead it is: "
                + battleaxe.getMeleeDamage()),
        () -> assertTrue(battleaxe.getNotes().stream().anyMatch(n -> n.contains("use a d16")),
            "A battleaxe should have a note that mentions using a d16, but, it does not"),
        () -> assertEquals(700, battleaxe.getCostInCopper(),
            "A battleaxe costInCopper should be 700. Instead it is: "
                + battleaxe.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Blackjack() {
    MeleeWeapon blackjack = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Blackjack")).findFirst().orElse(null);
    assertAll("weaponList should contain a blackjack with all the proper stats",
        () -> assertNotNull(blackjack, "blackjack should not be null"),
        () -> assertEquals(Type.MELEE, blackjack.getWeaponType(),
            "A blackjack should be of itemType MELEE. Instead it is " + blackjack.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, blackjack.getWield(),
            "A blackjack should be one-handed, instead it is: " + blackjack.getWield()),
        () -> assertTrue(blackjack.getName().contains("Blackjack"),
            "a blackjack should have the name of 'blackjack', instead it is: "
                + blackjack.getName()),
        () -> assertEquals("1d3/2d6***", blackjack.getMeleeDamage(),
            "A blackjack should do '1d3/2d6' melee damage, instead it is: "
                + blackjack.getMeleeDamage()),
        () -> assertEquals(2, blackjack.getNotes().size(),
            "A blackjack should have two notes, instead it has: "
                + blackjack.getNotes().size()),
        () -> assertTrue(
            blackjack.getNotes().stream().anyMatch(n -> n.contains("when backstabbing")),
            "A blackjack should have a note that mentions when backstabbing, but, it does not"),
        () -> assertTrue(
            blackjack.getNotes().stream().anyMatch(y -> y.contains("subdual damage")),
            "a blackjack should have a note that contains 'subdual damage' but it does not"),
        () -> assertEquals(300, blackjack.getCostInCopper(),
            "A blackjack costInCopper should be 300. Instead it is: "
                + blackjack.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Blowgun() {
    RangedWeapon blowgun = (RangedWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Blowgun")).findFirst().orElse(null);
    assertAll("weaponList should contain a blowgun with all the proper stats",
        () -> assertNotNull(blowgun, "blowgun should not be null"),
        () -> assertEquals(Type.RANGED, blowgun.getWeaponType(),
            "A blowgun should be of itemType RANGED, instead it is: "
                + blowgun.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, blowgun.getWield(),
            "A blowgun should be one-handed, instead it is: " + blowgun.getWield()),
        () -> assertTrue(blowgun.getName().contains("Blowgun"),
            "a blowgun should have the name of 'Blowgun', instead it is: "
                + blowgun.getName()),
        () -> assertEquals("1d3/1d5", blowgun.getRangedDamage(),
            "A blowgun should do '1d5' ranged damage roll. Instead it is: "
                + blowgun.getRangedDamage()),
        () -> assertEquals(0, blowgun.getNotes().size(),
            "A blowgun should not have any notes. Instead it has: "
                + blowgun.getNotes().size() + " notes"),
        () -> assertEquals("20/40/60", blowgun.getRange(),
            "A blowgun range should be '20/40/60'. Instead it is: " + blowgun.getRange()),
        () -> assertEquals(600, blowgun.getCostInCopper(),
            "A blowgun costInCopper should be 600. Instead it is: "
                + blowgun.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Club() {
    MeleeWeapon club = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Club")).findFirst().orElse(null);
    assertAll("weaponList should contain a club with all the proper stats",
        () -> assertNotNull(club, "club should not be null"),
        () -> assertEquals(Type.MELEE, club.getWeaponType(),
            "A club should be of itemType MELEE, instead it is " + club.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, club.getWield(),
            "A club should be one-handed, instead it is: " + club.getWield()),
        () -> assertTrue(club.getName().equals("Club"),
            "a club should have the name of 'Club', instead it is: "
                + club.getName()),
        () -> assertEquals("1d4", club.getMeleeDamage(),
            "A club should do '1d4' melee damage, instead it is: "
                + club.getMeleeDamage()),
        () -> assertEquals(0, club.getNotes().size(),
            "A club should not have any notes. Instead it has: " + club.getNotes().size()),
        () -> assertEquals(300, club.getCostInCopper(),
            "A club costInCopper should be 300. Instead it is: "
                + club.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Crossbow() {
    RangedWeapon crossbow = (RangedWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Crossbow")).findFirst().orElse(null);
    assertAll("weaponList should contain a crossbow with all the proper stats",
        () -> assertNotNull(crossbow, "crossbow should not be null"),
        () -> assertEquals(Type.RANGED, crossbow.getWeaponType(),
            "A crossbow should be of itemType RANGED, instead it is: " + crossbow.getWeaponType()),
        () -> assertEquals(Wield.TWO_HANDED, crossbow.getWield(),
            "A crossbow should be two-handed, instead it is: " + crossbow.getWield()),
        () -> assertTrue(crossbow.getName().contains("Crossbow"),
            "a crossbow should have the name of 'Crossbow', instead it is: "
                + crossbow.getName()),
        () -> assertEquals("1d6", crossbow.getRangedDamage(),
            "A crossbow should do '1d6' ranged damage. Instead it is: "
                + crossbow.getRangedDamage()),
        () -> assertTrue(crossbow.getNotes().stream().anyMatch(n -> n.contains("use a d16")),
            "A crossbow should have a note that mentions using a d16, but, it does not"),
        () -> assertEquals("80/160/240", crossbow.getRange(),
            "A crossbow has a range of '80/160/240'. Instead it is: "
                + crossbow.getRange()),
        () -> assertEquals(3000, crossbow.getCostInCopper(),
            "A crossbow costInCopper should be 3000. Instead it is: "
                + crossbow.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Dagger() {
    MeleeRangedWeapon dagger = (MeleeRangedWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Dagger")).findFirst().orElse(null);
    assertAll("weaponList should contain a dagger with all the proper stats",
        () -> assertNotNull(dagger, "dagger should not be null"),
        () -> assertEquals(Type.BOTH, dagger.getWeaponType(),
            "A dagger should be of itemType BOTH, instead it is: " + dagger.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, dagger.getWield(),
            "A dagger should be one-handed, instead it is: " + dagger.getWield()),
        () -> assertTrue(dagger.getName().contains("Dagger"),
            "A dagger should have the name of 'Dagger', instead it is: "
                + dagger.getName()),
        () -> assertEquals("1d4", dagger.getMeleeDamage(),
            "A dagger should do '1d4' melee damage, instead it is: "
                + dagger.getMeleeDamage()),
        () -> assertEquals(3, dagger.getNotes().size(),
            "A dagger should have 3 notes. Instead it has: " + dagger.getNotes().size()),
        () -> assertTrue(dagger.getNotes().stream().anyMatch(n -> n.contains("when backstabbing")),
            "A dagger should have a note that mentions 'when backstabbing', but does not"),
        () -> assertTrue(dagger.getNotes().stream().anyMatch(n -> n.contains("Athame")),
            "A dagger should have a note that mentions 'Athame' but does not"),
        () -> assertTrue(dagger.getNotes().stream().anyMatch(n -> n.contains("close range only")),
            "A dagger should hvae a note that mentions 'close range only', but does not"),
        () -> assertEquals(300, dagger.getCostInCopper(),
            "A dagger costInCopper should be 300. Instead it is: "
                + dagger.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Dart() {
    RangedWeapon dart = (RangedWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Dart")).findFirst().orElse(null);
    assertAll("weaponList should contain a dart with all the proper stats",
        () -> assertNotNull(dart, "dart should not be null"),
        () -> assertEquals(Type.RANGED, dart.getWeaponType(),
            "A dart should be of itemType RANGED, instead it is: " + dart.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, dart.getWield(),
            "A dart should be one-handed, instead it is: " + dart.getWield()),
        () -> assertTrue(dart.getName().equals("Dart"),
            "a dart should have the name of 'dart', instead it is: " + dart.getName()),
        () -> assertEquals("1d4", dart.getRangedDamage(),
            "A dart should do '1d4' damage. Instead it is: " + dart.getRangedDamage()),
        () -> assertTrue(dart.getNotes().stream().anyMatch(n -> n.contains("close range only")),
            "A dart should have a note that mentions 'close range only', but, it does not"),
        () -> assertEquals("20/40/60**", dart.getRange(),
            "A dart has a range of '20/40/60. Instead it is: " + dart.getRange()),
        () -> assertEquals(50, dart.getCostInCopper(),
            "A dart costInCopper should be 3000. Instead it is: " + dart.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Flail() {
    MeleeWeapon flail = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Flail")).findFirst().orElse(null);
    assertAll("weaponList should contain a flail with all the proper stats",
        () -> assertNotNull(flail, "flail should not be null"),
        () -> assertEquals(Type.MELEE, flail.getWeaponType(),
            "A flail should be of itemType MELEE, instead it is " + flail.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, flail.getWield(),
            "A flail should be one-handed, instead it is: " + flail.getWield()),
        () -> assertTrue(flail.getName().equals("Flail"),
            "a flail should have the name of 'Flail', instead it is: "
                + flail.getName()),
        () -> assertEquals("1d6", flail.getMeleeDamage(),
            "A flail should do '1d6' melee damage, instead it is: "
                + flail.getMeleeDamage()),
        () -> assertEquals(0, flail.getNotes().size(),
            "A flail should not have any notes. Instead it has: "
                + flail.getNotes().size()),
        () -> assertEquals(600, flail.getCostInCopper(),
            "A flail costInCopper should be 600. Instead it is: "
                + flail.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Garrote() {
    MeleeWeapon garrote = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Garrote")).findFirst().orElse(null);
    assertAll("weaponList should contain a garrote with all the proper stats",
        () -> assertNotNull(garrote, "garrote should not be null"),
        () -> assertEquals(Type.MELEE, garrote.getWeaponType(),
            "A garrote should be of itemType MELEE, instead it is " + garrote.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, garrote.getWield(),
            "A garrote should be one-handed, instead it is: " + garrote.getWield()),
        () -> assertTrue(garrote.getName().contains("Garrote"),
            "a garrote should have the name of 'Garrote', instead it is: "
                + garrote.getName()),
        () -> assertEquals("1/3d4", garrote.getMeleeDamage(),
            "A garrote should do '1/3d4' melee damage, instead it is: "
                + garrote.getMeleeDamage()),
        () -> assertEquals(1, garrote.getNotes().size(),
            "A garrote should have 1 note. Instead it has: " + garrote.getNotes().size()),
        () -> assertTrue(garrote.getNotes().stream().anyMatch(n -> n.contains("when backstabbing")),
            "A garrote should have a note mentioning 'when backstabbing', but it does not"),
        () -> assertEquals(200, garrote.getCostInCopper(),
            "A garrote costInCopper should be 200. Instead it is: "
                + garrote.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Handaxe() {
    MeleeRangedWeapon handaxe = (MeleeRangedWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Handaxe")).findFirst().orElse(null);
    assertAll("weaponList should contain a handaxe with all the proper stats",
        () -> assertNotNull(handaxe, "handaxe should not be null"),
        () -> assertEquals(Type.BOTH, handaxe.getWeaponType(),
            "A handaxe should be of itemType BOTH, instead it is " + handaxe.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, handaxe.getWield(),
            "A handaxe should be one-handed, instead it is: " + handaxe.getWield()),
        () -> assertTrue(handaxe.getName().equals("Handaxe"),
            "a handaxe should have the name of 'Handaxe', instead it is: "
                + handaxe.getName()),
        () -> assertEquals("1d6", handaxe.getMeleeDamage(),
            "A handaxe should do '1d6' melee damage, instead it is: "
                + handaxe.getMeleeDamage()),
        () -> assertEquals("1d6", handaxe.getRangedDamage(),
            "A handaxe should do '1d6' ranged damage, instead it is: "
                + handaxe.getRangedDamage()),
        () -> assertEquals("10/20/30**", handaxe.getRange(),
            "A handaxe should have a range of '10/20/30', instead it is: "
                + handaxe.getRange()),
        () -> assertEquals(1, handaxe.getNotes().size(),
            "A handaxe should have 1 note. Instead it has: " + handaxe.getNotes().size()),
        () -> assertTrue(handaxe.getNotes().stream().anyMatch(n -> n.contains("Strength mod")),
            "A handaxe should have a note that mentions 'Strength mod' but it does not."),
        () -> assertEquals(400, handaxe.getCostInCopper(),
            "A handaxe costInCopper should be 400. Instead it is: "
                + handaxe.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Javelin() {
    MeleeRangedWeapon javelin = (MeleeRangedWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Javelin")).findFirst().orElse(null);
    assertAll("weaponList should contain a javelin with all the proper stats",
        () -> assertNotNull(javelin, "javelin should not be null"),
        () -> assertEquals(Type.BOTH, javelin.getWeaponType(),
            "A javelin should be of itemType BOTH, instead it is " + javelin.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, javelin.getWield(),
            "A javelin should be one-handed, instead it is: " + javelin.getWield()),
        () -> assertTrue(javelin.getName().equals("Javelin"),
            "a javelin should have the name of 'Javelin', instead it is: "
                + javelin.getName()),
        () -> assertEquals("1d6", javelin.getMeleeDamage(),
            "A javelin should do '1d6' melee damage, instead it is: "
                + javelin.getMeleeDamage()),
        () -> assertEquals("1d6", javelin.getRangedDamage(),
            "A javelin should do '1d6' ranged damage, instead it is: "
                + javelin.getRangedDamage()),
        () -> assertEquals(1, javelin.getNotes().size(),
            "A javelin should not have 1 note. Instead it has: "
                + javelin.getNotes().size()),
        () -> assertTrue(javelin.getNotes().stream().anyMatch(n -> n.contains("Strength mod")),
            "a javelin should have a note that mentions 'Strength mod' but it does not"),
        () -> assertEquals(100, javelin.getCostInCopper(),
            "A javelin costInCopper should be 100. Instead it is: "
                + javelin.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Longbow() {
    RangedWeapon longbow = (RangedWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Longbow")).findFirst().orElse(null);
    assertAll("weaponList should contain a longbow with all the proper stats",
        () -> assertNotNull(longbow, "longbow should not be null"),
        () -> assertEquals(Type.RANGED, longbow.getWeaponType(),
            "A longbow should be of itemType RANGED, instead it is " + longbow.getWeaponType()),
        () -> assertEquals(Wield.TWO_HANDED, longbow.getWield(),
            "A longbow should be two-handed, instead it is: " + longbow.getWield()),
        () -> assertTrue(longbow.getName().contains("Longbow"),
            "a longbow should have the name of 'Longbow', instead it is: "
                + longbow.getName()),
        () -> assertEquals("1d6", longbow.getRangedDamage(),
            "A longbow should do '1d6' melee damage, instead it is: "
                + longbow.getRangedDamage()),
        () -> assertEquals("70/140/210", longbow.getRange(),
            "A longbow should have a range of '70/140/210', instead it is: "
                + longbow.getRange()),
        () -> assertEquals(1, longbow.getNotes().size(),
            "A longbow should have 1 note, instead it has: " + longbow.getNotes().size()),
        () -> assertTrue(longbow.getNotes().stream().anyMatch(n -> n.contains("use a d16")),
            "A longbow should have a note that mentions 'use a d16' but it does not"),
        () -> assertEquals(4000, longbow.getCostInCopper(),
            "A longbow costInCopper should be 4000. Instead it is: "
                + longbow.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Lance() {
    MeleeWeapon lance = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Lance")).findFirst().orElse(null);
    assertAll("weaponList should contain a lance with all the proper stats",
        () -> assertNotNull(lance, "Lance should not be null"),
        () -> assertEquals(Type.MELEE, lance.getWeaponType(),
            "A lance should be of itemType MELEE, instead it is " + lance.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, lance.getWield(),
            "A lance should be one-handed, instead it is: " + lance.getWield()),
        () -> assertTrue(lance.getName().contains("Lance"),
            "a lance should have the name of 'Lance', instead it is: "
                + lance.getName()),
        () -> assertEquals("1d12", lance.getMeleeDamage(),
            "A lance should do '1d12' melee damage, instead it is: "
                + lance.getMeleeDamage()),
        () -> assertEquals(1, lance.getNotes().size(),
            "A lance should have 1 note. Instead it has: " + lance.getNotes().size()),
        () -> assertTrue(lance.getNotes().stream().anyMatch(n -> n.contains("2x damage")),
            "A lance should have a note that mentions '2x damage', instead it does not."),
        () -> assertEquals(2500, lance.getCostInCopper(),
            "A lance costInCopper should be 2500. Instead it is: "
                + lance.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Longsword() {
    MeleeWeapon longsword = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Longsword")).findFirst().orElse(null);
    assertAll("weaponList should contain a longsword with all the proper stats",
        () -> assertNotNull(longsword, "longsword should not be null"),
        () -> assertEquals(Type.MELEE, longsword.getWeaponType(),
            "A longsword should be of itemType MELEE, instead it is " + longsword.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, longsword.getWield(),
            "A longsword should be one-handed, instead it is: " + longsword.getWield()),
        () -> assertTrue(longsword.getName().equals("Longsword"),
            "a longsword should have the name of 'Longsword', instead it is: "
                + longsword.getName()),
        () -> assertEquals("1d8", longsword.getMeleeDamage(),
            "A longsword should do '1d8' melee damage, instead it is: "
                + longsword.getMeleeDamage()),
        () -> assertEquals(0, longsword.getNotes().size(),
            "A longsword should not have any notes. Instead it has: " + longsword.getNotes()
                .size()),
        () -> assertEquals(1000, longsword.getCostInCopper(),
            "A longsword costInCopper should be 1,000. Instead it is: "
                + longsword.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Mace() {
    MeleeWeapon mace = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Mace")).findFirst().orElse(null);
    assertAll("weaponList should contain a mace with all the proper stats",
        () -> assertNotNull(mace, "mace should not be null"),
        () -> assertEquals(Type.MELEE, mace.getWeaponType(),
            "A mace should be of itemType MELEE, instead it is " + mace.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, mace.getWield(),
            "A mace should be one-handed, instead it is: " + mace.getWield()),
        () -> assertTrue(mace.getName().equals("Mace"),
            "a mace should have the name of 'Mace', instead it is: "
                + mace.getName()),
        () -> assertEquals("1d6", mace.getMeleeDamage(),
            "A mace should do '1d6' melee damage, instead it is: "
                + mace.getMeleeDamage()),
        () -> assertEquals(0, mace.getNotes().size(),
            "A mace should not have any notes. Instead it has: " + mace.getNotes().size()),
        () -> assertEquals(500, mace.getCostInCopper(),
            "A mace costInCopper should be 500. Instead it is: "
                + mace.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Polearm() {
    MeleeWeapon polearm = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Polearm")).findFirst().orElse(null);
    assertAll("weaponList should contain a polearm with all the proper stats",
        () -> assertNotNull(polearm, "polearm should not be null"),
        () -> assertEquals(Type.MELEE, polearm.getWeaponType(),
            "A polearm should be of itemType MELEE, instead it is " + polearm.getWeaponType()),
        () -> assertEquals(Wield.TWO_HANDED, polearm.getWield(),
            "A polearm should be two-handed, instead it is: " + polearm.getWield()),
        () -> assertTrue(polearm.getName().contains("Polearm"),
            "a polearm should have the name of 'Polearm', instead it is: "
                + polearm.getName()),
        () -> assertEquals("1d10", polearm.getMeleeDamage(),
            "A polearm should do '1d10' melee damage, instead it is: "
                + polearm.getMeleeDamage()),
        () -> assertEquals(1, polearm.getNotes().size(),
            "A polearm should have 1 note. Instead it has: " + polearm.getNotes().size()),
        () -> assertTrue(polearm.getNotes().stream().anyMatch(note -> note.contains("use a d16")),
            "Polearm should have a note that mentions 'use a d16', instead it does not"),
        () -> assertEquals(700, polearm.getCostInCopper(),
            "A polearm costInCopper should be 700. Instead it is: "
                + polearm.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Shortbow() {
    RangedWeapon shortbow = (RangedWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Shortbow")).findFirst().orElse(null);
    assertAll("weaponList should contain a shortbow with all the proper stats",
        () -> assertNotNull(shortbow, "shortbow should not be null"),
        () -> assertEquals(Type.RANGED, shortbow.getWeaponType(),
            "A shortbow should be of itemType RANGED, instead it is " + shortbow.getWeaponType()),
        () -> assertEquals(Wield.TWO_HANDED, shortbow.getWield(),
            "A shortbow should be two-handed, instead it is: " + shortbow.getWield()),
        () -> assertTrue(shortbow.getName().contains("Shortbow"),
            "a shortbow should have the name of 'Shortbow', instead it is: "
                + shortbow.getName()),
        () -> assertEquals("1d6", shortbow.getRangedDamage(),
            "A shortbow should do '1d6' melee damage, instead it is: "
                + shortbow.getRangedDamage()),
        () -> assertEquals("50/100/150", shortbow.getRange(),
            "A shortbow should have a range of '50/100/150', instead it is: "
                + shortbow.getRange()),
        () -> assertEquals(1, shortbow.getNotes().size(),
            "A shortbow should have 1 note. Instead it has: "
                + shortbow.getNotes().size()),
        () -> assertTrue(shortbow.getNotes().stream().anyMatch(note -> note.contains("use a d16")),
            "A shortbow should have a note that mentions 'use a d16' but it does not"),
        () -> assertEquals(2500, shortbow.getCostInCopper(),
            "A shortbow costInCopper should be 2,500. Instead it is: "
                + shortbow.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_ShortSword() {
    MeleeWeapon shortsword = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Short sword")).findFirst().orElse(null);
    assertAll("weaponList should contain a short sword with all the proper stats",
        () -> assertNotNull(shortsword, "shortsword should not be null"),
        () -> assertEquals(Type.MELEE, shortsword.getWeaponType(),
            "A short sword should be of itemType MELEE, instead it is " + shortsword
                .getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, shortsword.getWield(),
            "A short sword should be one-handed, instead it is: " + shortsword.getWield()),
        () -> assertTrue(shortsword.getName().equals("Short sword"),
            "a shortsword should have the name of 'Short sword', instead it is: "
                + shortsword.getName()),
        () -> assertEquals("1d6", shortsword.getMeleeDamage(),
            "A shortsword should do '1d6' melee damage, instead it is: "
                + shortsword.getMeleeDamage()),
        () -> assertEquals(0, shortsword.getNotes().size(),
            "A short sword should not have any notes. Instead it has: "
                + shortsword.getNotes().size()),
        () -> assertEquals(700, shortsword.getCostInCopper(),
            "A shortsword costInCopper should be 700. Instead it is: "
                + shortsword.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Sling() {
    RangedWeapon sling = (RangedWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Sling")).findFirst().orElse(null);
    assertAll("weaponList should contain a sling with all the proper stats",
        () -> assertNotNull(sling, "sling should not be null"),
        () -> assertEquals(Type.RANGED, sling.getWeaponType(),
            "A sling should be of itemType RANGED, instead it is " + sling.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, sling.getWield(),
            "A sling should be one-handed, instead it is: " + sling.getWield()),
        () -> assertTrue(sling.getName().equals("Sling"),
            "a sling should have the name of 'Sling', instead it is: "
                + sling.getName()),
        () -> assertEquals("1d4", sling.getRangedDamage(),
            "A sling should do '1d4' melee damage, instead it is: "
                + sling.getRangedDamage()),
        () -> assertEquals("40/80/160**", sling.getRange(),
            "A sling should have a range of '40/80/160', instead it is: "
                + sling.getRange()),
        () -> assertEquals(1, sling.getNotes().size(),
            "A sling should have 1 note. Instead it has: "
                + sling.getNotes().size()),
        () -> assertTrue(sling.getNotes().stream().anyMatch(note -> note.contains("Strength mod")),
            "A sling should have a note that mentions 'Strength mod' but it does not"),
        () -> assertEquals(200, sling.getCostInCopper(),
            "A sling costInCopper should be 200. Instead it is: "
                + sling.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Spear() {
    MeleeWeapon spear = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Spear")).findFirst().orElse(null);
    assertAll("weaponList should contain a spear with all the proper stats",
        () -> assertNotNull(spear, "spear should not be null"),
        () -> assertEquals(Type.MELEE, spear.getWeaponType(),
            "A spear should be of itemType MELEE, instead it is " + spear.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, spear.getWield(),
            "A spear should be one-handed, instead it is: " + spear.getWield()),
        () -> assertTrue(spear.getName().contains("Spear"),
            "a spear should have the name of 'Spear', instead it is: "
                + spear.getName()),
        () -> assertEquals("1d8", spear.getMeleeDamage(),
            "A spear should do '1d8' melee damage, instead it is: "
                + spear.getMeleeDamage()),
        () -> assertEquals(1, spear.getNotes().size(),
            "A spear should have 1 note. Instead it has: " + spear.getNotes().size()),
        () -> assertTrue(spear.getNotes().stream().anyMatch(n -> n.contains("2x damage")),
            "A spear should have a note that mentions '2x damage', instead it does not."),
        () -> assertEquals(300, spear.getCostInCopper(),
            "A spear costInCopper should be 300. Instead it is: "
                + spear.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Staff() {
    MeleeWeapon staff = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Staff")).findFirst().orElse(null);
    assertAll("weaponList should contain a staff with all the proper stats",
        () -> assertNotNull(staff, "staff should not be null"),
        () -> assertEquals(Type.MELEE, staff.getWeaponType(),
            "A staff should be of itemType MELEE, instead it is " + staff.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, staff.getWield(),
            "A staff should be one-handed, instead it is: " + staff.getWield()),
        () -> assertTrue(staff.getName().equals("Staff"),
            "a staff should have the name of 'Staff', instead it is: " + staff.getName()),
        () -> assertEquals("1d4", staff.getMeleeDamage(),
            "A staff should do '1d4' melee damage, instead it is: "
                + staff.getMeleeDamage()),
        () -> assertEquals(0, staff.getNotes().size(),
            "A staff should not have any notes. Instead it has: "
                + staff.getNotes().size()),
        () -> assertEquals(50, staff.getCostInCopper(),
            "A staff costInCopper should be 50. Instead it is: "
                + staff.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_TwoHandedSword() {
    MeleeWeapon twoHandedSword = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().contains("Two-handed")).findFirst().orElse(null);
    assertAll("weaponList should contain a two-handed sword with all the proper stats",
        () -> assertNotNull(twoHandedSword, "two-handed sword should not be null"),
        () -> assertEquals(Type.MELEE, twoHandedSword.getWeaponType(),
            "A twoHandedSword should be of itemType MELEE, instead it is "
                + twoHandedSword.getWeaponType()),
        () -> assertEquals(Wield.TWO_HANDED, twoHandedSword.getWield(),
            "A two-handed sword should be two-handed, instead it is: "
                + twoHandedSword.getWield()),
        () -> assertTrue(twoHandedSword.getName().contains("Two-handed"),
            "a two-handed sword should have the name of 'Two-handed sword', instead it is: "
                + twoHandedSword.getName()),
        () -> assertEquals("1d10", twoHandedSword.getMeleeDamage(),
            "A two-handed sword should do '1d10' melee damage, instead it is: "
                + twoHandedSword.getMeleeDamage()),
        () -> assertEquals(1, twoHandedSword.getNotes().size(),
            "A twoHandedSword should have 1 note. Instead it has: "
                + twoHandedSword.getNotes().size()),
        () -> assertTrue(twoHandedSword.getNotes().stream().anyMatch(n -> n.contains("use a d16")),
            "A two-handed sword should have a note that mentions 'use a d16', but it does not."),
        () -> assertEquals(1500, twoHandedSword.getCostInCopper(),
            "A twoHandedSword costInCopper should be 1500. Instead it is: "
                + twoHandedSword.getCostInCopper())
    );
  }

  @Test
  void weaponListShouldContainA_Warhammer() {
    MeleeWeapon warhammer = (MeleeWeapon) weaponList.stream()
        .filter(w -> w.getName().equals("Warhammer")).findFirst().orElse(null);
    assertAll("weaponList should contain a warhammer with all the proper stats",
        () -> assertNotNull(warhammer, "warhammer should not be null"),
        () -> assertEquals(Type.MELEE, warhammer.getWeaponType(),
            "A warhammer should be of itemType MELEE, instead it is " + warhammer.getWeaponType()),
        () -> assertEquals(Wield.ONE_HANDED, warhammer.getWield(),
            "A warhammer should be one-handed, instead it is: " + warhammer.getWield()),
        () -> assertTrue(warhammer.getName().equals("Warhammer"),
            "a warhammer should have the name of 'Warhammer', instead it is: "
                + warhammer.getName()),
        () -> assertEquals("1d8", warhammer.getMeleeDamage(),
            "A warhammer should do '1d8' melee damage, instead it is: "
                + warhammer.getMeleeDamage()),
        () -> assertEquals(0, warhammer.getNotes().size(),
            "A warhammer should not have any notes. Instead it has: "
                + warhammer.getNotes().size()),
        () -> assertEquals(500, warhammer.getCostInCopper(),
            "A warhammer costInCopper should be 500. Instead it is: "
                + warhammer.getCostInCopper())
    );
  }
}