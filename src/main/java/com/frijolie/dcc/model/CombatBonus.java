package com.frijolie.dcc.model;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

/**
 * <p>CombatBonus represents a bonus (or penalty) that is applied to an action roll.</p>
 *
 * <p>There are four types of combat bonuses: melee attack, melee damage, missile attack, and
 * missile damage. If the CombatBonus value is positive, then it is a bonus. If it is negative then
 * it is a penalty. When attacking an enemy, you apply the attack combat bonus to your attack roll.
 * If your attack succeeds you add the damage bonus (or penalty) to the damage roll.</p>
 *
 * <p>The attack and damage rolls are dependent on your character class and level. 0-level
 * characters have no bonuses (or penalties).</p>
 *
 * <p>For more information see Dungeon Crawl Classics Core Rule Book (DCCCRB), 4<sup>th</sup>
 * edition.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class CombatBonus {

  /**
   * The value of the combat bonus (or penalty). This value will be displayed in the user interface.
   * It is read-only because this value is computed and not intended to be modified by the user.
   */
  private ReadOnlyIntegerWrapper bonus;

  /**
   * Default zero argument constructor.
   */
  CombatBonus() {
    bonus = new ReadOnlyIntegerWrapper(0);
  }

  /**
   * Returns the value of the combat bonus.
   *
   * @return the combat bonus value as an {@code int}
   */
  int getBonus() {
    return bonus.get();
  }

  /**
   * Returns the ReadOnlyIntegerProperty of the combat bonus
   *
   * @return the read-only property
   */
  public ReadOnlyIntegerProperty bonusProperty() {
    return bonus.getReadOnlyProperty();
  }

  /**
   * Sets the value of the combat bonus. This is normally an ability modifier
   *
   * @param bonus to be set
   */
  void setBonus(int bonus) {
    this.bonus.set(bonus);
  }

}