package com.frijolie.dcc.model.inventory;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class EquipmentFactoryTest {

  @Test
  void getByName_Backpack_ShouldReturnABackpack() {
    Equipment equipment = EquipmentFactory.getByName("Backpack");
    assertAll("Asking for a Backpack should return a Backpack with the correct stats",
        () -> assertNotNull(equipment, "The backpack should not be null"),
        () -> assertEquals("Backpack", equipment.getName(),
            "A Backpack should have the name of 'Backpack'"),
        () -> assertEquals(200, equipment.getCostInCopper(),
            "A Backpack costInCopper should = 200"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Backpack should not have any notes")
    );
  }

  @Test
  void getByName_Candle_ShouldReturnACandle() {
    Equipment equipment = EquipmentFactory.getByName("Candle");
    assertAll("Asking for a Candle should return a Candle with the correct stats",
        () -> assertNotNull(equipment, "The Candle should not be null"),
        () -> assertEquals("Candle", equipment.getName(),
            "A Candle should have the name of 'Candle'"),
        () -> assertEquals(1, equipment.getCostInCopper(),
            "A Candle costInCopper should = 1"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Candle should not have any notes")
    );
  }

  @Test
  void getByName_Chain_ShouldReturnAChain() {
    Equipment equipment = EquipmentFactory.getByName("Chain");
    assertAll("Asking for a Chain should return a Chain with the correct stats",
        () -> assertNotNull(equipment, "The Chain should not be null"),
        () -> assertEquals("Chain, 10'", equipment.getName(),
            "A Chain should have the name of 'Chain, 10''"),
        () -> assertEquals(3000, equipment.getCostInCopper(),
            "A Chain costInCopper should = 3000"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Chain should not have any notes")
    );
  }

  @Test
  void getByName_Chalk_ShouldReturnChalk() {
    Equipment equipment = EquipmentFactory.getByName("Chalk");
    assertAll("Asking for a Chalk should return a Chalk with the correct stats",
        () -> assertNotNull(equipment, "The Chalk should not be null"),
        () -> assertEquals("Chalk, 1 piece", equipment.getName(),
            "A Chalk should have the name of 'Chalk'"),
        () -> assertEquals(1, equipment.getCostInCopper(),
            "A Chalk costInCopper should = 1"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Chalk should not have any notes")
    );
  }

  @Test
  void getByName_Chest_ShouldReturnAChest() {
    Equipment equipment = EquipmentFactory.getByName("Chest");
    assertAll("Asking for a Chest should return a Chest with the correct stats",
        () -> assertNotNull(equipment, "The Chest should not be null"),
        () -> assertEquals("Chest, empty", equipment.getName(),
            "A Chest should have the name of 'Chest, empty'"),
        () -> assertEquals(200, equipment.getCostInCopper(),
            "A Chest costInCopper should = 200"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Chest should not have any notes")
    );
  }

  @Test
  void getByName_Crowbar_ShouldReturnACrowbar() {
    Equipment equipment = EquipmentFactory.getByName("Crowbar");
    assertAll("Asking for a Crowbar should return a Crowbar with the correct stats",
        () -> assertNotNull(equipment, "The Crowbar should not be null"),
        () -> assertEquals("Crowbar", equipment.getName(),
            "A Crowbar should have the name of 'Crowbar'"),
        () -> assertEquals(200, equipment.getCostInCopper(),
            "A Crowbar costInCopper should = 200"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Crowbar should not have any notes")
    );
  }

  @Test
  void getByName_Flask_ShouldReturnAFlask() {
    Equipment equipment = EquipmentFactory.getByName("Flask");
    assertAll("Asking for a Flask should return a Flask with the correct stats",
        () -> assertNotNull(equipment, "The Flask should not be null"),
        () -> assertEquals("Flask, empty", equipment.getName(),
            "A Flask should have the name of 'Flask, empty'"),
        () -> assertEquals(3, equipment.getCostInCopper(),
            "A Flask costInCopper should = 3"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Flask should not have any notes")
    );
  }

  @Test
  void getByName_FlintAndSteel_ShouldReturnFlintAndSteel() {
    Equipment equipment = EquipmentFactory.getByName("Flint & steel");
    assertAll("Asking for a Flint & steel should return a Flint & steel with the correct stats",
        () -> assertNotNull(equipment, "The Flint & steel should not be null"),
        () -> assertEquals("Flint & steel", equipment.getName(),
            "A Flint & steel should have the name of 'Flint & steel'"),
        () -> assertEquals(15, equipment.getCostInCopper(),
            "A Flint & steel costInCopper should = 15"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Flint & steel should not have any notes")
    );
  }

  @Test
  void getByName_GrapplingHook_ShouldReturnAGrapplingHook() {
    Equipment equipment = EquipmentFactory.getByName("Grappling hook");
    assertAll("Asking for a Grappling hook should return a Grappling hook with the correct stats",
        () -> assertNotNull(equipment, "The Grappling hook should not be null"),
        () -> assertEquals("Grappling hook", equipment.getName(),
            "A Grappling hook should have the name of 'Grappling hook'"),
        () -> assertEquals(100, equipment.getCostInCopper(),
            "A Grappling hook costInCopper should = 100"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Grappling hook should not have any notes")
    );
  }

  @Test
  void getByName_SmallHammer_ShouldReturnASmallHammer() {
    Equipment equipment = EquipmentFactory.getByName("Hammer");
    assertAll("Asking for a Hammer should return a Hammer with the correct stats",
        () -> assertNotNull(equipment, "The Hammer should not be null"),
        () -> assertEquals("Hammer, small", equipment.getName(),
            "A Hammer should have the name of 'Hammer, small'"),
        () -> assertEquals(50, equipment.getCostInCopper(),
            "A Hammer costInCopper should = 50"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Hammer should not have any notes")
    );
  }

  @Test
  void getByName_HolySymbol_ShouldReturnAHolySymbol() {
    Equipment equipment = EquipmentFactory.getByName("Holy symbol");
    assertAll("Asking for a Holy symbol should return a Holy symbol with the correct stats",
        () -> assertNotNull(equipment, "The Holy symbol should not be null"),
        () -> assertEquals("Holy symbol", equipment.getName(),
            "A Holy symbol should have the name of 'Holy symbol'"),
        () -> assertEquals(2500, equipment.getCostInCopper(),
            "A Holy symbol costInCopper should = 2,500"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Holy symbol should not have any notes")
    );
  }

  @Test
  void getByName_HolyWater_ShouldReturnHolyWater() {
    Equipment equipment = EquipmentFactory.getByName("Holy water, 1 vial");
    assertAll("Asking for Holy water should return Holy water with the correct stats",
        () -> assertNotNull(equipment, "The Holy water should not be null"),
        () -> assertEquals("Holy water, 1 vial**", equipment.getName(),
            "Holy water should have the name of 'Holy water, 1 vial'"),
        () -> assertEquals(2500, equipment.getCostInCopper(),
            "Holy water costInCopper should = 2,500"),
        () -> assertEquals(1, equipment.getNotes().size(),
            "A Holy water, 1 vial should have 1 note"),
        () -> assertTrue(equipment.getNotes().stream().anyMatch(e -> e.contains("1d4 damage")),
            "Holy water should contain a note that mentions 1d4 damage")
    );
  }

  @Test
  void getByName_IronSpike_ShouldReturnAnIronSpike() {
    Equipment equipment = EquipmentFactory.getByName("Iron spike");
    assertAll("Asking for a Iron spike should return a Iron spike with the correct stats",
        () -> assertNotNull(equipment, "The Iron spike should not be null"),
        () -> assertEquals("Iron spike", equipment.getName(),
            "A Iron spike should have the name of 'Iron spike'"),
        () -> assertEquals(10, equipment.getCostInCopper(),
            "A Iron spike costInCopper should = 10"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Iron spike should not have any notes")
    );
  }

  @Test
  void getByName_Lantern_ShouldReturnALantern() {
    Equipment equipment = EquipmentFactory.getByName("Lantern");
    assertAll("Asking for a Lantern should return a Lantern with the correct stats",
        () -> assertNotNull(equipment, "The Lantern should not be null"),
        () -> assertEquals("Lantern", equipment.getName(),
            "A Lantern should have the name of 'Lantern'"),
        () -> assertEquals(1000, equipment.getCostInCopper(),
            "A Lantern costInCopper should = 1,000"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Lantern should not have any notes")
    );
  }

  @Test
  void getByName_Mirror_ShouldReturnAMirror() {
    Equipment equipment = EquipmentFactory.getByName("Mirror");
    assertAll("Asking for a Mirror should return a Mirror with the correct stats",
        () -> assertNotNull(equipment, "The Mirror should not be null"),
        () -> assertEquals("Mirror, hand-sized", equipment.getName(),
            "A Mirror should have the name of 'Mirror, hand-sized'"),
        () -> assertEquals(1000, equipment.getCostInCopper(),
            "A Mirror costInCopper should = 1,000"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Mirror should not have any notes")
    );
  }

  @Test
  void getByName_Oil_ShouldReturnOil() {
    Equipment equipment = EquipmentFactory.getByName("Oil");
    assertAll("Asking for a Oil should return a Oil with the correct stats",
        () -> assertNotNull(equipment, "The Oil should not be null"),
        () -> assertEquals("Oil, 1 flask***", equipment.getName(),
            "A Oil should have the name of 'Oil, 1 flask***'"),
        () -> assertEquals(20, equipment.getCostInCopper(),
            "A Oil costInCopper should = 20"),
        () -> assertEquals(2, equipment.getNotes().size(),
            "A Oil should have 2 notes"),
        () -> assertTrue(equipment.getNotes().stream()
                .anyMatch(e -> e.contains("1d6 damage")),
            "Oil should have a note that mentions 1d6 damage"),
        () -> assertTrue(equipment.getNotes().stream()
                .anyMatch(e -> e.contains("burns for six hours")),
            "Oil should have a note that mentions that it burns for 6 hours")
    );
  }

  @Test
  void getByName_Pole_ShouldReturnAPole() {
    Equipment equipment = EquipmentFactory.getByName("Pole");
    assertAll("Asking for a Pole should return a Pole with the correct stats",
        () -> assertNotNull(equipment, "The Pole should not be null"),
        () -> assertEquals("Pole, 10'", equipment.getName(),
            "A Pole should have the name of 'Pole, 10''"),
        () -> assertEquals(15, equipment.getCostInCopper(),
            "A Pole costInCopper should = 15"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Pole should not have any notes")
    );
  }

  @Test
  void getByName_Rations_ShouldReturnRations() {
    Equipment equipment = EquipmentFactory.getByName("Rations");
    assertAll("Asking for a Rations should return a Rations with the correct stats",
        () -> assertNotNull(equipment, "The Rations should not be null"),
        () -> assertEquals("Rations, 1 day", equipment.getName(),
            "A Rations should have the name of 'Rations, 1 day'"),
        () -> assertEquals(5, equipment.getCostInCopper(),
            "A Rations costInCopper should = 5"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Rations should not have any notes")
    );
  }

  @Test
  void getByName_Rope_ShouldReturnARope() {
    Equipment equipment = EquipmentFactory.getByName("Rope");
    assertAll("Asking for a Rope should return a Rope with the correct stats",
        () -> assertNotNull(equipment, "The Rope should not be null"),
        () -> assertEquals("Rope, 50'", equipment.getName(),
            "A Rope should have the name of 'Rope, 50''"),
        () -> assertEquals(25, equipment.getCostInCopper(),
            "A Rope costInCopper should = 25"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Rope should not have any notes")
    );
  }

  @Test
  void getByName_LargeSack_ShouldReturnALargeSack() {
    Equipment equipment = EquipmentFactory.getByName("Sack, large");
    assertAll("Asking for a Sack, large should return a large Sack with the correct stats",
        () -> assertNotNull(equipment, "The Sack should not be null"),
        () -> assertEquals("Sack, large", equipment.getName(),
            "A Sack should have the name of 'Sack, large'"),
        () -> assertEquals(12, equipment.getCostInCopper(),
            "A Sack costInCopper should = 12"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Sack should not have any notes")
    );
  }

  @Test
  void getByName_SmallSack_ShouldReturnASmallSack() {
    Equipment equipment = EquipmentFactory.getByName("Sack, small");
    assertAll("Asking for a Sack, small should return a small sack with the correct stats",
        () -> assertNotNull(equipment, "The Sack should not be null"),
        () -> assertEquals("Sack, small", equipment.getName(),
            "A Sack should have the name of 'Sack, small'"),
        () -> assertEquals(8, equipment.getCostInCopper(),
            "A Sack costInCopper should = 8"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Sack should not have any notes")
    );
  }

  @Test
  void getByName_ThievesTools_ShouldReturnThievesTools() {
    Equipment equipment = EquipmentFactory.getByName("Thieves' tools");
    assertAll("Asking for Thieves' tools should return thieves' tools with the correct stats",
        () -> assertNotNull(equipment, "Thieves' tools should not be null"),
        () -> assertEquals("Thieves' tools", equipment.getName(),
            "Thieves' tools should have the name of \'Thieves' tools\'"),
        () -> assertEquals(2500, equipment.getCostInCopper(),
            "A Thieves' tools costInCopper should = 2,500"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Thieves' tools should not have any notes")
    );
  }

  @Test
  void getByName_Torch_ShouldReturnATorch() {
    Equipment equipment = EquipmentFactory.getByName("Torch");
    assertAll("Asking for a Torch should return a Torch with the correct stats",
        () -> assertNotNull(equipment, "The Torch should not be null"),
        () -> assertEquals("Torch", equipment.getName(),
            "A Torch should have the name of 'Torch'"),
        () -> assertEquals(1, equipment.getCostInCopper(),
            "A Torch costInCopper should = 1"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Torch should not have any notes")
    );
  }

  @Test
  void getByName_Waterskin_ShouldReturnAWaterskin() {
    Equipment equipment = EquipmentFactory.getByName("Waterskin");
    assertAll("Asking for a Waterskin should return a waterskin with the correct stats",
        () -> assertNotNull(equipment, "The Waterskin should not be null"),
        () -> assertEquals("Waterskin", equipment.getName(),
            "A Waterskin should have the name of 'Waterskin'"),
        () -> assertEquals(50, equipment.getCostInCopper(),
            "A Waterskin costInCopper should = 50"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Waterskin should not have any notes")
    );
  }

  @Test
  void getByName_BridleAndBit_ShouldReturnABridleAndBit() {
    Equipment equipment = EquipmentFactory.getByName("Bridle");
    assertAll("Asking for a Bridle should return a Bridle and Bit with the correct stats",
        () -> assertNotNull(equipment, "The Bridle should not be null"),
        () -> assertEquals("Bridle and Bit", equipment.getName(),
            "A Bridle and Bit should have the name of 'Bridle and Bit'"),
        () -> assertEquals(200, equipment.getCostInCopper(),
            "A Bridle costInCopper should = 200"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Bridle should not have any notes")
    );
  }

  @Test
  void getByName_Donkey_ShouldReturnADonkey() {
    Equipment equipment = EquipmentFactory.getByName("Donkey");
    assertAll("Asking for a Donkey should return a Donkey with the correct stats",
        () -> assertNotNull(equipment, "The Donkey should not be null"),
        () -> assertEquals("Donkey", equipment.getName(),
            "A Donkey should have the name of 'Donkey'"),
        () -> assertEquals(800, equipment.getCostInCopper(),
            "A Donkey costInCopper should = 800"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Donkey should not have any notes")
    );
  }

  @Test
  void getByName_Mule_ShouldReturnAMule() {
    Equipment equipment = EquipmentFactory.getByName("Mule");
    assertAll("Asking for a Mule should return a Mule with the correct stats",
        () -> assertNotNull(equipment, "The Mule should not be null"),
        () -> assertEquals("Mule", equipment.getName(),
            "A Mule should have the name of 'Mule'"),
        () -> assertEquals(800, equipment.getCostInCopper(),
            "A Mule costInCopper should = 800"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Mule should not have any notes")
    );
  }

  @Test
  void getByName_Feed_ShouldReturnDailyFeed() {
    Equipment equipment = EquipmentFactory.getByName("Feed");
    assertAll("Asking for a Feed should return a Feed with the correct stats",
        () -> assertNotNull(equipment, "The Feed should not be null"),
        () -> assertEquals("Feed, daily", equipment.getName(),
            "A Feed should have the name of 'Feed, daily'"),
        () -> assertEquals(5, equipment.getCostInCopper(),
            "A Feed costInCopper should = 5"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Feed should not have any notes")
    );
  }

  @Test
  void getByName_HorseRegular_ShouldReturnARegularHorse() {
    Equipment equipment = EquipmentFactory.getByName("Horse, r");
    assertAll("Asking for a Horse, r should return a regular horse with the correct stats",
        () -> assertNotNull(equipment, "The Horse should not be null"),
        () -> assertEquals("Horse, regular", equipment.getName(),
            "A Horse should have the name of 'Horse, regular'"),
        () -> assertEquals(7500, equipment.getCostInCopper(),
            "A Horse costInCopper should = 7500"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Horse should not have any notes")
    );
  }

  @Test
  void getByName_Warhorse_ShouldReturnAWarhorse() {
    Equipment equipment = EquipmentFactory.getByName("Horse, w");
    assertAll("Asking for a Horse, w should return a Horse, warhorse with the correct stats",
        () -> assertNotNull(equipment, "The Horse should not be null"),
        () -> assertEquals("Horse, warhorse", equipment.getName(),
            "A Horse should have the name of 'Horse, warhorse'"),
        () -> assertEquals(20000, equipment.getCostInCopper(),
            "A Horse costInCopper should = 20,000"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Horse should not have any notes")
    );
  }

  @Test
  void getByName_Pony_ShouldReturnAPony() {
    Equipment equipment = EquipmentFactory.getByName("Pony");
    assertAll("Asking for a Pony should return a Pony with the correct stats",
        () -> assertNotNull(equipment, "The Pony should not be null"),
        () -> assertEquals("Pony", equipment.getName(),
            "A Pony should have the name of 'Pony'"),
        () -> assertEquals(3000, equipment.getCostInCopper(),
            "A Pony costInCopper should = 3000"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Pony should not have any notes")
    );
  }

  @Test
  void getByName_SaddlePack_ShouldReturnAPackSaddle() {
    Equipment equipment = EquipmentFactory.getByName("Saddle, p");
    assertAll("Asking for a Saddle, p should return a pack saddle with the correct stats",
        () -> assertNotNull(equipment, "The Saddle should not be null"),
        () -> assertEquals("Saddle, pack", equipment.getName(),
            "A Saddle should have the name of 'Saddle, pack'"),
        () -> assertEquals(1500, equipment.getCostInCopper(),
            "A Saddle costInCopper should = 1500"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Saddle should not have any notes")
    );
  }

  @Test
  void getByName_SaddleRiding_ShouldReturnARidingSaddle() {
    Equipment equipment = EquipmentFactory.getByName("Saddle, r");
    assertAll("Asking for a Saddle, r should return a riding saddle with the correct stats",
        () -> assertNotNull(equipment, "The Saddle should not be null"),
        () -> assertEquals("Saddle, riding", equipment.getName(),
            "A Saddle should have the name of 'Saddle, riding'"),
        () -> assertEquals(3000, equipment.getCostInCopper(),
            "A Saddle costInCopper should = 3000"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "A Saddle should not have any notes")
    );
  }

  @Test
  void getByName_Saddlebags_ShouldReturnSaddlebags() {
    Equipment equipment = EquipmentFactory.getByName("Saddlebag");
    assertAll("Asking for a Saddlebag should return a saddlebags with the correct stats",
        () -> assertNotNull(equipment, "Saddlebags should not be null"),
        () -> assertEquals("Saddlebags", equipment.getName(),
            "Saddlebags should have the name of 'Saddlebags'"),
        () -> assertEquals(200, equipment.getCostInCopper(),
            "Saddlebags costInCopper should = 200"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "Saddlebags should not have any notes")
    );
  }

  @Test
  void getByName_Stabling_ShouldReturnStabling() {
    Equipment equipment = EquipmentFactory.getByName("Stabl");
    assertAll("Asking for a Stabl should return daily stabling with the correct stats",
        () -> assertNotNull(equipment, "Stabling should not be null"),
        () -> assertEquals("Stabling, daily", equipment.getName(),
            "Stabling should have the name of 'Stabling, daily'"),
        () -> assertEquals(50, equipment.getCostInCopper(),
            "Stabling costInCopper should = 50"),
        () -> assertEquals(0, equipment.getNotes().size(),
            "Stabling should not have any notes")
    );
  }

  @Test
  void getByName_SendingNullParamShouldThrowNullPointerException() {
    assertThrows(NullPointerException.class, () -> EquipmentFactory.getByName(null),
        "Passing a null param to getByName should throw a NullPointerException");
  }

  @Test
  void getByName_AttemptingToRetrieveInvalidEquipmentThrowsNoSuchElementException() {
    assertThrows(NoSuchElementException.class,
        () -> EquipmentFactory.getByName("Super awesome equipment"),
        "Cannot retrieve a non-existent piece of equipment. NSE");
  }

}