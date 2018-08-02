package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.io.ArmorSerializer;
import com.frijolie.dcc.model.inventory.Armor;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquippedArmorTest {

  private EquippedArmor equippedArmor;
  private static List<Armor> armorList;
  private static ArmorSerializer armorSerializer;

  @BeforeAll
  static void setUpAll() {
    armorSerializer = new ArmorSerializer();
    armorList = new ArrayList<>(armorSerializer.getArmorList());
  }

  @BeforeEach
  void setUp() {
    equippedArmor = new EquippedArmor();
  }

  @AfterEach
  void tearDown() {
    equippedArmor.getArmorList().clear();
    equippedArmor = null;
  }

  @AfterAll
  static void tearDownAll() {
    armorSerializer = null;
  }

  private Armor getArmorByName(String name) {
    return armorList.stream().filter(a -> a.getName().equals(name)).findFirst().get();
  }

  @Test
  void addArmor_addingSameArmorShouldThrowIllegalArgumentException() {
    equippedArmor.addArmor(getArmorByName("Unarmored"));
    assertThrows(IllegalArgumentException.class, () -> {
      // can't add the armor again
      equippedArmor.addArmor(getArmorByName("Unarmored"));
    });
  }

  @Test
  void addArmor_addingSameShieldShouldThrowIllegalArgumentException() {
    equippedArmor.addArmor(getArmorByName("Shield"));
    assertThrows(IllegalArgumentException.class, () -> {
      // can't add the armor again
      equippedArmor.addArmor(getArmorByName("Shield"));
    });
  }

  @Test
  void addArmor_addingSameTypeArmorToExistingArmorShouldReplaceOld() {
    equippedArmor.addArmor(getArmorByName("Unarmored"));
    assertAll("Equipped ArmorList should have 1 element and it is Unarmored",
        () -> assertEquals(1, equippedArmor.getArmorList().size()),
        () -> assertTrue(equippedArmor.getArmorList()
            .stream().anyMatch(a -> a.getName().equals("Unarmored")))
    );
    equippedArmor.addArmor(getArmorByName("Hide"));
    assertAll("After adding Hide, Unarmored should be replaced",
        () -> assertEquals(1, equippedArmor.getArmorList().size()),
        () -> assertTrue(equippedArmor.getArmorList()
            .stream().anyMatch(a -> a.getName().equals("Hide")))
    );
  }

  @Test
  void addArmor_addingShieldToExistingSuitOfArmorShouldBeAllowed() {
    equippedArmor.addArmor(getArmorByName("Hide"));
    assertAll("After adding Hide, armorList should have 1 element and it is Hide",
        () -> assertEquals(1, equippedArmor.getArmorList().size()),
        () -> assertTrue(equippedArmor.getArmorList()
            .stream().anyMatch(a -> a.getName().equals("Hide")))
    );
    equippedArmor.addArmor(getArmorByName("Shield"));
    assertAll("After adding shield, armorList should have 2 elements: Hide & Shield",
        () -> assertEquals(2, equippedArmor.getArmorList().size()),
        () -> assertTrue(equippedArmor.getArmorList()
            .stream().anyMatch(a -> a.getName().equals("Hide"))),
        () -> assertTrue(equippedArmor.getArmorList()
            .stream().anyMatch(a -> a.getName().equals("Shield")))
    );
  }
}