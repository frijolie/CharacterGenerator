package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    return armorList.stream().filter(a -> a.getName().equals(name)).findFirst().orElseThrow();
  }

  @Test
  void addArmor_addingArmorShouldReplaceOld() {
    // adding first suit of armor
    equippedArmor.addArmor(getArmorByName("Unarmored"));
    assertAll("Equipped ArmorList should have 1 element and it should be Unarmored",
        () -> assertEquals(1, equippedArmor.getArmorList().size(),
            "armorList.size() should be 1. Instead it is " + armorList.size()),
        () -> assertTrue(equippedArmor.getArmorList().stream()
                .anyMatch(a -> a.getName().equals("Unarmored")),
            "armorList should contain a suit of 'Unarmored'")
    );
    // adding second suit of armor, should replace the 'Unarmored'
    equippedArmor.addArmor(getArmorByName("Hide"));
    assertAll("After adding Hide, Unarmored should be replaced",
        () -> assertEquals(1, equippedArmor.getArmorList().size(),
            "armorList.size() should be 1. Instead it is: " + armorList.size()),
        () -> assertTrue(equippedArmor.getArmorList().stream()
                .anyMatch(a -> a.getName().equals("Hide")),
            "armorList should contain a suit of Hide"),
        () -> assertTrue(equippedArmor.getArmorList().stream()
                .noneMatch(a -> a.getName().equals("Unarmored")),
            "armorList should not contain a suit of Unarmored")
    );
  }

  @Test
  void addArmor_addingShieldToExistingArmorShouldBeAllowed() {
    // adding first suit of armor
    equippedArmor.addArmor(getArmorByName("Hide"));
    assertAll("After adding Hide, armorList should have 1 element and it is Hide",
        () -> assertEquals(1, equippedArmor.getArmorList().size(),
            "armorList.size() should be 1. Instead it is : " + armorList.size()),
        () -> assertTrue(equippedArmor.getArmorList().stream()
                .anyMatch(a -> a.getName().equals("Hide")),
            "armorList should contain 'Hide' armor. Instead it does not")
    );
    // now adding a shield. It should be allowed
    equippedArmor.addArmor(getArmorByName("Shield"));
    assertAll("After adding shield, armorList should have 2 elements: Hide & Shield",
        () -> assertEquals(2, equippedArmor.getArmorList().size(),
            "armorList.size() should be 2. Instead it is: " + armorList.size()),
        () -> assertTrue(equippedArmor.getArmorList().stream()
                .anyMatch(a -> a.getName().equals("Hide")),
            "armorList should contain 'Hide' armor. Instead it does not."),
        () -> assertTrue(equippedArmor.getArmorList().stream()
                .anyMatch(a -> a.getName().equals("Shield")),
            "armorList should contain a shield. Instead it does not.")
    );
  }
}