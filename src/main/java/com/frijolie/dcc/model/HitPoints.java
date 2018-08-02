package com.frijolie.dcc.model;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

/**
 * <p>HitPoints represents the breadth of vitality a character possesses. The higher the hit points
 * the more damage they may resist before perishing</p>
 *
 * <p>Every character must have at least one hit point. Hit points are influenced by character
 * level as well as character class. Each class earns a different amount (of dice) per level.
 * 0-Level characters begin with 1d4 + staminaMod hit points.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class HitPoints {

  /**
   * The total number of hit points a character possesses. It is read-only because it is a computed
   * value and is not meant to be modified by the user.
   */
  private ReadOnlyIntegerWrapper hitPoints;

  /**
   * Zero argument constructor.
   */
  HitPoints() {
    hitPoints = new ReadOnlyIntegerWrapper();
  }

  /**
   * Calculates the number of hit points for the character. To calculate you  must pass the stamina
   * modifier as well as any bonus granted by the character class and level.
   */
  void calculateHitPoints(int staminaMod, int classBonus) {
    var zeroLevelHP = DiceRoller.rollDice(1, 4);
    var temp = zeroLevelHP + staminaMod + classBonus;
    // characters have to at least have 1 hit point
    if (temp < 1) {
      setHitPoints(1);
    } else {
      setHitPoints(temp);
    }
  }

  /**
   * Returns the int value of the characters hit points.
   *
   * @return the value of hit points, as an int
   */
  int getHitPoints() {
    return hitPoints.get();
  }

  /**
   * Sets the value of the characters hit points.
   *
   * @param value to be set
   */
  void setHitPoints(int value) {
    hitPoints.set(value);
  }

  /**
   * Returns the read-only property of hit points
   *
   * @return the hit point read-only property
   */
  public ReadOnlyIntegerProperty hitPointsProperty() {
    return hitPoints.getReadOnlyProperty();
  }

}