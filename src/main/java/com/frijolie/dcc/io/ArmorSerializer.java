package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.Armor;
import com.frijolie.dcc.model.inventory.Armor.ArmorType;
import com.frijolie.dcc.model.inventory.DCCCurrency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArmorSerializer {

  private DCCCurrency gold;
  private DCCCurrency copper;
  private List<Armor> armorList;

  public ArmorSerializer() {
    gold = new DCCCurrency(DCCCurrency.Type.GOLD);
    copper = new DCCCurrency(DCCCurrency.Type.COPPER);
    armorList = new ArrayList<>();
    populateArmor();
  }

  private void populateArmor() {
    Armor unarmored = new Armor("Unarmored", 0);
    unarmored.setAcBonus(0);
    unarmored.setCheckPenalty(0);
    unarmored.setFumbleDie("d4");
    unarmored.setSpeedPenalty(0);
    unarmored.setArmorType(ArmorType.ARMOR);

    Armor padded = new Armor("Padded", DCCCurrency.convert(5, gold, copper));
    padded.setAcBonus(1);
    padded.setCheckPenalty(0);
    padded.setSpeedPenalty(0);
    padded.setFumbleDie("d8");
    padded.setArmorType(ArmorType.ARMOR);

    Armor leather = new Armor("Leather", DCCCurrency.convert(20, gold, copper));
    leather.setAcBonus(2);
    leather.setCheckPenalty(-1);
    leather.setSpeedPenalty(0);
    leather.setFumbleDie("d8");
    leather.setArmorType(ArmorType.ARMOR);

    Armor studdedLeather = new Armor("Studded leather",
        DCCCurrency.convert(45, gold, copper));
    studdedLeather.setAcBonus(3);
    studdedLeather.setCheckPenalty(-2);
    studdedLeather.setSpeedPenalty(0);
    studdedLeather.setFumbleDie("d8");
    studdedLeather.setArmorType(ArmorType.ARMOR);

    Armor hide = new Armor("Hide", DCCCurrency.convert(30, gold, copper));
    hide.setAcBonus(3);
    hide.setCheckPenalty(-3);
    hide.setSpeedPenalty(0);
    hide.setFumbleDie("d12");
    hide.setArmorType(ArmorType.ARMOR);

    Armor scaleMail = new Armor("Scale mail", DCCCurrency.convert(80, gold, copper));
    scaleMail.setAcBonus(4);
    scaleMail.setCheckPenalty(-4);
    scaleMail.setSpeedPenalty(-5);
    scaleMail.setFumbleDie("d12");
    scaleMail.setArmorType(ArmorType.ARMOR);

    Armor chainMail = new Armor("Chainmail", DCCCurrency.convert(150, gold, copper));
    chainMail.setAcBonus(5);
    chainMail.setCheckPenalty(-5);
    chainMail.setSpeedPenalty(-5);
    chainMail.setFumbleDie("d12");
    chainMail.setArmorType(ArmorType.ARMOR);

    Armor bandedMail = new Armor("Banded mail",
        DCCCurrency.convert(250, gold, copper));
    bandedMail.setAcBonus(6);
    bandedMail.setCheckPenalty(-6);
    bandedMail.setSpeedPenalty(-5);
    bandedMail.setFumbleDie("d16");
    bandedMail.setArmorType(ArmorType.ARMOR);

    Armor halfPlate = new Armor("Half-plate", DCCCurrency.convert(550, gold, copper));
    halfPlate.setAcBonus(7);
    halfPlate.setCheckPenalty(-7);
    halfPlate.setSpeedPenalty(-10);
    halfPlate.setFumbleDie("d16");
    halfPlate.setArmorType(ArmorType.ARMOR);

    Armor fullPlate = new Armor("Full plate",
        DCCCurrency.convert(1200, gold, copper));
    fullPlate.setAcBonus(8);
    fullPlate.setCheckPenalty(-8);
    fullPlate.setSpeedPenalty(-10);
    fullPlate.setFumbleDie("d16");
    fullPlate.setArmorType(ArmorType.ARMOR);

    Armor shield = new Armor("Shield", DCCCurrency.convert(10, gold, copper));
    shield.setAcBonus(1);
    shield.setCheckPenalty(-1);
    shield.setSpeedPenalty(0);
    shield.setFumbleDie("d8");
    shield.setArmorType(ArmorType.SHIELD);

    armorList.add(unarmored);
    armorList.add(padded);
    armorList.add(leather);
    armorList.add(studdedLeather);
    armorList.add(hide);
    armorList.add(scaleMail);
    armorList.add(chainMail);
    armorList.add(bandedMail);
    armorList.add(halfPlate);
    armorList.add(fullPlate);
    armorList.add(shield);
  }

  public final List<Armor> getArmorList() {
    return Collections.unmodifiableList(armorList);
  }

  void writeToJson() {
    JsonWriter.writeToJson(getArmorList(), "armor.json");
  }

}