package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.DCCCurrency;
import com.frijolie.dcc.model.inventory.DCCCurrency.Type;
import com.frijolie.dcc.model.inventory.Equipment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EquipmentSerializer {

  private List<Equipment> equipmentList;
  private DCCCurrency gold;
  private DCCCurrency copper;
  private DCCCurrency silver;

  public EquipmentSerializer() {
    gold = new DCCCurrency(Type.GOLD);
    copper = new DCCCurrency(Type.COPPER);
    silver = new DCCCurrency(Type.SILVER);
    equipmentList = new ArrayList<>();
    populateEquipment();
  }

  private void populateEquipment() {

    String HOLY_WATER = "**" + '\u00BD' + " pint of holy water inflicts 1d4 damage to undead.";
    String OIL = "***When ignited and tossed, inflicts 1d6 damage + fire.";
    String BURN = "A flask of oil burns for six hours in a lantern.";

    Equipment backpack = new Equipment("Backpack",
        DCCCurrency.convert(2, gold, copper));

    Equipment candle = new Equipment("Candle", 1);

    Equipment chain = new Equipment("Chain, 10'",
        DCCCurrency.convert(30, gold, copper));

    Equipment chalk = new Equipment("Chalk, 1 piece", 1);

    Equipment chest = new Equipment("Chest, empty",
        DCCCurrency.convert(2, gold, copper));

    Equipment crowbar = new Equipment("Crowbar",
        DCCCurrency.convert(2, gold, copper));

    Equipment flask = new Equipment("Flask, empty", 3);

    Equipment flintSteel = new Equipment("Flint & steel", 15);

    Equipment graplingHook = new Equipment("Grappling hook",
        DCCCurrency.convert(1, gold, copper));

    Equipment hammer = new Equipment("Hammer, small",
        DCCCurrency.convert(5, silver, copper));

    Equipment holySymbol = new Equipment("Holy symbol",
        DCCCurrency.convert(25, gold, copper));

    Equipment holyWater = new Equipment("Holy water, 1 vial**",
        DCCCurrency.convert(25, gold, copper));
    holyWater.addNotes(HOLY_WATER);

    Equipment ironSpike = new Equipment("Iron spike",
        DCCCurrency.convert(1, silver, copper));

    Equipment lantern = new Equipment("Lantern",
        DCCCurrency.convert(10, gold, copper));

    Equipment mirror = new Equipment("Mirror, hand-sized",
        DCCCurrency.convert(10, gold, copper));

    Equipment oil = new Equipment("Oil, 1 flask***",
        DCCCurrency.convert(2, silver, copper));
    oil.addNotes(OIL);
    oil.addNotes(BURN);

    Equipment pole = new Equipment("Pole, 10'", 15);

    Equipment rations = new Equipment("Rations, 1 day", 5);

    Equipment rope = new Equipment("Rope, 50'", 25);

    Equipment sackLarge = new Equipment("Sack, large", 12);

    Equipment sackSmall = new Equipment("Sack, small", 8);

    Equipment thievesTools = new Equipment("Thieves' tools",
        DCCCurrency.convert(25, gold, copper));

    Equipment torch = new Equipment("Torch", 1);

    Equipment waterskin = new Equipment("Waterskin",
        DCCCurrency.convert(5, silver, copper));

    // TODO Add Barding (horse armor). Cost is 4x human size cost of armor class

    Equipment bridleAndBit = new Equipment("Bridle and Bit",
        DCCCurrency.convert(2, gold, copper));

    Equipment donkey = new Equipment("Donkey",
        DCCCurrency.convert(8, gold, copper));

    Equipment mule = new Equipment("Mule",
        DCCCurrency.convert(8, gold, copper));

    Equipment feed = new Equipment("Feed, daily", 5);

    Equipment regularHorse = new Equipment("Horse, regular",
        DCCCurrency.convert(75, gold, copper));

    Equipment warhorse = new Equipment("Horse, warhorse",
        DCCCurrency.convert(200, gold, copper));

    Equipment pony = new Equipment("Pony",
        DCCCurrency.convert(30, gold, copper));

    Equipment packSaddle = new Equipment("Saddle, pack",
        DCCCurrency.convert(15, gold, copper));

    Equipment packRiding = new Equipment("Saddle, riding",
        DCCCurrency.convert(30, gold, copper));

    Equipment saddlebags = new Equipment("Saddlebags",
        DCCCurrency.convert(2, gold, copper));

    Equipment stabling = new Equipment("Stabling, daily",
        DCCCurrency.convert(5, silver, copper));

    equipmentList.add(backpack);
    equipmentList.add(candle);
    equipmentList.add(chain);
    equipmentList.add(chalk);
    equipmentList.add(chest);
    equipmentList.add(crowbar);
    equipmentList.add(flask);
    equipmentList.add(flintSteel);
    equipmentList.add(graplingHook);
    equipmentList.add(hammer);
    equipmentList.add(holySymbol);
    equipmentList.add(holyWater);
    equipmentList.add(ironSpike);
    equipmentList.add(lantern);
    equipmentList.add(mirror);
    equipmentList.add(oil);
    equipmentList.add(pole);
    equipmentList.add(rations);
    equipmentList.add(rope);
    equipmentList.add(sackLarge);
    equipmentList.add(sackSmall);
    equipmentList.add(thievesTools);
    equipmentList.add(torch);
    equipmentList.add(waterskin);
    equipmentList.add(bridleAndBit);
    equipmentList.add(donkey);
    equipmentList.add(mule);
    equipmentList.add(feed);
    equipmentList.add(regularHorse);
    equipmentList.add(warhorse);
    equipmentList.add(pony);
    equipmentList.add(packSaddle);
    equipmentList.add(packRiding);
    equipmentList.add(saddlebags);
    equipmentList.add(stabling);
  }

  public List<Equipment> getEquipmentList() {
    return Collections.unmodifiableList(equipmentList);
  }

  void writeToJSON() {
    JsonWriter.writeToJson(equipmentList, "equipment.json");
  }
}