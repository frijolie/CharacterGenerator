package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.DCCCurrency;
import com.frijolie.dcc.model.inventory.Weapon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponSerializer {

  private DCCCurrency gold, copper, silver;
  private List<Weapon> weapons;

  public WeaponSerializer() {
    gold = new DCCCurrency(DCCCurrency.Type.GOLD);
    copper = new DCCCurrency(DCCCurrency.Type.COPPER);
    silver = new DCCCurrency(DCCCurrency.Type.SILVER);
    weapons = new ArrayList<>();
    populateWeapons();
  }

  private void populateWeapons() {
    String TWO_HANDS = "*Two-handed weapons use a d16 on initiative checks.";
    String DAGGER =
        '\u2020' + "Thieves, when backstabbing, use the 2nd damage value, all others use the 1st.";
    String STRENGTH = "**Strength mod applies to damage at close range only.";
    String SUBDUAL = "***Damage dealt is always subdual damage.";
    String DOUBLE_DAGGER =
        '\u2021' + "Chaotic chars use ceremonial daggers known as Athame, Kris, or Tumi.";
    String POUND = "#These weapons inflict 2x damage on a mounted charge.";

    Weapon battleaxe = new Weapon("Battleaxe");
    battleaxe.setWield(Weapon.Wield.TWO_HANDED);
    battleaxe.setMeleeDamageRoll("1d10");
    battleaxe.setRangedDamageRoll("");
    battleaxe.setIsRanged(false);
    battleaxe.setRange("");
    battleaxe.setCostInCopper(DCCCurrency.convert(7, gold, copper));
    battleaxe.addNotes(TWO_HANDS);

    Weapon blackjack = new Weapon("Blackjack" + '\u2020');
    blackjack.setWield(Weapon.Wield.ONE_HANDED);
    blackjack.setMeleeDamageRoll("1d3/2d6***");
    blackjack.setRangedDamageRoll("");
    blackjack.setIsRanged(false);
    blackjack.setRange("");
    blackjack.setCostInCopper(DCCCurrency.convert(3, gold, copper));
    blackjack.addNotes(DAGGER);
    blackjack.addNotes(SUBDUAL);

    Weapon blowgun = new Weapon("Blowgun" + '\u2020');
    blowgun.setWield(Weapon.Wield.ONE_HANDED);
    blowgun.setMeleeDamageRoll("1d3");
    blowgun.setRangedDamageRoll("1d5");
    blowgun.setIsRanged(true);
    blowgun.setRange("20/40/60");
    blowgun.setCostInCopper(DCCCurrency.convert(6, gold, copper));
    blackjack.addNotes(DAGGER);

    Weapon club = new Weapon("Club");
    club.setWield(Weapon.Wield.ONE_HANDED);
    club.setMeleeDamageRoll("1d4");
    club.setRangedDamageRoll("");
    club.setIsRanged(false);
    club.setRange("");
    club.setCostInCopper(DCCCurrency.convert(3, gold, copper));

    Weapon crossbow = new Weapon("Crossbow");
    crossbow.setWield(Weapon.Wield.TWO_HANDED);
    crossbow.setMeleeDamageRoll("");
    crossbow.setRangedDamageRoll("1d6");
    crossbow.setIsRanged(true);
    crossbow.setRange("80/160/240");
    crossbow.setCostInCopper(DCCCurrency.convert(30, gold, copper));
    crossbow.addNotes(TWO_HANDS);

    Weapon dagger = new Weapon("Dagger" + '\u2020' + '\u2021');
    dagger.setWield(Weapon.Wield.ONE_HANDED);
    dagger.setMeleeDamageRoll("1d4");
    dagger.setRangedDamageRoll("1d10");
    dagger.setIsRanged(true);
    dagger.setRange("10/20/30**");
    dagger.setCostInCopper(DCCCurrency.convert(3, gold, copper));
    dagger.addNotes(DAGGER);
    dagger.addNotes(DOUBLE_DAGGER);
    dagger.addNotes(STRENGTH);

    Weapon dart = new Weapon("Dart");
    dart.setWield(Weapon.Wield.ONE_HANDED);
    dart.setMeleeDamageRoll("");
    dart.setRangedDamageRoll("1d4");
    dart.setIsRanged(true);
    dart.setRange("20/40/60**");
    dart.setCostInCopper(DCCCurrency.convert(5, silver, copper));
    dart.addNotes(STRENGTH);

    Weapon flail = new Weapon("Flail");
    flail.setWield(Weapon.Wield.ONE_HANDED);
    flail.setMeleeDamageRoll("1d6");
    flail.setRangedDamageRoll("");
    flail.setIsRanged(false);
    flail.setRange("");
    flail.setCostInCopper(DCCCurrency.convert(6, gold, copper));

    Weapon garrote = new Weapon("Garrote" + '\u2020');
    garrote.setWield(Weapon.Wield.ONE_HANDED);
    garrote.setMeleeDamageRoll("1/3d4");
    garrote.setRangedDamageRoll("");
    garrote.setIsRanged(false);
    garrote.setRange("");
    garrote.setCostInCopper(DCCCurrency.convert(2, gold, copper));
    garrote.addNotes(DAGGER);

    Weapon handaxe = new Weapon("Handaxe");
    handaxe.setWield(Weapon.Wield.ONE_HANDED);
    handaxe.setMeleeDamageRoll("1d6");
    handaxe.setRangedDamageRoll("1d6");
    handaxe.setIsRanged(true);
    handaxe.setRange("10/20/30**");
    handaxe.setCostInCopper(DCCCurrency.convert(4, gold, copper));
    handaxe.addNotes(STRENGTH);

    Weapon javelin = new Weapon("Javelin");
    javelin.setWield(Weapon.Wield.ONE_HANDED);
    javelin.setMeleeDamageRoll("1d6");
    javelin.setRangedDamageRoll("1d6");
    javelin.setIsRanged(true);
    javelin.setRange("30/60/90**");
    javelin.setCostInCopper(DCCCurrency.convert(1, gold, copper));
    javelin.addNotes(STRENGTH);

    Weapon lance = new Weapon("Lance#");
    lance.setWield(Weapon.Wield.ONE_HANDED);
    lance.setMeleeDamageRoll("1d12");
    lance.setRangedDamageRoll("");
    lance.setIsRanged(false);
    lance.setRange("");
    lance.setCostInCopper(DCCCurrency.convert(25, gold, copper));
    lance.addNotes(POUND);

    Weapon longbow = new Weapon("Longbow");
    longbow.setWield(Weapon.Wield.TWO_HANDED);
    longbow.setMeleeDamageRoll("");
    longbow.setRangedDamageRoll("1d6");
    longbow.setIsRanged(true);
    longbow.setRange("70/140/210");
    longbow.setCostInCopper(DCCCurrency.convert(40, gold, copper));
    longbow.addNotes(TWO_HANDS);

    Weapon longsword = new Weapon("Longsword");
    longsword.setWield(Weapon.Wield.ONE_HANDED);
    longsword.setMeleeDamageRoll("1d8");
    longsword.setRangedDamageRoll("");
    longsword.setIsRanged(false);
    longsword.setRange("");
    longsword.setCostInCopper(DCCCurrency.convert(10, gold, copper));

    Weapon mace = new Weapon("Mace");
    mace.setWield(Weapon.Wield.ONE_HANDED);
    mace.setMeleeDamageRoll("1d6");
    mace.setRangedDamageRoll("");
    mace.setIsRanged(false);
    mace.setRange("");
    mace.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Weapon polearm = new Weapon("Polearm");
    polearm.setWield(Weapon.Wield.TWO_HANDED);
    polearm.setMeleeDamageRoll("1d10");
    polearm.setRangedDamageRoll("");
    polearm.setIsRanged(false);
    polearm.setRange("");
    polearm.setCostInCopper(DCCCurrency.convert(7, gold, copper));
    polearm.addNotes(TWO_HANDS);

    Weapon shortbow = new Weapon("Shortbow");
    shortbow.setWield(Weapon.Wield.TWO_HANDED);
    shortbow.setMeleeDamageRoll("");
    shortbow.setRangedDamageRoll("1d6");
    shortbow.setIsRanged(true);
    shortbow.setRange("50/100/150");
    shortbow.setCostInCopper(DCCCurrency.convert(25, gold, copper));
    shortbow.addNotes(TWO_HANDS);

    Weapon shortSword = new Weapon("Short Sword");
    shortSword.setWield(Weapon.Wield.ONE_HANDED);
    shortSword.setMeleeDamageRoll("1d6");
    shortSword.setRangedDamageRoll("");
    shortSword.setIsRanged(false);
    shortSword.setRange("");
    shortSword.setCostInCopper(DCCCurrency.convert(7, gold, copper));

    Weapon sling = new Weapon("Sling");
    sling.setWield(Weapon.Wield.ONE_HANDED);
    sling.setMeleeDamageRoll("");
    sling.setRangedDamageRoll("1d4");
    sling.setIsRanged(true);
    sling.setRange("40/80/160**");
    sling.setCostInCopper(DCCCurrency.convert(2, gold, copper));
    sling.addNotes(STRENGTH);

    Weapon spear = new Weapon("Spear#");
    spear.setWield(Weapon.Wield.ONE_HANDED);
    spear.setMeleeDamageRoll("1d8");
    spear.setRangedDamageRoll("");
    spear.setIsRanged(false);
    spear.setRange("");
    spear.setCostInCopper(DCCCurrency.convert(3, gold, copper));
    spear.addNotes(POUND);

    Weapon staff = new Weapon("Staff");
    staff.setWield(Weapon.Wield.ONE_HANDED);
    staff.setMeleeDamageRoll("1d4");
    staff.setRangedDamageRoll("");
    staff.setIsRanged(false);
    staff.setRange("");
    staff.setCostInCopper(DCCCurrency.convert(5, silver, copper));

    Weapon twoHandedSword = new Weapon("Two-handed Sword");
    twoHandedSword.setWield(Weapon.Wield.TWO_HANDED);
    twoHandedSword.setMeleeDamageRoll("1d10");
    twoHandedSword.setRangedDamageRoll("");
    twoHandedSword.setIsRanged(false);
    twoHandedSword.setRange("");
    twoHandedSword.setCostInCopper(DCCCurrency.convert(15, gold, copper));
    twoHandedSword.addNotes(TWO_HANDS);

    Weapon warhammer = new Weapon("Warhammer");
    warhammer.setWield(Weapon.Wield.ONE_HANDED);
    warhammer.setMeleeDamageRoll("1d8");
    warhammer.setRangedDamageRoll("");
    warhammer.setIsRanged(false);
    warhammer.setRange("");
    warhammer.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    weapons.add(battleaxe);
    weapons.add(blackjack);
    weapons.add(blowgun);
    weapons.add(club);
    weapons.add(crossbow);
    weapons.add(dagger);
    weapons.add(dart);
    weapons.add(flail);
    weapons.add(garrote);
    weapons.add(handaxe);
    weapons.add(javelin);
    weapons.add(lance);
    weapons.add(longbow);
    weapons.add(longsword);
    weapons.add(mace);
    weapons.add(polearm);
    weapons.add(shortbow);
    weapons.add(shortSword);
    weapons.add(sling);
    weapons.add(spear);
    weapons.add(staff);
    weapons.add(twoHandedSword);
    weapons.add(warhammer);
  }

  public final List<Weapon> getWeaponList() {
    return Collections.unmodifiableList(weapons);
  }

  void writeToJson() {
    JsonWriter.writeToJson(weapons, "weapons.json");
  }

}