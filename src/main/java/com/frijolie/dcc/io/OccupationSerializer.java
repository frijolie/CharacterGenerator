package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.EquipmentFactory;
import com.frijolie.dcc.model.inventory.Item;
import com.frijolie.dcc.model.inventory.Occupation;
import com.frijolie.dcc.model.inventory.Weapon;
import com.frijolie.dcc.model.inventory.WeaponFactory;
import java.util.ArrayList;
import java.util.List;

public class OccupationSerializer {

  List<Occupation> occupations;

  public OccupationSerializer() {
    occupations = new ArrayList<>();
    populateOccupations();
  }

  private void populateOccupations() {

    Occupation alchemist = new Occupation("Alchemist");
    alchemist.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    alchemist.addTradeGood(EquipmentFactory.getByName("Oil"));

    Occupation animalTrainer = new Occupation("Animal trainer");
    animalTrainer.addTrainedWeapon(WeaponFactory.getByName("Club"));
    animalTrainer.addTradeGood(EquipmentFactory.getByName("Pony"));

    Occupation armorer = new Occupation("Armorer");
    armorer.addTrainedWeapon(WeaponFactory.getByName("Club"));
    armorer.getTrainedWeapons().get(0).setName("Hammer (as club)");
    armorer.addTradeGood(new Item("Iron helmet"));

    Occupation astrologer = new Occupation("Astrologer");
    astrologer.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    astrologer.addTradeGood(new Item("Spyglass"));

    Occupation barber = new Occupation("Barber");
    barber.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    barber.getTrainedWeapons().get(0).setName("Razor (as dagger)");
    barber.addTradeGood(new Item("Scissors"));

    Occupation beadle = new Occupation("Beadle");
    beadle.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    beadle.addTradeGood(EquipmentFactory.getByName("Holy"));

    Occupation beekeeper = new Occupation("Beekeeper");
    beekeeper.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    beekeeper.addTradeGood(new Item("Jar of honey"));

    Occupation blacksmith = new Occupation("Blacksmith");
    blacksmith.addTrainedWeapon(WeaponFactory.getByName("Club"));
    blacksmith.getTrainedWeapons().get(0).setName("Hammer (as club)");
    blacksmith.addTradeGood(new Item("Steel tongs"));

    Occupation butcher = new Occupation("Butcher");
    butcher.addTrainedWeapon(WeaponFactory.getByName("Handaxe"));
    butcher.getTrainedWeapons().get(0).setName("Cleaver (as axe)");
    butcher.addTradeGood(new Item("Side of beef"));

    Occupation caravanGuard = new Occupation("Caravan guard");
    caravanGuard.addTrainedWeapon(WeaponFactory.getByName("Short Sword"));
    caravanGuard.addTradeGood(new Item("Linen, 1 yard"));

    Occupation cheesemaker = new Occupation("Cheesemaker");
    cheesemaker.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    cheesemaker.getTrainedWeapons().get(0).setName("Cudgel (as staff)");
    cheesemaker.addTradeGood(new Item("Stinky cheese"));

    Occupation cobbler = new Occupation("Cobbler");
    cobbler.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    cobbler.getTrainedWeapons().get(0).setName("Awl (as dagger)");
    cobbler.addTradeGood(new Item("Shoehorn"));

    Occupation confidenceArtist = new Occupation("Confidence artist");
    confidenceArtist.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    confidenceArtist.addTradeGood(new Item("Quality cloak"));

    Occupation cooper = new Occupation("Cooper");
    cooper.addTrainedWeapon(WeaponFactory.getByName("Club"));
    cooper.getTrainedWeapons().get(0).setName("Crowbar (as club)");
    cooper.addTradeGood(new Item("Barrel"));

    Occupation costermonger = new Occupation("Costermonger");
    costermonger.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    costermonger.getTrainedWeapons().get(0).setName("Knife (as dagger)");
    costermonger.addTradeGood(new Item("Fruit"));

    Occupation cutpurse = new Occupation("Cutpurse");
    cutpurse.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    cutpurse.addTradeGood(new Item("Small chest"));

    Occupation ditchDigger = new Occupation("Ditch digger");
    ditchDigger.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    ditchDigger.getTrainedWeapons().get(0).setName("Shovel (as staff)");
    ditchDigger.addTradeGood(new Item("Fine dirt, 1 lb."));

    Occupation dockWorker = new Occupation("Dock worker");
    dockWorker.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    dockWorker.getTrainedWeapons().get(0).setName("Pole (as staff)");
    dockWorker.addTradeGood(new Item("1 late RPG book"));

    Occupation dwarvenApothecarist = new Occupation("Dwarven apothecarist");
    dwarvenApothecarist.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    dwarvenApothecarist.getTrainedWeapons().get(0).setName("Cudgel (as staff)");
    dwarvenApothecarist.addTradeGood(new Item("Steel vial"));

    Occupation dwarvenBlacksmith = new Occupation("Dwarven blacksmith");
    dwarvenBlacksmith.addTrainedWeapon(WeaponFactory.getByName("Club"));
    dwarvenBlacksmith.getTrainedWeapons().get(0).setName("Hammer (as club)");
    dwarvenBlacksmith.addTradeGood(new Item("Mithril, 1 oz."));

    Occupation dwarvenChestMaker = new Occupation("Dwarven chest maker");
    dwarvenChestMaker.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    dwarvenChestMaker.getTrainedWeapons().get(0).setName("Chisel (as dagger)");
    dwarvenChestMaker.addTradeGood(new Item("Wood, 10 lbs."));

    Occupation dwarvenHerder = new Occupation("Dwarven herder");
    dwarvenHerder.addTrainedWeapon(WeaponFactory.getByName("Staff"));

    Occupation dwarvenMiner = new Occupation("Dwarven miner");
    dwarvenMiner.addTrainedWeapon(WeaponFactory.getByName("Club"));
    dwarvenMiner.getTrainedWeapons().get(0).setName("Pick (as club)");
    dwarvenMiner.addTradeGood(EquipmentFactory.getByName("Lantern"));

    Occupation dwarvenMushroomFarmer = new Occupation("Dwarven mushroom farmer");
    dwarvenMushroomFarmer.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    dwarvenMushroomFarmer.getTrainedWeapons().get(0).setName("Shovel (as staff)");
    dwarvenMushroomFarmer.addTradeGood(new Item("Sack"));

    Occupation dwarvenRatCatcher = new Occupation("Dwarven rat catcher");
    dwarvenRatCatcher.addTrainedWeapon(WeaponFactory.getByName("Club"));
    dwarvenRatCatcher.addTradeGood(new Item("Net"));

    Occupation dwarvenStonemason = new Occupation("Dwarven stonemason");
    dwarvenStonemason.addTrainedWeapon(WeaponFactory.getByName("Club"));
    dwarvenStonemason.getTrainedWeapons().get(0).setName("Hammer (as club)");
    dwarvenStonemason.addTradeGood(new Item("Fine stone, 10 lbs."));

    Occupation elvenArtisan = new Occupation("Elven artisan");
    elvenArtisan.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    elvenArtisan.addTradeGood(new Item("Clay, 1 lb."));

    Occupation elvenBarrister = new Occupation("Elven barrister");
    elvenBarrister.addTrainedWeapon(WeaponFactory.getByName("Dart"));
    elvenBarrister.getTrainedWeapons().get(0).setName("Quill (as dart)");
    elvenBarrister.addTradeGood(new Item("Book"));

    Occupation elvenChandler = new Occupation("Elven chandler");
    elvenChandler.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    elvenChandler.getTrainedWeapons().get(0).setName("Scissors (as dagger)");
    elvenChandler.addTradeGood(new Item("Candles, 20"));

    Occupation elvenFalconer = new Occupation("Elven falconer");
    elvenFalconer.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    elvenFalconer.addTradeGood(new Item("Falcon"));

    Occupation elvenForester = new Occupation("Elven forester");
    elvenForester.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    elvenForester.addTradeGood(new Item("Herbs, 1 lb."));

    Occupation elvenGlassblower = new Occupation("Elven glassblower");
    elvenGlassblower.addTrainedWeapon(WeaponFactory.getByName("Club"));
    elvenGlassblower.getTrainedWeapons().get(0).setName("Hammer (as club)");
    elvenGlassblower.addTradeGood(new Item("Glass beads"));

    Occupation elvenNavigator = new Occupation("Elven navigator");
    elvenNavigator.addTrainedWeapon(WeaponFactory.getByName("Shortbow"));
    elvenNavigator.addTradeGood(new Item("Spyglass"));

    Occupation elvenSage = new Occupation("Elven sage");
    elvenSage.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    elvenSage.addTradeGood(new Item("Parchment and quill pen"));

    Occupation farmer = new Occupation("Farmer");
    farmer.addTrainedWeapon(WeaponFactory.getByName("Spear"));
    farmer.getTrainedWeapons().get(0).setName("Pitchfork (as spear)");
//    farmer.addTradeGood(new Item("Hen**"));

    Occupation fortuneTeller = new Occupation("Fortune-teller");
    fortuneTeller.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    fortuneTeller.addTradeGood(new Item("Tarot deck"));

    Occupation gambler = new Occupation("Gambler");
    gambler.addTrainedWeapon(WeaponFactory.getByName("Club"));
    gambler.addTradeGood(new Item("Dice"));

    Occupation gongfarmer = new Occupation("Gongfarmer");
    gongfarmer.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    gongfarmer.addTradeGood(new Item("Sack of night soil"));

    Occupation graveDigger = new Occupation("Grave digger");
    graveDigger.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    graveDigger.getTrainedWeapons().get(0).setName("Shovel (as staff)");
    graveDigger.addTradeGood(new Item("Trowel"));

    Occupation guildBeggar = new Occupation("Guild beggar");
    guildBeggar.addTrainedWeapon(WeaponFactory.getByName("Sling"));
    guildBeggar.addTradeGood(new Item("Crutches"));

    Occupation halflingChickenButcher = new Occupation("Halfling chicken butcher");
    halflingChickenButcher.addTrainedWeapon(WeaponFactory.getByName("Handaxe"));
    halflingChickenButcher.addTradeGood(new Item("Chicken meat, 5 lbs."));

    Occupation halflingDyer = new Occupation("Halfling dyer");
    halflingDyer.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    halflingDyer.addTradeGood(new Item("Fabric, 3 yards"));

    Occupation halflingGlovemaker = new Occupation("Halfling glovemaker");
    halflingGlovemaker.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    halflingGlovemaker.getTrainedWeapons().get(0).setName("Awl (as dagger)");
    halflingGlovemaker.addTradeGood(new Item("Gloves, 4 pair"));

    Occupation halflingGypsy = new Occupation("Halfling gypsy");
    halflingGypsy.addTrainedWeapon(WeaponFactory.getByName("Sling"));
    halflingGypsy.addTradeGood(new Item("Hex doll"));

    Occupation halflingHaberdasher = new Occupation("Halfling haberdasher");
    halflingHaberdasher.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    halflingHaberdasher.getTrainedWeapons().get(0).setName("Scissors (as dagger)");
    halflingHaberdasher.addTradeGood(new Item("Fine suits, 3 sets"));

    Occupation halflingMariner = new Occupation("Halfling mariner");
    halflingMariner.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    halflingMariner.getTrainedWeapons().get(0).setName("Knife (as dagger)");
    halflingMariner.addTradeGood(new Item("Sailcloth, 2 yards"));

    Occupation halflingMoneyLender = new Occupation("Halfling moneylender");
    halflingMoneyLender.addTrainedWeapon(WeaponFactory.getByName("Short Sword"));
    halflingMoneyLender.addTradeGood(new Item("5GP, 10SP, 200CP"));

    Occupation halflingTrader = new Occupation("Halfling trader");
    halflingTrader.addTrainedWeapon(WeaponFactory.getByName("Short Sword"));
    halflingTrader.addTradeGood(new Item("20SP"));

    Occupation halflingVagrant = new Occupation("Halfling vagrant");
    halflingVagrant.addTrainedWeapon(WeaponFactory.getByName("Club"));
    halflingVagrant.addTradeGood(new Item("Begging bowl"));

    Occupation healer = new Occupation("Healer");
    healer.addTrainedWeapon(WeaponFactory.getByName("Club"));
    healer.addTradeGood(EquipmentFactory.getByName("Holy"));

    Occupation herbalist = new Occupation("Herbalist");
    herbalist.addTrainedWeapon(WeaponFactory.getByName("Club"));
    herbalist.addTradeGood(new Item("Herbs, 1 lb."));

    Occupation herder = new Occupation("Herder");
    herder.addTrainedWeapon(WeaponFactory.getByName("Staff"));

    Occupation hunter = new Occupation("Hunter");
    hunter.addTrainedWeapon(WeaponFactory.getByName("Shortbow"));
    hunter.addTradeGood(new Item("Deer pelt"));

    Occupation indenturedServant = new Occupation("Indentured servant");
    indenturedServant.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    indenturedServant.addTradeGood(new Item("Locket"));

    Occupation jester = new Occupation("Jester");
    jester.addTrainedWeapon(WeaponFactory.getByName("Dart"));
    jester.addTradeGood(new Item("Silk clothes"));

    Occupation jeweler = new Occupation("Jeweler");
    jeweler.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    jeweler.addTradeGood(new Item("Gem worth 20GP"));

    Occupation locksmith = new Occupation("Locksmith");
    locksmith.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    locksmith.addTradeGood(new Item("Fine tools"));

    Occupation mendicant = new Occupation("Mendicant");
    mendicant.addTrainedWeapon(WeaponFactory.getByName("Club"));
    mendicant.addTradeGood(new Item("Cheese dip"));

    Occupation mercenary = new Occupation("Mercenary");
    mercenary.addTrainedWeapon(WeaponFactory.getByName("Longsword"));
    mercenary.addTradeGood(new Item("Hide armor (equipped)"));

    Occupation merchant = new Occupation("Merchant");
    merchant.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    merchant.addTradeGood(new Item("4GP, 14SP, 27CP"));

    Occupation millerBaker = new Occupation("Miller/baker");
    millerBaker.addTrainedWeapon(WeaponFactory.getByName("Club"));
    millerBaker.addTradeGood(new Item("Flour, 1 lb."));

    Occupation minstrel = new Occupation("Minstrel");
    minstrel.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    minstrel.addTradeGood(new Item("Ukulele"));

    Occupation noble = new Occupation("Noble");
    noble.addTrainedWeapon(WeaponFactory.getByName("Longsword"));
    noble.addTradeGood(new Item("Gold ring worth 10GP"));

    Occupation orphan = new Occupation("Orphan");
    orphan.addTrainedWeapon(WeaponFactory.getByName("Club"));
    orphan.addTradeGood(new Item("Rag doll"));

    Occupation ostler = new Occupation("Ostler");
    ostler.addTrainedWeapon(WeaponFactory.getByName("Staff"));
    ostler.addTradeGood(EquipmentFactory.getByName("Bridle"));

    Occupation outlaw = new Occupation("Outlaw");
    outlaw.addTrainedWeapon(WeaponFactory.getByName("Short Sword"));
    outlaw.addTradeGood(new Item("Leather armor (equipped)"));

    Occupation ropeMaker = new Occupation("Rope maker");
    ropeMaker.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    ropeMaker.getTrainedWeapons().get(0).setName("Knife (as dagger)");
    ropeMaker.addTradeGood(new Item("Rope, 100'"));

    Occupation scribe = new Occupation("Scribe");
    scribe.addTrainedWeapon(WeaponFactory.getByName("Dart"));
    scribe.addTradeGood(new Item("Parchment, 10 sheets"));

    Occupation shaman = new Occupation("Shaman");
    shaman.addTrainedWeapon(WeaponFactory.getByName("Mace"));
    shaman.addTradeGood(new Item("Herbs, 1 lb."));

    Occupation slave = new Occupation("Slave");
    slave.addTrainedWeapon(WeaponFactory.getByName("Club"));
    slave.addTradeGood(new Item("Strange-looking rock"));

    Occupation smuggler = new Occupation("Smuggler");
    smuggler.addTrainedWeapon(WeaponFactory.getByName("Sling"));
    smuggler.addTradeGood(new Item("Waterproof sack"));

    Occupation soldier = new Occupation("Soldier");
    soldier.addTrainedWeapon(WeaponFactory.getByName("Spear"));
    soldier.addTradeGood(new Item("Shield (equipped)"));

    Occupation squire = new Occupation("Squire");
    squire.addTrainedWeapon(WeaponFactory.getByName("Longsword"));
    squire.addTradeGood(new Item("Steel helmet"));

    Occupation taxCollector = new Occupation("Tax collector");
    taxCollector.addTrainedWeapon(WeaponFactory.getByName("Longsword"));
    taxCollector.addTradeGood(new Item("100CP"));

    Occupation trapper = new Occupation("Trapper");
    trapper.addTrainedWeapon(WeaponFactory.getByName("Sling"));
    trapper.addTradeGood(new Item("Badger pelt"));

    Occupation urchin = new Occupation("Urchin");
    urchin.addTrainedWeapon(WeaponFactory.getByName("Club"));
    urchin.getTrainedWeapons().get(0).setName("Stick (as club)");
    urchin.addTradeGood(new Item("Begging bowl"));

    Occupation wainwright = new Occupation("Wainwright");
    wainwright.addTrainedWeapon(WeaponFactory.getByName("Club"));

    Occupation weaver = new Occupation("Weaver");
    weaver.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    weaver.addTradeGood(new Item("Fine suit of clothes"));

    Occupation wizardsApprentice = new Occupation("Wizard's apprentice");
    wizardsApprentice.addTrainedWeapon(WeaponFactory.getByName("Dagger"));
    wizardsApprentice.addTradeGood(new Item("Black grimoire"));

    Occupation woodcutter = new Occupation("Woodcutter");
    woodcutter.addTrainedWeapon(WeaponFactory.getByName("Handaxe"));
    woodcutter.addTradeGood(new Item("Bundle of wood"));

    occupations.add(alchemist);
    occupations.add(animalTrainer);
    occupations.add(armorer);
    occupations.add(astrologer);
    occupations.add(barber);
    occupations.add(beadle);
    occupations.add(beekeeper);
    occupations.add(blacksmith);
    occupations.add(butcher);
    occupations.add(caravanGuard);
    occupations.add(cheesemaker);
    occupations.add(cobbler);
    occupations.add(confidenceArtist);
    occupations.add(cooper);
    occupations.add(costermonger);
    occupations.add(cutpurse);
    occupations.add(ditchDigger);
    occupations.add(dockWorker);
    occupations.add(dwarvenApothecarist);
    occupations.add(dwarvenBlacksmith);
    occupations.add(dwarvenChestMaker);
    occupations.add(dwarvenHerder);
    occupations.add(dwarvenMiner);
    occupations.add(dwarvenMushroomFarmer);
    occupations.add(dwarvenRatCatcher);
    occupations.add(dwarvenStonemason);
    occupations.add(elvenArtisan);
    occupations.add(elvenBarrister);
    occupations.add(elvenChandler);
    occupations.add(elvenFalconer);
    occupations.add(elvenForester);
    occupations.add(elvenGlassblower);
    occupations.add(elvenNavigator);
    occupations.add(elvenSage);
    occupations.add(farmer);
    occupations.add(fortuneTeller);
    occupations.add(gambler);
    occupations.add(gongfarmer);
    occupations.add(graveDigger);
    occupations.add(guildBeggar);
    occupations.add(halflingChickenButcher);
    occupations.add(halflingDyer);
    occupations.add(halflingGlovemaker);
    occupations.add(halflingGypsy);
    occupations.add(halflingHaberdasher);
    occupations.add(halflingMariner);
    occupations.add(halflingMoneyLender);
    occupations.add(halflingTrader);
    occupations.add(halflingVagrant);
    occupations.add(healer);
    occupations.add(herbalist);
    occupations.add(herder);
    occupations.add(hunter);
    occupations.add(indenturedServant);
    occupations.add(jester);
    occupations.add(jeweler);
    occupations.add(locksmith);
    occupations.add(mendicant);
    occupations.add(mercenary);
    occupations.add(merchant);
    occupations.add(millerBaker);
    occupations.add(minstrel);
    occupations.add(noble);
    occupations.add(orphan);
    occupations.add(ostler);
    occupations.add(outlaw);
    occupations.add(ropeMaker);
    occupations.add(scribe);
    occupations.add(shaman);
    occupations.add(slave);
    occupations.add(smuggler);
    occupations.add(soldier);
    occupations.add(squire);
    occupations.add(taxCollector);
    occupations.add(trapper);
    occupations.add(urchin);
    occupations.add(wainwright);
    occupations.add(weaver);
    occupations.add(wizardsApprentice);
    occupations.add(woodcutter);
  }

  public final List<Occupation> getOccupationList() {
    return occupations;
  }

  void writeToJson() {
    JsonWriter.writeToJson(occupations,"occupations.json");
  }
}
