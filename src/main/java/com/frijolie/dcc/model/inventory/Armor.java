package com.frijolie.dcc.model.inventory;

import java.util.Objects;

/**
 * <p>This class represents a single piece of armor that is utilized in the application.</p>
 *
 * <p>When a character equips armor this raises their armor class (makes it harder to do physical
 * damage). However, it also hinders their movement. When a characters movement is hindered, they
 * cannot walk as fast, they cannot maneuver as fast, and they have increasingly negative affects
 * when they fumble an attack.</p>
 *
 * <p>There are many attributes, or traits, that a suit of armor possesses. In Dungeon Crawl
 * Classics, they are: Armor Class (AC) Bonus, Check Penalty, Speed Penalty, and Fumble Die.</p>
 *
 * <p><i>Armor Class Bonus</i> - Armor class in DCC determines how difficult it is for a character to take
 * damage. The higher the armor class, the more difficult it becomes.</p>
 *
 * <p><i>Check Penalty</i> - Some armor is bulky, ill-fitting, and inflexible. Warriors that wear this
 * armor find that the weight and bulkiness inhibits their ability to jump chasms. Thieves feel a
 * difference when they scale walls, Wizards find it hard to trace runes correctly, and the high
 * iron content interferes with their spellcasting ability. The check penalty applies to checks to
 * climb, jump, balance, swim, move silently, and other physical activities.</p>
 *
 * <p><i>Speed Penalty</i> - This value represents the amount of feet that is reduced from the characters
 * normal walking speed. For example, a -5 speed penalty represents that the character can walk 5
 * fewer feet, over the same time period, than their normal walking stride. This is due to the
 * weight and bulkiness of the equipped armor</p>
 *
 * <p><i>Fumble Die</i> - Heavy armor is clumsy and awkward. When a fumble occurs, characters wearing
 * heavy armor tend to be affected more significantly.</p>
 *
 * <p>This is also used as a blueprint for deserialization</p>
 *
 * @author Frijolie
 * @version 0.1
 **/
public class Armor extends Item {

  /**
   * The bonus, if any, that is applied to your current Armor Class if the armor is equipped.
   */
  private int acBonus;

  /**
   * The penalty, if any, that is applied to your checks if the armor is equipped.
   */
  private int checkPenalty;

  /**
   * The penalty to Speed, if any, that is applied to your current speed if the armor is equipped
   */
  private int speedPenalty;

  /**
   * The fumble die that is used when the character rolls a fumble when wearing this armor
   */
  private String fumbleDie;

  /**
   * For deserialization, a zero-arg constructor.
   */
  private Armor() {
    this("", 0.0);
  }

  /**
   * Constructor.
   *
   * @param name to be set
   * @param costInCopper the cost of this armor in copper pieces (CP)
   */
  public Armor(String name, double costInCopper) {
    this.name = name;
    this.costInCopper = costInCopper;
    if (name.equals("Shield")) {
      itemType = Type.SHIELD;
    } else {
      itemType = Type.ARMOR;
    }
  }

  /**
   * Returns the bonus which is applied to your Armor Class
   *
   * @return an int value
   */
  public int getAcBonus() {
    return acBonus;
  }

  /**
   * Mutator method to set the bonus to armor class, if any.
   *
   * @param acBonus to set
   */
  public void setAcBonus(int acBonus) {
    this.acBonus = acBonus;
  }

  /**
   * Returns an int value which represents the penalty to checks if the armor is worn
   *
   * @return an int value
   */
  public int getCheckPenalty() {
    return checkPenalty;
  }

  /**
   * Mutator method to set the amount of penalty to checks if the armor is worn
   *
   * @param checkPenalty to set
   */
  public void setCheckPenalty(int checkPenalty) {
    this.checkPenalty = checkPenalty;
  }

  /**
   * Returns the penalty to speed if the armor is equipped
   *
   * @return an int value
   */
  public int getSpeedPenalty() {
    return speedPenalty;
  }

  /**
   * Mutator method to set the penalty to the characters speed should the armor be equipped
   *
   * @param speedPenalty to be set
   */
  public void setSpeedPenalty(int speedPenalty) {
    this.speedPenalty = speedPenalty;
  }

  /**
   * Returns a string to represent the die used when a character rolls a fumble. For example, d8
   *
   * @return a String
   */
  public String getFumbleDie() {
    return fumbleDie;
  }

  /**
   * Mutator method to set the fumble die used when a character rolls a fumble
   *
   * @param fumbleDie to set
   */
  public void setFumbleDie(String fumbleDie) {
    this.fumbleDie = fumbleDie;
  }

  /**
   * A piece of armor is equal if both their names and types are equal
   *
   * @param obj the object in comparison
   * @return {@code true} if they are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Armor)) {
      return false;
    }
    Armor armor = (Armor) obj;
    return getName().equals(armor.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name + " {" +
        "acBonus: " + acBonus +
        "; checkPenalty: " + checkPenalty +
        "; speedPenalty: " + speedPenalty +
        "; fumbleDie: '" + fumbleDie + '\'' +
        "; costInCopper: " + costInCopper + '}';
  }

}