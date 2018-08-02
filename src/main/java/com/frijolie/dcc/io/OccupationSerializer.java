package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.EquipmentFactory;
import com.frijolie.dcc.model.inventory.Item;
import com.frijolie.dcc.model.inventory.Occupation;
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
    alchemist.setStartingWeapon(WeaponFactory.getByName("Staff"));
    alchemist.addTradeGood(EquipmentFactory.getByName("Oil"));

    Occupation animalTrainer = new Occupation("Animal trainer");
    animalTrainer.setStartingWeapon(WeaponFactory.getByName("Club"));
    animalTrainer.addTradeGood(EquipmentFactory.getByName("Pony"));

    Occupation armorer = new Occupation("Armorer");
    armorer.setStartingWeapon(WeaponFactory.getByName("Club"));
    armorer.getStartingWeapon().setName("Hammer (as club)");
    armorer.addTradeGood(new Item("Iron helmet"));

    Occupation astrologer = new Occupation("Astrologer");
    astrologer.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    astrologer.addTradeGood(new Item("Spyglass"));

    Occupation barber = new Occupation("Barber");
    barber.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    barber.getStartingWeapon().setName("Razor (as dagger)");
    barber.addTradeGood(new Item("Scissors"));

    Occupation beadle = new Occupation("Beadle");
    beadle.setStartingWeapon(WeaponFactory.getByName("Staff"));
    beadle.addTradeGood(EquipmentFactory.getByName("Holy"));

    Occupation beekeeper = new Occupation("Beekeeper");
    beekeeper.setStartingWeapon(WeaponFactory.getByName("Staff"));
    beekeeper.addTradeGood(new Item("Jar of honey"));

    Occupation blacksmith = new Occupation("Blacksmith");
    blacksmith.setStartingWeapon(WeaponFactory.getByName("Club"));
    blacksmith.getStartingWeapon().setName("Hammer (as club)");
    blacksmith.addTradeGood(new Item("Steel tongs"));

    Occupation butcher = new Occupation("Butcher");
    butcher.setStartingWeapon(WeaponFactory.getByName("Handaxe"));
    butcher.getStartingWeapon().setName("Cleaver (as axe)");
    butcher.addTradeGood(new Item("Side of beef"));

    Occupation caravanGuard = new Occupation("Caravan guard");
    caravanGuard.setStartingWeapon(WeaponFactory.getByName("Short Sword"));
    caravanGuard.addTradeGood(new Item("Linen, 1 yard"));

    Occupation cheesemaker = new Occupation("Cheesemaker");
    cheesemaker.setStartingWeapon(WeaponFactory.getByName("Staff"));
    cheesemaker.getStartingWeapon().setName("Cudgel (as staff)");
    cheesemaker.addTradeGood(new Item("Stinky cheese"));

    Occupation cobbler = new Occupation("Cobbler");
    cobbler.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    cobbler.getStartingWeapon().setName("Awl (as dagger)");
    cobbler.addTradeGood(new Item("Shoehorn"));

    Occupation confidenceArtist = new Occupation("Confidence artist");
    confidenceArtist.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    confidenceArtist.addTradeGood(new Item("Quality cloak"));

    Occupation cooper = new Occupation("Cooper");
    cooper.setStartingWeapon(WeaponFactory.getByName("Club"));
    cooper.getStartingWeapon().setName("Crowbar (as club)");
    cooper.addTradeGood(new Item("Barrel"));

    Occupation costermonger = new Occupation("Costermonger");
    costermonger.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    costermonger.getStartingWeapon().setName("Knife (as dagger)");
    costermonger.addTradeGood(new Item("Fruit"));

    Occupation cutpurse = new Occupation("Cutpurse");
    cutpurse.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    cutpurse.addTradeGood(new Item("Small chest"));

    Occupation ditchDigger = new Occupation("Ditch digger");
    ditchDigger.setStartingWeapon(WeaponFactory.getByName("Staff"));
    ditchDigger.getStartingWeapon().setName("Shovel (as staff)");
    ditchDigger.addTradeGood(new Item("Fine dirt, 1 lb."));

    Occupation dockWorker = new Occupation("Dock worker");
    dockWorker.setStartingWeapon(WeaponFactory.getByName("Staff"));
    dockWorker.getStartingWeapon().setName("Pole (as staff)");
    dockWorker.addTradeGood(new Item("1 late RPG book"));

    Occupation dwarvenApothecarist = new Occupation("Dwarven apothecarist");
    dwarvenApothecarist.setStartingWeapon(WeaponFactory.getByName("Staff"));
    dwarvenApothecarist.getStartingWeapon().setName("Cudgel (as staff)");
    dwarvenApothecarist.addTradeGood(new Item("Steel vial"));

    Occupation dwarvenBlacksmith = new Occupation("Dwarven blacksmith");
    dwarvenBlacksmith.setStartingWeapon(WeaponFactory.getByName("Club"));
    dwarvenBlacksmith.getStartingWeapon().setName("Hammer (as club)");
    dwarvenBlacksmith.addTradeGood(new Item("Mithril, 1 oz."));

    Occupation dwarvenChestMaker = new Occupation("Dwarven chest maker");
    dwarvenChestMaker.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    dwarvenChestMaker.getStartingWeapon().setName("Chisel (as dagger)");
    dwarvenChestMaker.addTradeGood(new Item("Wood, 10 lbs."));

    Occupation dwarvenHerder = new Occupation("Dwarven herder");
    dwarvenHerder.setStartingWeapon(WeaponFactory.getByName("Staff"));

    Occupation dwarvenMiner = new Occupation("Dwarven miner");
    dwarvenMiner.setStartingWeapon(WeaponFactory.getByName("Club"));
    dwarvenMiner.getStartingWeapon().setName("Pick (as club)");
    dwarvenMiner.addTradeGood(EquipmentFactory.getByName("Lantern"));

    Occupation dwarvenMushroomFarmer = new Occupation("Dwarven mushroom farmer");
    dwarvenMushroomFarmer.setStartingWeapon(WeaponFactory.getByName("Staff"));
    dwarvenMushroomFarmer.getStartingWeapon().setName("Shovel (as staff)");
    dwarvenMushroomFarmer.addTradeGood(new Item("Sack"));

    Occupation dwarvenRatCatcher = new Occupation("Dwarven rat catcher");
    dwarvenRatCatcher.setStartingWeapon(WeaponFactory.getByName("Club"));
    dwarvenRatCatcher.addTradeGood(new Item("Net"));

    Occupation dwarvenStonemason = new Occupation("Dwarven stonemason");
    dwarvenStonemason.setStartingWeapon(WeaponFactory.getByName("Club"));
    dwarvenStonemason.getStartingWeapon().setName("Hammer (as club)");
    dwarvenStonemason.addTradeGood(new Item("Fine stone, 10 lbs."));

    Occupation elvenArtisan = new Occupation("Elven artisan");
    elvenArtisan.setStartingWeapon(WeaponFactory.getByName("Staff"));
    elvenArtisan.addTradeGood(new Item("Clay, 1 lb."));

    Occupation elvenBarrister = new Occupation("Elven barrister");
    elvenBarrister.setStartingWeapon(WeaponFactory.getByName("Dart"));
    elvenBarrister.getStartingWeapon().setName("Quill (as dart)");
    elvenBarrister.addTradeGood(new Item("Book"));

    Occupation elvenChandler = new Occupation("Elven chandler");
    elvenChandler.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    elvenChandler.getStartingWeapon().setName("Scissors (as dagger)");
    elvenChandler.addTradeGood(new Item("Candles, 20"));

    Occupation elvenFalconer = new Occupation("Elven falconer");
    elvenFalconer.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    elvenFalconer.addTradeGood(new Item("Falcon"));

    Occupation elvenForester = new Occupation("Elven forester");
    elvenForester.setStartingWeapon(WeaponFactory.getByName("Staff"));
    elvenForester.addTradeGood(new Item("Herbs, 1 lb."));

    Occupation elvenGlassblower = new Occupation("Elven glassblower");
    elvenGlassblower.setStartingWeapon(WeaponFactory.getByName("Club"));
    elvenGlassblower.getStartingWeapon().setName("Hammer (as club)");
    elvenGlassblower.addTradeGood(new Item("Glass beads"));

    Occupation elvenNavigator = new Occupation("Elven navigator");
    elvenNavigator.setStartingWeapon(WeaponFactory.getByName("Shortbow"));
    elvenNavigator.addTradeGood(new Item("Spyglass"));

    Occupation elvenSage = new Occupation("Elven sage");
    elvenSage.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    elvenSage.addTradeGood(new Item("Parchment and quill pen"));

    Occupation farmer = new Occupation("Farmer");
    farmer.setStartingWeapon(WeaponFactory.getByName("Spear"));
    farmer.getStartingWeapon().setName("Pitchfork (as spear)");
