package com.frijolie.dcc.model;

import com.frijolie.dcc.model.characterclass.CharacterClass;
import com.frijolie.dcc.model.characterclass.CharacterClassFactory;
import com.frijolie.dcc.model.characterclass.CharacterClassType;
import com.frijolie.dcc.model.inventory.Armor;
import com.frijolie.dcc.model.inventory.Armor.ArmorType;
import com.frijolie.dcc.model.inventory.ArmorFactory;
import com.frijolie.dcc.model.inventory.DCCCurrency;
import com.frijolie.dcc.model.inventory.DCCCurrency.Type;
import com.frijolie.dcc.model.inventory.Item;
import com.frijolie.dcc.model.inventory.Occupation;
import com.frijolie.dcc.model.inventory.OccupationFactory;
import com.frijolie.dcc.model.inventory.Weapon;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class DCCCharacter {

  private AbilityScore strength, agility, stamina, personality, luck, intelligence;
  private AbilityModifier strengthMod, agilityMod, staminaMod, personalityMod, luckMod, intelligenceMod;
  private SavingThrow reflexSave, fortitudeSave, willpowerSave;
  private LuckyRoll luckyRoll;
  private ObservableList<String> noteList;
  private ObservableList<Item> equipmentList;
  private ObservableList<Weapon> weaponList;
  private ObservableList<DCCCurrency> treasureList;
  private CombatBonus meleeAttack, meleeDamage, missileAttack, missileDamage;
  private HitPoints hitPoints;
  private IntegerProperty initiative;
  private ArmorClass armorClass;
  private ArmorFactory armorFactory;
  private EquippedArmor equippedArmor;
  private ObjectProperty<CharacterClass> characterClass;
  private ObjectProperty<Occupation> occupation;
  private DCCCurrency copper, silver, gold, electrum, platinum;

  /**
   * Constructor. Takes a character class and starting level.
   */
  public DCCCharacter() {
    noteList = FXCollections.observableArrayList();
    equipmentList = FXCollections.observableArrayList();
    weaponList = FXCollections.observableArrayList();
    treasureList = FXCollections.observableArrayList();
    strength = new AbilityScore();
    agility = new AbilityScore();
    stamina = new AbilityScore();
    personality = new AbilityScore();
    luck = new AbilityScore();
    intelligence = new AbilityScore();
    strengthMod = new AbilityModifier();
    agilityMod = new AbilityModifier();
    staminaMod = new AbilityModifier();
    personalityMod = new AbilityModifier();
    luckMod = new AbilityModifier();
    intelligenceMod = new AbilityModifier();
    meleeAttack = new CombatBonus();
    meleeDamage = new CombatBonus();
    missileAttack = new CombatBonus();
    missileDamage = new CombatBonus();
    reflexSave = new SavingThrow(agilityMod.getModifier());
    fortitudeSave = new SavingThrow(staminaMod.getModifier());
    willpowerSave = new SavingThrow(personalityMod.getModifier());
    hitPoints = new HitPoints();
    luckyRoll = new LuckyRoll();
    initiative = new SimpleIntegerProperty(0);
    armorFactory = new ArmorFactory();
    equippedArmor = new EquippedArmor();
    armorClass = new ArmorClass();
    occupation = new SimpleObjectProperty<>();
    characterClass = new SimpleObjectProperty<>();
    copper = new DCCCurrency(Type.COPPER);
    silver = new DCCCurrency(Type.SILVER);
    gold = new DCCCurrency(Type.GOLD);
    electrum = new DCCCurrency(Type.ELECTRUM);
    platinum = new DCCCurrency(Type.PLATINUM);
    initialize();
  }

  /**
   * Triggers a series of calculations which determine character attribute values. These have to be
   * executed in a semi-rigid order because the later calculations are dependent on the prior
   * calculated values.
   * <p>
   * Set as private because I don't want any monkeying around here. The method calls execution order
   * is key.
   */
  private void initialize() {
    equippedArmor.getArmorList().addListener(new ListChangeListener<Armor>() {
      @Override
      public void onChanged(Change<? extends Armor> c) {
        armorClass.calculateArmorClass(agilityMod.getModifier(), equippedArmor.getArmorList());
      }
    });
    setCharacterClass(CharacterClassFactory.getCharacterClass(CharacterClassType.ZERO_LEVEL));
    getCharacterClass().setCharacterLevel(0);
    calculateAbilityScores();
    calculateAbilityModifiers();
    calculateLuckyRoll();
    calculateAbilityRestrictions(); // has to be after LuckyRoll
    calculateSavingThrows();
    calculateHitPoints();
    calculateCombatBonuses();
    calculateLuckyRollBonuses();
    calculateStartingArmor();
    calculateArmorClass(); // has to be after startingArmor
    getCharacterClass().setCharacterSpeed(getCharacterClass().getDefaultSpeed());
    calculateOccupation();
  }

  /**
   * This method is used by the user interface to refresh or re-roll the values of the character.
   * This method is public because this is the only way I want to allow access.
   */
  public final void refresh() {
    initialize();
  }

  /**
   * This method injects the agility modifier and the list of all currently equipped armor to the
   * calculateArmorClass method in ArmorClass.
   * <p>
   * This method will need to be called anytime the agilityModifier changes or a new suit of armor
   * or shield has been equipped.
   *
   * @see ArmorClass#calculateArmorClass(int, List)
   */
  private void calculateArmorClass() {
    armorClass.calculateArmorClass(agilityMod.getModifier(), equippedArmor.getArmorList());
  }

  /**
   * Calculates the armor to be equipped by the character. If a 0-level, the character is unarmored.
   * The Armor is injected to the addArmor method in EquippedArmor.
   * <p>
   * This method only needs to be called when a character has first been generated.
   *
   * @see EquippedArmor#addArmor(Armor)
   */
  private void calculateStartingArmor() {
    if (getCharacterClass().getCharacterLevel() == 0) {
      equippedArmor.addArmor(ArmorFactory.getByName("Unarmored"));
    }
  }

  /**
   * Injects the proper ability modifier values to the setBonus method in CombatBonus. This sets the
   * value for meleeAttack, meleeDamage, missileAttack, and missileDefense values.
   * <p>
   * This method needs to be called anytime the strength or agilityModifier has been changed. The
   * combat bonuses are dependent on these values.
   *
   * @see CombatBonus#setBonus(int)
   */
  private void calculateCombatBonuses() {
    // Strength modifies melee attack and damage rolls. See CRB p78
    meleeAttack.setBonus(strengthMod.getModifier());
    meleeDamage.setBonus(strengthMod.getModifier());
    // Agility modifies missile attack rolls. See CRB p78
    missileAttack.setBonus(agilityMod.getModifier());
    missileDamage.setBonus(0);
  }

  private void calculateOccupation() {
    Occupation occupation = null;
    equipmentList.clear();
    weaponList.clear();
    treasureList.clear();
    copper.setAmount(0);
    silver.setAmount(0);
    gold.setAmount(0);
    equippedArmor.getArmorList().removeIf(armor -> armor.getArmorType() == ArmorType.SHIELD);
    var randomRoll = DiceRoller.rollDice(1, 100);
    occupation = OccupationFactory.getByIndex(randomRoll);
    // check for character class
    if (randomRoll >= 19 && randomRoll <= 28) {
      // dwarf
      setCharacterClass(CharacterClassFactory.getCharacterClass(CharacterClassType.DWARF));
      String name = occupation.getName().replaceAll("Dwarven ", "").trim();
      name = name.substring(0, 1).toUpperCase() + name.substring(1);
      occupation.setName(name);
      setOccupation(occupation);
    } else if (randomRoll >= 29 && randomRoll <= 38) {
      // elf
      setCharacterClass(CharacterClassFactory.getCharacterClass(CharacterClassType.ELF));
      String name = occupation.getName().replaceAll("Elven ", "").trim();
      name = name.substring(0, 1).toUpperCase() + name.substring(1);
      occupation.setName(name);
      setOccupation(occupation);
    } else if (randomRoll >= 39 && randomRoll <= 47) {
      // farmer crop: 1 potato, 2 wheat, 3 turnip, 4 corn, 5 rice, 6 parsnip, 7 radish, 8 rutabaga
      Map<Integer, String> cropMap = new HashMap<>();
      cropMap.put(1, "Potato");
      cropMap.put(2, "Wheat");
      cropMap.put(3, "Turnip");
      cropMap.put(4, "Corn");
      cropMap.put(5, "Rice");
      cropMap.put(6, "Parsnip");
      cropMap.put(7, "Radish");
      cropMap.put(8, "Rutabaga");
      var crop = DiceRoller.rollDice(1, 7);
      occupation.setName(cropMap.get(crop) + " farmer");
      setOccupation(occupation);

      // 1. Hen, 2. Sheep, 3. Goat, 4. Cow, 5. Duck, 6. Goose, 7. Mule
      Map<Integer, String> farmAnimal = new HashMap<>();
      farmAnimal.put(1, "Hen");
      farmAnimal.put(2, "Sheep");
      farmAnimal.put(3, "Goat");
      farmAnimal.put(4, "Cow");
      farmAnimal.put(5, "Duck");
      farmAnimal.put(6, "Goose");
      farmAnimal.put(7, "Mule");
      var animal = DiceRoller.rollDice(1, 7);
      equipmentList.add(new Item(farmAnimal.get(animal)));
    } else if (randomRoll >= 55 && randomRoll <= 64) {
      // halfling
      setCharacterClass(CharacterClassFactory.getCharacterClass(CharacterClassType.HALFLING));
      String name = occupation.getName().replaceAll("Halfling ", "").trim();
      name = name.substring(0, 1).toUpperCase() + name.substring(1);
      occupation.setName(name);
      setOccupation(occupation);
    } else {
      setCharacterClass(CharacterClassFactory.getCharacterClass(CharacterClassType.ZERO_LEVEL));
      setOccupation(occupation);
    }

    if (randomRoll == 22) {
      // dwarven herder: 1. Sow, 2. Sheep, 3. Goat, 4. Cow, 5. Duck, 6. Goose, 7. Mule
      Map<Integer,String> herdAnimal = new HashMap<>();
      herdAnimal.put(1, "Sow");
      herdAnimal.put(2, "Sheep");
      herdAnimal.put(3, "Goat");
      herdAnimal.put(4, "Cow");
      herdAnimal.put(5, "Duck");
      herdAnimal.put(6, "Goose");
      herdAnimal.put(7, "Mule");
      var randomNumber = DiceRoller.rollDice(1,7);
      equipmentList.add(new Item(herdAnimal.get(randomNumber)));
    }

    if (randomRoll == 62) {
      // halfling moneylender
      addGold(5);
      addSilver(10);
      addCopper(200);
      treasureList.addAll(gold, silver, copper);
    }

    if (randomRoll == 63) {
      // halfling trader
      addSilver(20);
      treasureList.add(silver);
    }

    if (randomRoll == 67) {
      // herder: 1. Herding dog, 2. Sheep, 3. Goat, 4. Cow, 5. Duck, 6. Goose, 7. Mule
      Map<Integer,String> herdAnimal = new HashMap<>();
      herdAnimal.put(1, "Herding dog");
      herdAnimal.put(2, "Sheep");
      herdAnimal.put(3, "Goat");
      herdAnimal.put(4, "Cow");
      herdAnimal.put(5, "Duck");
      herdAnimal.put(6, "Goose");
      herdAnimal.put(7, "Mule");
      var randomNumber = DiceRoller.rollDice(1,7);
      equipmentList.add(new Item(herdAnimal.get(randomNumber)));
    }

    if (randomRoll == 75) {
      // mercenary. trade good = hide armor
      equippedArmor.addArmor(ArmorFactory.getByName("Hide"));
    }

    if (randomRoll == 76) {
      // merchant
      addGold(4);
      addSilver(14);
      addCopper(27);
      treasureList.addAll(gold, silver, copper);
    }

    if (randomRoll == 82) {
      // outlaw. trade good = leather armor
      equippedArmor.addArmor(ArmorFactory.getByName("Leather"));
    }

    if (randomRoll == 88) {
      // soldier. trade good = shield
      equippedArmor.addArmor(ArmorFactory.getByName("Shield"));
    }

    if (randomRoll == 91) {
      // tax collector
      addCopper(100);
      treasureList.add(copper);
    }

    if (randomRoll == 95) {
      // wainwright.
      // trade good = pushcart of 1.tomatoes, 2.nothing, 3.straw, 4.your dead, 5.dirt, 6.rocks
      Map<Integer, String> contents = new HashMap<>();
      contents.put(1, "tomatoes");
      contents.put(2, "nothing");
      contents.put(3, "straw");
      contents.put(4, "your dead");
      contents.put(5, "dirt");
      contents.put(6, "rocks");
      var content = DiceRoller.rollDice(1, 6);
      occupation.addTradeGood(new Item("Pushcart of " + contents.get(content)));
    }

    equipmentList.add(getOccupation().getTradeGood());
    weaponList.addAll(getOccupation().getStartingWeapon());
  }

  /**
   * Checks the ability score values and determines if the score is awarded a restriction. Some
   * ability scores, if low enough, have penalties. For example, if a character has an Intelligence
   * score of 5 or lower they cannot read or write and can also not speak a language other than
   * common. This method needs to be called each time an ability score has been modified.
   */
  private void calculateAbilityRestrictions() {
    Map<Integer, String> restrictions = new HashMap<>();
    // For more info regarding ability restrictions, See CRB p18
    restrictions.put(1, "A Strength of 5 or less can carry a weapon or a shield, but not both");
    restrictions.put(2, "A Stamina of 5 or less takes 2x damage from poison and disease");
    restrictions.put(3, "An Intelligence of 5 or less cannot read or write");
    restrictions.put(4, "An Intelligence of 7 or less can only speak Common");

    noteList.clear();

    if (noteList.stream().noneMatch(s -> s.equals(luckyRoll.getBirthAugur()))) {
      noteList.add(luckyRoll.getBirthAugur());
    }

    if (strength.getScore() <= 5) {
      //
      if (noteList.stream().noneMatch(s -> s.equals(restrictions.get(1)))) {
        noteList.add(restrictions.get(1));
      }
    }

    if (stamina.getScore() <= 5) {
      if (noteList.stream().noneMatch(s -> s.equals(restrictions.get(2)))) {
        noteList.add(restrictions.get(2));
      }
    }

    if (intelligence.getScore() <= 5) {
      if (noteList.stream().noneMatch(s -> s.equals(restrictions.get(3)))) {
        noteList.add(restrictions.get(3));
      }
    }

    if (intelligence.getScore() <= 7) {
      if (noteList.stream().noneMatch(s -> s.equals(restrictions.get(4)))) {
        noteList.add(restrictions.get(4));
      }
    }
  }

  private void calculateLuckyRollBonuses() {
    var luckyRoll = getLuckyRoll().getRollResult();
    switch (luckyRoll) {
      case 1:
        meleeAttack.setBonus(luckMod.getModifier() + meleeAttack.getBonus());
        missileAttack.setBonus(luckMod.getModifier() + missileAttack.getBonus());
        break;
      case 2:
        meleeAttack.setBonus(luckMod.getModifier() + meleeAttack.getBonus());
        break;
      case 3:
        missileAttack.setBonus(luckMod.getModifier() + missileAttack.getBonus());
        break;
      case 6:
        missileDamage.setBonus(luckMod.getModifier() + missileDamage.getBonus());
        meleeDamage.setBonus(luckMod.getModifier() + meleeDamage.getBonus());
        break;
      case 7:
        meleeDamage.setBonus(luckMod.getModifier() + meleeDamage.getBonus());
        break;
      case 8:
        missileDamage.setBonus(luckMod.getModifier() + missileDamage.getBonus());
      case 9:
        //TODO add bonus to starting weapon -- need character class first
        Weapon startingWeapon = getOccupation().getStartingWeapon();
        String startingWeaponName = startingWeapon.getName();
        startingWeapon.setName(startingWeaponName + "(" + luckMod.getModifier() + ")");
        break;
      case 13:
        // TODO add bonus to spell checks -- need character class first (wizards and clerics)
        break;
      case 14:
        // TODO add bonus to spell damage -- need character class first (wizards and clerics)
        break;
      case 15:
        // TODO add bonus to turn unholy check -- need character class first (wizards and clerics)
        break;
      case 16:
        // TODO add bonus to healing spells -- need character class first (wizard and clerics)
        break;
      case 17:
        fortitudeSave.setSavingThrow(luckMod.getModifier() + staminaMod.getModifier());
        reflexSave.setSavingThrow(luckMod.getModifier() + agilityMod.getModifier());
        willpowerSave.setSavingThrow(luckMod.getModifier() + personalityMod.getModifier());
        break;
      case 20:
        reflexSave.setSavingThrow(luckMod.getModifier() + agilityMod.getModifier());
        break;
      case 21:
        fortitudeSave.setSavingThrow(luckMod.getModifier() + staminaMod.getModifier());
        break;
      case 22:
        willpowerSave.setSavingThrow(luckMod.getModifier() + personalityMod.getModifier());
        break;
      case 23:
        var modifierBonus = agilityMod.getModifier() + luckMod.getModifier();
        armorClass.calculateArmorClass(modifierBonus, equippedArmor.getArmorList());
        break;
      case 24:
        setInitiative(luckMod.getModifier() + getCharacterClass().getInitiativeBonus());
        break;
      case 25:
        hitPoints.setHitPoints(luckMod.getModifier() + hitPoints.getHitPoints());
        break;
      case 29:
        // TODO add to known languages
        break;
      case 30:
        // every ±1 Luck Mod = ± 5' speed
        int bonus = getLuckMod().getModifier() * 5;
        int currentSpeed = getCharacterClass().getCharacterSpeed();
        // TODO calculate character speed when it applies
        getCharacterClass().setCharacterSpeed(currentSpeed + bonus);
        break;
      default:
        break;
    }
  }

  private void calculateHitPoints() {
    getHitPoints().setHitPoints(0);
    // 0-Level + staminaMod + bonus (class hp/level)
    if (getCharacterClass().getCharacterLevel() > 0) {
      var bonus = DiceRoller
          .rollDice(getCharacterClass().getCharacterLevel(),
              getCharacterClass().getHpDicePerLevel());
      hitPoints.calculateHitPoints(staminaMod.getModifier(), bonus);
    } else {
      hitPoints.calculateHitPoints(staminaMod.getModifier(), 0);
    }
  }

  private void calculateLuckyRoll() {
    luckyRoll.calculateLuckyRoll();
    noteList.add(luckyRoll.getBirthAugur());
  }

  private void calculateAbilityScores() {
    strength.calculateAbilityScore();
    agility.calculateAbilityScore();
    stamina.calculateAbilityScore();
    luck.calculateAbilityScore();
    personality.calculateAbilityScore();
    intelligence.calculateAbilityScore();
  }

  private void calculateAbilityModifiers() {
    strengthMod.calculateModifier(strength.getScore());
    agilityMod.calculateModifier(agility.getScore());
    staminaMod.calculateModifier(stamina.getScore());
    personalityMod.calculateModifier(personality.getScore());
    luckMod.calculateModifier(luck.getScore());
    intelligenceMod.calculateModifier(intelligence.getScore());
  }

  private void calculateSavingThrows() {
    reflexSave.setSavingThrow(agilityMod.getModifier());
    fortitudeSave.setSavingThrow(staminaMod.getModifier());
    willpowerSave.setSavingThrow(personalityMod.getModifier());
  }

  public AbilityScore getStrength() {
    return strength;
  }

  public AbilityScore getAgility() {
    return agility;
  }

  public AbilityScore getStamina() {
    return stamina;
  }

  public AbilityScore getPersonality() {
    return personality;
  }

  public AbilityScore getLuck() {
    return luck;
  }

  public AbilityScore getIntelligence() {
    return intelligence;
  }

  public AbilityModifier getStrengthMod() {
    return strengthMod;
  }

  public AbilityModifier getAgilityMod() {
    return agilityMod;
  }

  public AbilityModifier getStaminaMod() {
    return staminaMod;
  }

  public AbilityModifier getPersonalityMod() {
    return personalityMod;
  }

  public AbilityModifier getLuckMod() {
    return luckMod;
  }

  public AbilityModifier getIntelligenceMod() {
    return intelligenceMod;
  }

  public SavingThrow getReflexSave() {
    return reflexSave;
  }

  public SavingThrow getFortitudeSave() {
    return fortitudeSave;
  }

  public SavingThrow getWillpowerSave() {
    return willpowerSave;
  }

  public LuckyRoll getLuckyRoll() {
    return luckyRoll;
  }

  public ObservableList<DCCCurrency> getTreasure() {
    return treasureList;
  }

  public ObservableList<Item> getEquipment() {
    return equipmentList;
  }

  public ObservableList<String> getNotes() {
    return noteList;
  }

  public ObservableList<Weapon> getWeaponList() {
    return weaponList;
  }

  public int getInitiative() {
    return initiative.get();
  }

  public IntegerProperty initiativeProperty() {
    return initiative;
  }

  public ArmorClass getArmorClass() {
    return armorClass;
  }

  public CombatBonus getMeleeAttack() {
    return meleeAttack;
  }

  public CombatBonus getMeleeDamage() {
    return meleeDamage;
  }

  public CombatBonus getMissileAttack() {
    return missileAttack;
  }

  public CombatBonus getMissileDamage() {
    return missileDamage;
  }


  public HitPoints getHitPoints() {
    return hitPoints;
  }

  public EquippedArmor getEquippedArmor() {
    return equippedArmor;
  }

  public Occupation getOccupation() {
    return occupation.get();
  }

  public ObjectProperty<Occupation> occupationProperty() {
    return occupation;
  }

  public CharacterClass getCharacterClass() {
    return characterClass.get();
  }

  public ObjectProperty<CharacterClass> characterClassProperty() {
    return characterClass;
  }

  public void setOccupation(Occupation occupation) {
    this.occupation.set(occupation);
  }

  public void setInitiative(int initiative) {
    this.initiative.set(initiative);
  }

  public void setCharacterClass(CharacterClass characterClass) {
    this.characterClass.set(characterClass);
  }

  public void setArmorFactory(ArmorFactory armorFactory) {
    this.armorFactory = armorFactory;
  }

  public void addCopper(int amount) {
    setCopper(copper.getAmount() + amount);
  }

  public void addSilver(int amount) {
    setSilver(silver.getAmount() + amount);
  }

  public void addGold(int amount) {
    setGold(gold.getAmount() + amount);
  }

  public void setCopper(int amount) {
    copper.setAmount(amount);
  }

  public void setSilver(int amount) {
    silver.setAmount(amount);
  }

  public void setGold(int amount) {
    gold.setAmount(amount);
  }

  public void setElectrum(int amount) {
    electrum.setAmount(amount);
  }

  public void setPlatinum(int amount) {
    platinum.setAmount(amount);
  }
}