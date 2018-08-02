package com.frijolie.dcc.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * <p>
 * AbilityScore represents a value which is attributed to one of six character attributes: Strength,
 * Stamina, Agility, Luck, Personality, and Intelligence. The values of these attributes are
 * determined when the character is first created by simulating a roll of 3d6 (3 six-sided dice).
 * These are the most important values for a character as many other attributes are based on these
 * values.
 * </p>
 * <p>
 * For more information on the AbilityScores see Dungeon Crawl Classics Core Rule Book (DCCCRB) p.18
 * </p>
 * @author Frijolie
 * @version 0.1
 */
public class AbilityScore {

  /**
   * The IntegerProperty of the abilityScore. This property will be used in the user interface.
   */
  private IntegerProperty score;

  /**
   * Default zero-arg constructor.
   */
  AbilityScore() {
    score = new SimpleIntegerProperty(0);
  }

  /**
   * Returns the int value of the ability score.
   *
   * @return the value of the ability score as an int.
   */
  final int getScore() {
    return score.get();
  }

  /**
   * Returns the ability score IntegerProperty.
   *
   * @return the ability score property
   */
  public final IntegerProperty scoreProperty() {
    return score;
  }

  /**
   * Sets the abilityScore value. The value must be between 3 and 18 (inclusive).
   *
   * @param score to be set
   * @throws IllegalArgumentException if the value is not between 3 and 18 (inclusive).
   */
  final void setScore(int score) {
    if (score >= 3 && score <= 18) {
      this.score.set(score);
    } else {
      throw new IllegalArgumentException(score +
          " is not a valid ability score. An ability score must be between 3 and 18");
    }
  }

  /**
   * Calculates the value of the AbilityScore. This is determined by a simulated roll of 3d6. See
   * Dungeon Crawl Classics Core Rule Book (DCCCRB) p.18
   */
  final void calculateAbilityScore() {
    setScore(DiceRoller.rollDice(3, 6));
  }
}