//    farmer.addTradeGood(new Item("Hen**"));

    Occupation fortuneTeller = new Occupation("Fortune-teller");
    fortuneTeller.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    fortuneTeller.addTradeGood(new Item("Tarot deck"));

    Occupation gambler = new Occupation("Gambler");
    gambler.setStartingWeapon(WeaponFactory.getByName("Club"));
    gambler.addTradeGood(new Item("Dice"));

    Occupation gongfarmer = new Occupation("Gongfarmer");
    gongfarmer.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    gongfarmer.addTradeGood(new Item("Sack of night soil"));

    Occupation graveDigger = new Occupation("Grave digger");
    graveDigger.setStartingWeapon(WeaponFactory.getByName("Staff"));
    graveDigger.getStartingWeapon().setName("Shovel (as staff)");
    graveDigger.addTradeGood(new Item("Trowel"));

    Occupation guildBeggar = new Occupation("Guild beggar");
    guildBeggar.setStartingWeapon(WeaponFactory.getByName("Sling"));
    guildBeggar.addTradeGood(new Item("Crutches"));

    Occupation halflingChickenButcher = new Occupation("Halfling chicken butcher");
    halflingChickenButcher.setStartingWeapon(WeaponFactory.getByName("Handaxe"));
    halflingChickenButcher.addTradeGood(new Item("Chicken meat, 5 lbs."));

    Occupation halflingDyer = new Occupation("Halfling dyer");
    halflingDyer.setStartingWeapon(WeaponFactory.getByName("Staff"));
    halflingDyer.addTradeGood(new Item("Fabric, 3 yards"));

    Occupation halflingGlovemaker = new Occupation("Halfling glovemaker");
    halflingGlovemaker.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    halflingGlovemaker.getStartingWeapon().setName("Awl (as dagger)");
    halflingGlovemaker.addTradeGood(new Item("Gloves, 4 pair"));

    Occupation halflingGypsy = new Occupation("Halfling gypsy");
    halflingGypsy.setStartingWeapon(WeaponFactory.getByName("Sling"));
    halflingGypsy.addTradeGood(new Item("Hex doll"));

    Occupation halflingHaberdasher = new Occupation("Halfling haberdasher");
    halflingHaberdasher.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    halflingHaberdasher.getStartingWeapon().setName("Scissors (as dagger)");
    halflingHaberdasher.addTradeGood(new Item("Fine suits, 3 sets"));

    Occupation halflingMariner = new Occupation("Halfling mariner");
    halflingMariner.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    halflingMariner.getStartingWeapon().setName("Knife (as dagger)");
    halflingMariner.addTradeGood(new Item("Sailcloth, 2 yards"));

    Occupation halflingMoneyLender = new Occupation("Halfling moneylender");
    halflingMoneyLender.setStartingWeapon(WeaponFactory.getByName("Short Sword"));
    halflingMoneyLender.addTradeGood(new Item("5GP, 10SP, 200CP"));

    Occupation halflingTrader = new Occupation("Halfling trader");
    halflingTrader.setStartingWeapon(WeaponFactory.getByName("Short Sword"));
    halflingTrader.addTradeGood(new Item("20SP"));

    Occupation halflingVagrant = new Occupation("Halfling vagrant");
    halflingVagrant.setStartingWeapon(WeaponFactory.getByName("Club"));
    halflingVagrant.addTradeGood(new Item("Begging bowl"));

    Occupation healer = new Occupation("Healer");
    healer.setStartingWeapon(WeaponFactory.getByName("Club"));
    healer.addTradeGood(EquipmentFactory.getByName("Holy"));

    Occupation herbalist = new Occupation("Herbalist");
    herbalist.setStartingWeapon(WeaponFactory.getByName("Club"));
    herbalist.addTradeGood(new Item("Herbs, 1 lb."));

    Occupation herder = new Occupation("Herder");
    herder.setStartingWeapon(WeaponFactory.getByName("Staff"));

    Occupation hunter = new Occupation("Hunter");
    hunter.setStartingWeapon(WeaponFactory.getByName("Shortbow"));
    hunter.addTradeGood(new Item("Deer pelt"));

    Occupation indenturedServant = new Occupation("Indentured servant");
    indenturedServant.setStartingWeapon(WeaponFactory.getByName("Staff"));
    indenturedServant.addTradeGood(new Item("Locket"));

    Occupation jester = new Occupation("Jester");
    jester.setStartingWeapon(WeaponFactory.getByName("Dart"));
    jester.addTradeGood(new Item("Silk clothes"));

    Occupation jeweler = new Occupation("Jeweler");
    jeweler.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    jeweler.addTradeGood(new Item("Gem worth 20GP"));

    Occupation locksmith = new Occupation("Locksmith");
    locksmith.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    locksmith.addTradeGood(new Item("Fine tools"));

    Occupation mendicant = new Occupation("Mendicant");
    mendicant.setStartingWeapon(WeaponFactory.getByName("Club"));
    mendicant.addTradeGood(new Item("Cheese dip"));

    Occupation mercenary = new Occupation("Mercenary");
    mercenary.setStartingWeapon(WeaponFactory.getByName("Longsword"));
    mercenary.addTradeGood(new Item("Hide armor (equipped)"));

    Occupation merchant = new Occupation("Merchant");
    merchant.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    merchant.addTradeGood(new Item("4GP, 14SP, 27CP"));

    Occupation millerBaker = new Occupation("Miller/baker");
    millerBaker.setStartingWeapon(WeaponFactory.getByName("Club"));
    millerBaker.addTradeGood(new Item("Flour, 1 lb."));

    Occupation minstrel = new Occupation("Minstrel");
    minstrel.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    minstrel.addTradeGood(new Item("Ukulele"));

    Occupation noble = new Occupation("Noble");
    noble.setStartingWeapon(WeaponFactory.getByName("Longsword"));
    noble.addTradeGood(new Item("Gold ring worth 10GP"));

    Occupation orphan = new Occupation("Orphan");
    orphan.setStartingWeapon(WeaponFactory.getByName("Club"));
    orphan.addTradeGood(new Item("Rag doll"));

    Occupation ostler = new Occupation("Ostler");
    ostler.setStartingWeapon(WeaponFactory.getByName("Staff"));
    ostler.addTradeGood(EquipmentFactory.getByName("Bridle"));

    Occupation outlaw = new Occupation("Outlaw");
    outlaw.setStartingWeapon(WeaponFactory.getByName("Short Sword"));
    outlaw.addTradeGood(new Item("Leather armor (equipped)"));

    Occupation ropeMaker = new Occupation("Rope maker");
    ropeMaker.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    ropeMaker.getStartingWeapon().setName("Knife (as dagger)");
    ropeMaker.addTradeGood(new Item("Rope, 100'"));

    Occupation scribe = new Occupation("Scribe");
    scribe.setStartingWeapon(WeaponFactory.getByName("Dart"));
    scribe.addTradeGood(new Item("Parchment, 10 sheets"));

    Occupation shaman = new Occupation("Shaman");
    shaman.setStartingWeapon(WeaponFactory.getByName("Mace"));
    shaman.addTradeGood(new Item("Herbs, 1 lb."));

    Occupation slave = new Occupation("Slave");
    slave.setStartingWeapon(WeaponFactory.getByName("Club"));
    slave.addTradeGood(new Item("Strange-looking rock"));

    Occupation smuggler = new Occupation("Smuggler");
    smuggler.setStartingWeapon(WeaponFactory.getByName("Sling"));
    smuggler.addTradeGood(new Item("Waterproof sack"));

    Occupation soldier = new Occupation("Soldier");
    soldier.setStartingWeapon(WeaponFactory.getByName("Spear"));
    soldier.addTradeGood(new Item("Shield (equipped)"));

    Occupation squire = new Occupation("Squire");
    squire.setStartingWeapon(WeaponFactory.getByName("Longsword"));
    squire.addTradeGood(new Item("Steel helmet"));

    Occupation taxCollector = new Occupation("Tax collector");
    taxCollector.setStartingWeapon(WeaponFactory.getByName("Longsword"));
    taxCollector.addTradeGood(new Item("100CP"));

    Occupation trapper = new Occupation("Trapper");
    trapper.setStartingWeapon(WeaponFactory.getByName("Sling"));
    trapper.addTradeGood(new Item("Badger pelt"));

    Occupation urchin = new Occupation("Urchin");
    urchin.setStartingWeapon(WeaponFactory.getByName("Club"));
    urchin.getStartingWeapon().setName("Stick (as club)");
    urchin.addTradeGood(new Item("Begging bowl"));

    Occupation wainwright = new Occupation("Wainwright");
    wainwright.setStartingWeapon(WeaponFactory.getByName("Club"));

    Occupation weaver = new Occupation("Weaver");
    weaver.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    weaver.addTradeGood(new Item("Fine suit of clothes"));

    Occupation wizardsApprentice = new Occupation("Wizard's apprentice");
    wizardsApprentice.setStartingWeapon(WeaponFactory.getByName("Dagger"));
    wizardsApprentice.addTradeGood(new Item("Black grimoire"));

    Occupation woodcutter = new Occupation("Woodcutter");
    woodcutter.setStartingWeapon(WeaponFactory.getByName("Handaxe"));
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
