package com.frijolie.dcc.model.inventory;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * <p>Currency represents a itemType of currency in the application.</p>
 *
 * <p>There are five types of currencies in DCC, listed in lowest denomination to highest: copper,
 * silver, gold, electrum, and platinum. Types of currencies are stored in an enumeration class
 * variable. Each of these currencies will have an abbreviated name represented by two letters, a
 * full name, represented by a word, and a multiplier. A multiplier is used to determine the
 * conversion rate between currencies. All items in DCC (i.e. Weapons, Equipment, Ammunition, Armor)
 * are stored in their cost in Copper (the lowest denomination).</p>
 *
 * <p>There is a helper method to convert from one form of currency to another.</p>
 *
 * <p>For more information on currency, see Dungeon Crawl Classics Core Rule Book (DCCCRB),
 * 4<sup>th</sup> edition p.70</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class DCCCurrency {

  /**
   * A representation of the currency in the form of two letters. For example, 'CP' (copper pieces)
   */
  private ReadOnlyStringWrapper abbreviation;
  /**
   * The representation of the currency in the form of a word. For example, "Copper"
   */
  private ReadOnlyStringWrapper name;
  /**
   * The amount of the specific currency.
   */
  private ReadOnlyIntegerWrapper amount;
  /**
   * The description of the currency. Name + ( abbreviation )
   */
  private ReadOnlyStringWrapper description;
  /**
   * An int value used to convert currency from one itemType to another.
   */
  private int multiplier;

  /**
   * Constructor. Must pass a Type as an argument.
   */
  public DCCCurrency(Type type) {
    /**
     * The itemType of currency. An Enum value. Values are COPPER, SILVER, GOLD, ELECTRUM, and PLATINUM
     */
    Type type1 = type;
    name = new ReadOnlyStringWrapper(type.getName());
    abbreviation = new ReadOnlyStringWrapper(type.getAbbreviation());
    multiplier = type.getMultiplicator();
    amount = new ReadOnlyIntegerWrapper(0);
    description = new ReadOnlyStringWrapper(getName() + " (" + getAbbreviation() + ")");
  }

  /**
   * An enum of all the types of currency
   */
  public enum Type {
    /**
     * Copper is the lowest denomination of currency in the game. Copper is abbreviated as "CP". All
     * prices and values will be stored in this currency and will need to be converted to your
     * desired value.
     */
    COPPER("CP", "Copper", 1),
    /**
     * Silver is the second lowest denomination of currency. Silver is abbreviated as "SP". One
     * silver piece equals 10 copper pieces.
     */
    SILVER("SP", "Silver", 10),
    /**
     * Gold is nearly the standard unit of measure. Gold is abbreviated as "GP." pieces. Most items
     * are sold in Gold currency. One gold piece is worth 100 copper pieces.
     */
    GOLD("GP", "Gold", 100),
    /**
     * Electrum is fairly scarce in DCC. Electrum is abbreviated as "EP." One electrum equals 1,000
     * copper pieces.
     */
    ELECTRUM("EP", "Electrum", 1000),
    /**
     * Platinum is very rare in DCC. Platinum is abbreviated as "PP." One platinum piece equals
     * 10,000 copper pieces.
     */
    PLATINUM("PP", "Platinum", 10000);

    /**
     * An abbreviation used to represent the itemType of currency. For example copper is abbreviated as
     * "CP" for copper pieces.
     */
    private String abbreviation;

    /**
     * A word to describe the currency itemType. For example, copper's name is "Copper"
     */
    private String name;

    /**
     * An integer value which represents the unit of conversion between the currency types. This
     * value is based on the value of copper. For example Electrum multiplicator is 1,000 which
     * means 1 EP is worth 1,000 CP.
     */
    private int multiplicator;

    /**
     * Constructor
     *
     * @param abbreviation the abbreviation of the currency itemType which is two characters
     * @param name the representation of the currency in the form of a word
     * @param multiplicator an int value which represents the unit of conversion between currencies
     */
    Type(String abbreviation, String name, int multiplicator) {
      this.abbreviation = abbreviation;
      this.name = name;
      this.multiplicator = multiplicator;
    }

    /**
     * Returns the representation of the currency in the form of two letters. For example, "CP" for
     * copper pieces.
     *
     * @return the currency abbreviation
     */
    public final String getAbbreviation() {
      return abbreviation;
    }

    /**
     * Returns the representation of the currency in the form of a word. For example, "Copper"
     *
     * @return the name of the currency as a word
     */
    public final String getName() {
      return name;
    }

    /**
     * Returns the int multiplicator used to convert this currency to another
     * @return the value of the multiplicator
     */
    public int getMultiplicator() {
      return multiplicator;
    }
  }

  /**
   * Converts an amount from a currency to another currency using the multiplier
   *
   * @param amount the original amount to be converted
   * @param from the currency to convert from (the original currency)
   * @param to the currency to conver to (the destination currency)
   * @return the amount of the new currency
   */
  public static double convert(double amount, DCCCurrency from, DCCCurrency to) {
    double basePrice = amount * from.getMultiplier();
    return basePrice / to.getMultiplier();
  }

  /**
   * Returns the name of the currency, in the form of a word.
   *
   * @return the currency name as a word.
   */
  final String getName() {
    return name.get();
  }

  /**
   * Returns a string property of the currency. Will be used in the user interface.
   *
   * @return the StringProperty
   */
  public final ReadOnlyStringProperty nameProperty() {
    return name.getReadOnlyProperty();
  }

  /**
   * Sets the name of the currency.
   *
   * @param name to be set
   */
  private void setName(String name) {
    this.name.set(name);
  }

  /**
   * Returns the value used to convert one currency to another
   *
   * @return an {@code int} value
   */
  int getMultiplier() {
    return multiplier;
  }

  /**
   * Returns the abbreviated form of the Currency. Comes in the form of two letters.
   *
   * @return the currency abbreviation, as two letters.
   */
  String getAbbreviation() {
    return abbreviation.get();
  }

  /**
   * Returns the StringProperty of the currency abbreviation. Will be used in the user interface.
   *
   * @return the StringProperty of the abbreviation
   */
  public ReadOnlyStringProperty abbreviationProperty() {
    return abbreviation.getReadOnlyProperty();
  }

  /**
   * Sets the value of the currency abbreviation
   *
   * @param abbreviation to be set
   */
  private void setAbbreviation(String abbreviation) {
    this.abbreviation.set(abbreviation);
  }

  /**
   * Returns the {@code int} value of the currency currenly in the characters possession
   *
   * @return the amount of the specific currency
   */
  public int getAmount() {
    return amount.get();
  }

  /**
   * Returns an IntegerProperty of the amount of specific currency. Will be displayed in the user
   * interface.
   *
   * @return the IntegerProperty of the amount.
   */
  public ReadOnlyIntegerProperty amountProperty() {
    return amount.getReadOnlyProperty();
  }

  /**
   * Sets the amount of specific currency currently in the characters possession.
   *
   * @param amount to be set
   */
  public void setAmount(int amount) {
    this.amount.set(amount);
  }

  /**
   * Returns the StringProperty of the currency description
   *
   * @return the description StringProperty
   */
  public ReadOnlyStringProperty descriptionProperty() {
    return description.getReadOnlyProperty();
  }

}