package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.DCCCurrency;
import com.frijolie.dcc.model.inventory.MeleeRangedWeapon;
import com.frijolie.dcc.model.inventory.MeleeWeapon;
import com.frijolie.dcc.model.inventory.RangedWeapon;
import com.frijolie.dcc.model.inventory.Weapon;
import com.frijolie.dcc.model.inventory.Weapon.Type;
import com.frijolie.dcc.model.inventory.Weapon.Wield;
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
    String THIEF =
        '\u2020' + " Thieves, when backstabbing, use the 2nd damage value.";
    String STRENGTH = "**Strength mod applies to damage at close range only.";
    String SUBDUAL = "***Damage dealt is always subdual damage.";
    String DOUBLE_DAGGER =
        '\u2021' + "Chaotics use daggers known as Athame, Kris, or Tumi.";
    String POUND = "#These weapons inflict 2x damage on a mounted charge.";

    MeleeWeapon battleaxe = new MeleeWeapon("Battleaxe*");
    battleaxe.setWield(Wield.TWO_HANDED);
    battleaxe.setMeleeDamage("1d10");
    battleaxe.setWeaponType(Type.MELEE);
    battleaxe.setCostInCopper(DCCCurrency.convert(7, gold, copper));
    battleaxe.addNotes(TWO_HANDS);

    MeleeWeapon blackjack = new MeleeWeapon("Blackjack" + '\u2020');
    blackjack.setWield(Wield.ONE_HANDED);
    blackjack.setMeleeDamage("1d3/2d6***");
    blackjack.setWeaponType(Type.MELEE);
    blackjack.setCostInCopper(DCCCurrency.convert(3, gold, copper));
    blackjack.addNotes(THIEF);
    blackjack.addNotes(SUBDUAL);

    RangedWeapon blowgun = new RangedWeapon("Blowgun" + '\u2020');
    blowgun.setWield(Wield.ONE_HANDED);
    blowgun.setRangedDamage("1d3/1d5");
    blowgun.setWeaponType(Type.RANGED);
    blowgun.setRange("20/40/60");
    blowgun.setCostInCopper(DCCCurrency.convert(6, gold, copper));
    blackjack.addNotes(THIEF);

    MeleeWeapon club = new MeleeWeapon("Club");
    club.setWield(Wield.ONE_HANDED);
    club.setMeleeDamage("1d4");
    club.setWeaponType(Type.MELEE);
    club.setCostInCopper(DCCCurrency.convert(3, gold, copper));

    RangedWeapon crossbow = new RangedWeapon("Crossbow*");
    crossbow.setWield(Wield.TWO_HANDED);
    crossbow.setRangedDamage("1d6");
    crossbow.setWeaponType(Type.RANGED);
    crossbow.setRange("80/160/240");
    crossbow.setCostInCopper(DCCCurrency.convert(30, gold, copper));
    crossbow.addNotes(TWO_HANDS);

    MeleeRangedWeapon dagger = new MeleeRangedWeapon("Dagger" + '\u2020' + '\u2021');
    dagger.setWield(Wield.ONE_HANDED);
    dagger.setMeleeDamage("1d4");
    dagger.setRangedDamage("1d10");
    dagger.setWeaponType(Type.BOTH);
    dagger.setRange("10/20/30**");
    dagger.setCostInCopper(DCCCurrency.convert(3, gold, copper));
    dagger.addNotes(THIEF);
    dagger.addNotes(DOUBLE_DAGGER);
    dagger.addNotes(STRENGTH);

    RangedWeapon dart = new RangedWeapon("Dart");
    dart.setWield(Wield.ONE_HANDED);
    dart.setRangedDamage("1d4");
    dart.setWeaponType(Type.RANGED);
    dart.setRange("20/40/60**");
    dart.setCostInCopper(DCCCurrency.convert(5, silver, copper));
    dart.addNotes(STRENGTH);

    MeleeWeapon flail = new MeleeWeapon("Flail");
    flail.setWield(Wield.ONE_HANDED);
    flail.setMeleeDamage("1d6");
    flail.setWeaponType(Type.MELEE);
    flail.setCostInCopper(DCCCurrency.convert(6, gold, copper));

    MeleeWeapon garrote = new MeleeWeapon("Garrote" + '\u2020');
    garrote.setWield(Wield.ONE_HANDED);
    garrote.setMeleeDamage("1/3d4");
    garrote.setWeaponType(Type.MELEE);
    garrote.setCostInCopper(DCCCurrency.convert(2, gold, copper));
    garrote.addNotes(THIEF);

    MeleeRangedWeapon handaxe = new MeleeRangedWeapon("Handaxe");
    handaxe.setWield(Wield.ONE_HANDED);
    handaxe.setMeleeDamage("1d6");
    handaxe.setRangedDamage("1d6");
    handaxe.setWeaponType(Type.BOTH);
    handaxe.setRange("10/20/30**");
    handaxe.setCostInCopper(DCCCurrency.convert(4, gold, copper));
    handaxe.addNotes(STRENGTH);

    MeleeRangedWeapon javelin = new MeleeRangedWeapon("Javelin");
    javelin.setWield(Wield.ONE_HANDED);
    javelin.setMeleeDamage("1d6");
    javelin.setRangedDamage("1d6");
    javelin.setWeaponType(Type.BOTH);
    javelin.setRange("30/60/90**");
    javelin.setCostInCopper(DCCCurrency.convert(1, gold, copper));
    javelin.addNotes(STRENGTH);

    MeleeWeapon lance = new MeleeWeapon("Lance#");
    lance.setWield(Wield.ONE_HANDED);
    lance.setMeleeDamage("1d12");
    lance.setWeaponType(Type.MELEE);
    lance.setCostInCopper(DCCCurrency.convert(25, gold, copper));
    lance.addNotes(POUND);

    RangedWeapon longbow = new RangedWeapon("Longbow*");
    longbow.setWield(Wield.TWO_HANDED);
    longbow.setRangedDamage("1d6");
    longbow.setWeaponType(Type.RANGED);
    longbow.setRange("70/140/210");
    longbow.setCostInCopper(DCCCurrency.convert(40, gold, copper));
    longbow.addNotes(TWO_HANDS);

    MeleeWeapon longsword = new MeleeWeapon("Longsword");
    longsword.setWield(Wield.ONE_HANDED);
    longsword.setMeleeDamage("1d8");
    longsword.setWeaponType(Type.MELEE);
    longsword.setCostInCopper(DCCCurrency.convert(10, gold, copper));

    MeleeWeapon mace = new MeleeWeapon("Mace");
    mace.setWield(Wield.ONE_HANDED);
    mace.setMeleeDamage("1d6");
    mace.setWeaponType(Type.MELEE);
    mace.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    MeleeWeapon polearm = new MeleeWeapon("Polearm*");
    polearm.setWield(Wield.TWO_HANDED);
    polearm.setMeleeDamage("1d10");
    polearm.setWeaponType(Type.MELEE);
    polearm.setCostInCopper(DCCCurrency.convert(7, gold, copper));
    polearm.addNotes(TWO_HANDS);

    RangedWeapon shortbow = new RangedWeapon("Shortbow*");
    shortbow.setWield(Wield.TWO_HANDED);
    shortbow.setRangedDamage("1d6");
    shortbow.setWeaponType(Type.RANGED);
    shortbow.setRange("50/100/150");
    shortbow.setCostInCopper(DCCCurrency.convert(25, gold, copper));
    shortbow.addNotes(TWO_HANDS);

    MeleeWeapon shortSword = new MeleeWeapon("Short sword");
    shortSword.setWield(Wield.ONE_HANDED);
    shortSword.setMeleeDamage("1d6");
    shortSword.setWeaponType(Type.MELEE);
    shortSword.setCostInCopper(DCCCurrency.convert(7, gold, copper));

    RangedWeapon sling = new RangedWeapon("Sling");
    sling.setWield(Wield.ONE_HANDED);
    sling.setRangedDamage("1d4");
    sling.setWeaponType(Type.RANGED);
    sling.setRange("40/80/160**");
    sling.setCostInCopper(DCCCurrency.convert(2, gold, copper));
    sling.addNotes(STRENGTH);

    MeleeWeapon spear = new MeleeWeapon("Spear#");
    spear.setWield(Wield.ONE_HANDED);
    spear.setMeleeDamage("1d8");
    spear.setWeaponType(Type.MELEE);
    spear.setCostInCopper(DCCCurrency.convert(3, gold, copper));
    spear.addNotes(POUND);

    MeleeWeapon staff = new MeleeWeapon("Staff");
    staff.setWield(Wield.ONE_HANDED);
    staff.setMeleeDamage("1d4");
    staff.setWeaponType(Type.MELEE);
    staff.setCostInCopper(DCCCurrency.convert(5, silver, copper));

    MeleeWeapon twoHandedSword = new MeleeWeapon("Two-handed sword*");
    twoHandedSword.setWield(Wield.TWO_HANDED);
    twoHandedSword.setMeleeDamage("1d10");
    twoHandedSword.setWeaponType(Type.MELEE);
    twoHandedSword.setCostInCopper(DCCCurrency.convert(15, gold, copper));
    twoHandedSword.addNotes(TWO_HANDS);

    MeleeWeapon warhammer = new MeleeWeapon("Warhammer");
    warhammer.setWield(Wield.ONE_HANDED);
    warhammer.setMeleeDamage("1d8");
    warhammer.setWeaponType(Type.MELEE);
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