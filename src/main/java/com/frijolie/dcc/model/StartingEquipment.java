package com.frijolie.dcc.model;

import com.frijolie.dcc.model.inventory.Equipment;
import com.frijolie.dcc.model.inventory.EquipmentFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

class StartingEquipment {

  static Map<Integer, Equipment> startingEquipment;

  static {
    startingEquipment = new HashMap<>();
    startingEquipment.put(1, EquipmentFactory.getByName("Backpack"));
    startingEquipment.put(2, EquipmentFactory.getByName("Candle"));
    startingEquipment.put(3, EquipmentFactory.getByName("Chain"));
    startingEquipment.put(4, EquipmentFactory.getByName("Chalk"));
    startingEquipment.put(5, EquipmentFactory.getByName("Chest"));
    startingEquipment.put(6, EquipmentFactory.getByName("Crowbar"));
    startingEquipment.put(7, EquipmentFactory.getByName("Flask"));
    startingEquipment.put(8, EquipmentFactory.getByName("Flint"));
    startingEquipment.put(9, EquipmentFactory.getByName("Grappling"));
    startingEquipment.put(10, EquipmentFactory.getByName("Hammer"));
    startingEquipment.put(11, EquipmentFactory.getByName("Holy symbol"));
    startingEquipment.put(12, EquipmentFactory.getByName("Holy water"));
    startingEquipment.put(13, EquipmentFactory.getByName("Iron spike"));
    startingEquipment.put(14, EquipmentFactory.getByName("Lantern"));
    startingEquipment.put(15, EquipmentFactory.getByName("Mirror"));
    startingEquipment.put(16, EquipmentFactory.getByName("Oil"));
    startingEquipment.put(17, EquipmentFactory.getByName("Pole"));
    startingEquipment.put(18, EquipmentFactory.getByName("Rations"));
    startingEquipment.put(19, EquipmentFactory.getByName("Rope"));
    startingEquipment.put(20, EquipmentFactory.getByName("Sack, large"));
    startingEquipment.put(21, EquipmentFactory.getByName("Sack, small"));
    startingEquipment.put(22, EquipmentFactory.getByName("Thieve"));
    startingEquipment.put(23, EquipmentFactory.getByName("Torch"));
    startingEquipment.put(24, EquipmentFactory.getByName("Waterskin"));
  }

  public final Equipment calculateStartingEquipment() {
    var randomRoll = DiceRoller.rollDice(1, 24);
    if (startingEquipment.containsKey(randomRoll)) {
      return startingEquipment.get(randomRoll);
    } else {
      throw new NoSuchElementException("Starting equipment could not be retrieved.");
    }
  }

}