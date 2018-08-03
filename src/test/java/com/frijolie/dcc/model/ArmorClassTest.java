package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.frijolie.dcc.model.inventory.Armor;
import com.frijolie.dcc.model.inventory.ArmorFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArmorClassTest {

  private Armor armor;
  private List<Armor> armorList;
  private ArmorClass armorClass;

  @BeforeEach
  void setUp() {
    armorClass = new ArmorClass();
    armorList = new ArrayList<>();
  }

  @AfterEach
  void tearDown() {
    armor = null;
    armorList.clear();
    armorClass = null;
  }

  // Armor Class = 10 + Sum of Armor Bonuses + Agility Modifier

  @Test
  void calculateArmorClass_UnarmoredAndPlusOneAgilityModifierShouldEqualEleven() {
    armorList.add(ArmorFactory.getByName("Unarmored"));
    armorClass.calculateArmorClass(1, armorList);
    assertAll(
        () -> assertNotNull(armorList, "armorList should not be null"),
        () -> assertEquals(1, armorList.size(), "armorList should have 1 element"),
        () -> assertEquals(11, armorClass.getValue(),
            "10 + Unarmored (+0) + AgilityMod (+1) should = 11. Instead it is: "
                + armorClass.getValue())
    );

  }

  @Test
  void calculateArmorClass_StuddedLeatherMinusTwoAgilityModifierShouldEqualEleven() {
    armorList.add(ArmorFactory.getByName("Studded"));
    armorClass.calculateArmorClass(-2, armorList);
    assertAll(
        () -> assertNotNull(armorList, "armorList should not be null"),
        () -> assertEquals(1, armorList.size(), "armorList should have 1 element"),
        () -> assertEquals(11, armorClass.getValue(),
            "10 + Studded (+3) + AgilityMod (-2) should = 11. Instead it is: "
                + armorClass.getValue())
    );
  }
}