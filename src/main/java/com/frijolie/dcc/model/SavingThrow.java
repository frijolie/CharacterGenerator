package com.frijolie.dcc.model;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

/**
 * <p>A saving throw represents a bonus or penalty given to a player when making checks to actions.
 * </p>
 *
 * <p>Saving throws are highly dependent on an ability modifier value. Therefore, a modifier value
 * must be passed at instantiation.</p>
 *
 * <p>There are three types of saving throws. Each are dependent on a specific modifier value:</p>
 * <ol>
 *   <li>Reflex Save (Agility Modifier)</li>
 *   <li>Willpower Save (Personality Modifier)</li>
 *   <li>Fortitude Save (Stamina Modifier)</li>
 * </ol>
 *
 * <p>For more information on saving throws, see Dungeon Crawl Classics Core Rule Book (DCCCRB), 4
 * <sup>th</sup> edition, p.20</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class SavingThrow {

  /**
   * A read-only property meant to represent the value of the savingThrow. This will be displayed in
   * the user interface. It is a computed value and is not meant to be modified by the user,
   * therefore it is read-only.
   */
  private ReadOnlyIntegerWrapper savingThrow;

  /**
   * Constructor. Must pass an ability modifier value.
   *
   * @param modifier to be set
   */
  SavingThrow(int modifier) {
    savingThrow = new ReadOnlyIntegerWrapper(modifier);
  }

  /**
   * Returns the int value of the saving throw.
   *
   * @return the saving throw value
   */
  public final int getSavingThrow() {
    return savingThrow.get();
  }

  /**
   * Returns the read-only integer property of the saving throw
   *
   * @return the read-only property
   */
  public final ReadOnlyIntegerProperty savingThrowProperty() {
    return savingThrow.getReadOnlyProperty();
  }

  /**
   * Sets the value of the saving throw.
   *
   * @param value to be set
   */
  void setSavingThrow(int value) {
    // TODO does the value arg need to be validated?
    this.savingThrow.set(value);
  }
}