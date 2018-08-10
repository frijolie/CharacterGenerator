package com.frijolie.dcc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * <p>LuckyRoll is a class used to calculate a characters Birth Augur.</p>
 *
 * <p>The birth augur is a benefit granted to the user based on a random roll of dice. The result
 * of the roll determines a special ability that is given to the character. This is amplified by the
 * characters luck modifier. A birth augur may also come at a penalty to something if the character
 * has a negative luck modifier</p>
 *
 * <p>It is possible that this trait becomes worthless as it is not used by the character. For
 * example, a birth augur may be given that grants bonuses to spell casting and the character has
 * chosen a warrior class (which does not use magic).</p>
 *
 * <p>The birth augurs are stored in a Map which is initialized in a static block.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class LuckyRoll {

  /**
   * A map used to retrieve the birth augur. The birth augur (map value) is determined by a random
   * roll of dice and retrieved by the int value (map key).
   */
  private static Map<Integer, String> luckyRollTable;
  /**
   * The int result of the random roll of dice. It is read-only because it is only meant to be
   * displayed in the user interface and not modified by the user.
   */
  private ReadOnlyIntegerWrapper rollResult;
  /**
   * The read-only property of the birth augur. Birth augur is determined by the result of the lucky
   * roll. It is read-only because it is a computed value and not meant to be modified by the user.
   * It will be displayed in the "notes" section of the character sheet.
   */
  private ReadOnlyStringWrapper birthAugur;

  static {
    luckyRollTable = new HashMap<>();
    luckyRollTable.put(1, "Lucky Sign: Harsh winter: All attack rolls");
    luckyRollTable.put(2, "Lucky Sign: The bull: Melee attack rolls");
    luckyRollTable.put(3, "Lucky Sign: Fortunate date: Missile fire attack rolls");
    luckyRollTable.put(4, "Lucky Sign: Raised by wolves: Unarmed attack rolls");
    luckyRollTable.put(5, "Lucky Sign: Conceived on horseback: Mounted attack rolls");
    luckyRollTable.put(6, "Lucky Sign: Born on the battlefield: Damage rolls");
    luckyRollTable.put(7, "Lucky Sign: Path of the bear: Melee damage rolls");
    luckyRollTable.put(8, "Lucky Sign: Hawkeye: Missile fire damage rolls");
    luckyRollTable.put(9, "Lucky Sign: Pack hunter: ATK and DAM rolls for 0-lvl weapon");
    luckyRollTable.put(10, "Lucky Sign: Born under the loom: Skill checks (including thief)");
    luckyRollTable.put(11, "Lucky Sign: Fox’s cunning: Find and disable traps");
    luckyRollTable.put(12, "Lucky Sign: Four-leafed clover: Find secret doors");
    luckyRollTable.put(13, "Lucky Sign: Seventh son: Spell checks");
    luckyRollTable.put(14, "Lucky Sign: The raging storm: Spell damage");
    luckyRollTable.put(15, "Lucky Sign: Righteous heart: Turn unholy checks");
    luckyRollTable.put(16, "Lucky Sign: Survived the plague: Magical healing*");
    luckyRollTable.put(17, "Lucky Sign: Lucky sign: Saving throws");
    luckyRollTable.put(18, "Lucky Sign: Guardian angel: Savings throws to escape traps");
    luckyRollTable.put(19, "Lucky Sign: Survived a spider bite: Saving throws against poison");
    luckyRollTable.put(20, "Lucky Sign: Struck by lightning: Reflex saving throws");
    luckyRollTable.put(21, "Lucky Sign: Lived through famine: Fortitude saving throws");
    luckyRollTable.put(22, "Lucky Sign: Resisted temptation: Willpower saving throws");
    luckyRollTable.put(23, "Lucky Sign: Charmed house: Armor Class");
    luckyRollTable.put(24, "Lucky Sign: Speed of the cobra: Initiative");
    luckyRollTable.put(25, "Lucky Sign: Bountiful harvest: Hit points (applies at each level)");
    luckyRollTable.put(26, "Lucky Sign: Warrior’s arm: Critical hit tables**");
    luckyRollTable.put(27, "Lucky Sign: Unholy house: Corruption rolls");
    luckyRollTable.put(28, "Lucky Sign: The Broken Star: Fumbles**");
    luckyRollTable.put(29, "Lucky Sign: Birdsong: Number of languages");
    luckyRollTable.put(30, "Lucky Sign: Wild child: Speed (each +1/-1 = +5’/-5’ speed)");
  }

  /**
   * Zero argument constructor.
   */
  LuckyRoll() {
    rollResult = new ReadOnlyIntegerWrapper(0);
    birthAugur = new ReadOnlyStringWrapper();
  }

  /**
   * Calculates the birth augur by simulating a 1d30 roll. Retrieves and sets the birth augur based
   * on the result of the roll from the map.
   */
  void calculateLuckyRoll() {
    rollResult.set(DiceRoller.rollDice(1, 30));
    setBirthAugur(luckyRollTable.get(getRollResult()));
  }

  /**
   * Returns the result, as an int, of the random roll of the dice.
   * @return the result of the random roll of dice
   */
  public int getRollResult() {
    return rollResult.get();
  }

  /**
   * Returns the read-only property that represents the random roll of dice
   * @return the read-only property of the random roll
   */
  public ReadOnlyIntegerProperty rollResultProperty() {
    return rollResult.getReadOnlyProperty();
  }

  /**
   * Returns the birth augur as a String
   * @return the birth augur
   */
  String getBirthAugur() {
    return birthAugur.get();
  }

  /**
   * Sets the value of the birth augur.
   * @param phrase to be set
   * @throws NullPointerException if the phrase is null
   */
  private void setBirthAugur(String phrase) {
    Objects.requireNonNull(phrase,
        "You must pass a non-null phrase to birthAugur. It cannot be null");
    birthAugur.set(phrase);
  }

  /**
   * Returns the read-only string property of the birth augur.
   * @return the read-only property
   */
  public ReadOnlyStringProperty birthAugurProperty() {
    return birthAugur.getReadOnlyProperty();
  }
}