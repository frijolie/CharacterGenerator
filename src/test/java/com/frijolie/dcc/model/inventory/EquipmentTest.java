package com.frijolie.dcc.model.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.io.EquipmentSerializer;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class EquipmentTest {

  private List<Equipment> equipmentList;
  private EquipmentSerializer equipmentSerializer;

  public EquipmentTest() {
    equipmentSerializer = new EquipmentSerializer();
    equipmentList = new ArrayList<>();
    equipmentList.addAll(equipmentSerializer.getEquipmentList());
  }

  @AfterEach
  void tearDown() {
    equipmentList.clear();
    equipmentList = null;
    equipmentSerializer = null;
  }

  @Test
  void equipmentListShoudlContain35Elements() {
    assertEquals(35, equipmentList.size(),
        "EquipmentList should contain 35 elements. Instead it contains: " + equipmentList.size());
  }

  @Test
  void equipmentListShouldContainABackpack() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Backpack")),
        "The list of equipment should contain a backpack");
  }

  @Test
  void equipmentListShouldContainACandle() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Candle")),
        "The list of equipment should contain a candle");
  }

  @Test
  void equipmentListShouldContainAChain() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Chain")),
        "The list of equipment should contain a chain");
  }

  @Test
  void equipmentListShouldContainChalk() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Chalk")),
        "The list of equipment should contain chalk");
  }

  @Test
  void equipmentListShouldContainAnEmptyChest() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Chest")),
        "The list of equipment should contain a chest");
  }

  @Test
  void equipmentListShouldContainACrowbar() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Crowbar")),
        "The list of equipment should contain a crowbar");
  }

  @Test
  void equipmentListShouldContainAnEmptyFlask() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Flask")),
        "The list of equipment should contain a flask");
  }

  @Test
  void equipmentListShouldContainFlintAndSteel() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Flint")),
        "The list of equipment should contain flint & steel");
  }

  @Test
  void equipmentListShouldContainAGrapplingHook() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Grappling")),
        "The list of equipment should contain a grappling hook");
  }

  @Test
  void equipmentListShouldContainASmallHammer() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Hammer, small")),
        "The list of equipment should contain a small hammer");
  }

  @Test
  void equipmentListShouldContainAHolySymbol() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Holy symbol")),
        "The list of equipment should contain a Holy symbol");
  }

  @Test
  void equipmentListShouldContainAnIronSpike() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Iron spike")),
        "The list of equipment should contain an Iron spike");
  }

  @Test
  void equipmentListShouldContainALantern() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Lantern")),
        "The list of equipment should contain a Lantern");
  }

  @Test
  void equipmentListShouldContainAHandSizedMirror() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Mirror")),
        "The list of equipment should contain a hand-sized mirror");
  }

  @Test
  void equipmentListShouldContainAFlaskOfOil() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Oil")),
        "The list of equipment should contain a flask of oil");
  }

  @Test
  void equipmentListShouldContainAPole() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Pole")),
        "The list of equipment should contain a 10 foot pole");
  }

  @Test
  void equipmentListShouldContainRations() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Rations")),
        "The list of equipment should contain rations");
  }

  @Test
  void equipmentListShouldContainARope() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Rope")),
        "The list of equipment should contain a rope");
  }

  @Test
  void equipmentListShouldContainALargeSack() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Sack, large")),
        "The list of equipment should contain a large sack");
  }

  @Test
  void equipmentListShouldContainASmallSack() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Sack, small")),
        "The list of equipment should contain a small sack");
  }

  @Test
  void equipmentListShouldContainTheivesTools() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Thieve")),
        "The list of equipment should contain thieves tools");
  }

  @Test
  void equipmentListShouldContainATorch() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Torch")),
        "The list of equipment should contain a torch");
  }

  @Test
  void equipmentListShouldContainAWaterskin() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Waterskin")),
        "The list of equipment should contain a waterskin");
  }

  @Test
  void equipmentListShouldContainABridleAndBit() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Bridle and Bit")),
        "The list of equipment should contain a bridle and bit");
  }

  @Test
  void equipmentListShouldContainADonkey() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Donkey")),
        "The list of equipment should contain a donkey");
  }

  @Test
  void equipmentListShouldContainAMule() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Mule")),
        "The list of equipment should contain a mule");
  }

  @Test
  void equipmentListShouldContainDailyFeed() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Feed")),
        "The list of equipment should contain daily feed");
  }

  @Test
  void equipmentListShouldContainARegularHorse() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Horse, regular")),
        "The list of equipment should contain a regular horse");
  }

  @Test
  void equipmentListShouldContainAWarhorse() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Horse, warhorse")),
        "The list of equipment should contain a warhorse");
  }

  @Test
  void equipmentListShouldContainAPony() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Pony")),
        "The list of equipment should contain a pony");
  }

  @Test
  void equipmentListShouldContainAPackSaddle() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Saddle, pack")),
        "The list of equipment should contain a pack saddle");
  }

  @Test
  void equipmentListShouldContainARidingSaddle() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Saddle, riding")),
        "The list of equipment should contain a riding saddle");
  }

  @Test
  void equipmentListShouldContainSaddlebags() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.equals("Saddlebags")),
        "The list of equipment should contain a saddlebags");
  }

  @Test
  void equipmentListShouldContainDailyStabling() {
    assertTrue(equipmentList.stream()
            .map(Equipment::getName)
            .anyMatch(e -> e.contains("Stabling")),
        "The list of equipment should contains daily stabling");
  }
}