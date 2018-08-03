package com.frijolie.dcc.model.inventory;

import java.util.Objects;

/**
 * <p>Occupation represents a character's occupation in the application.</p>
 *
 * <p>Every character will be given a random occupation. This occupation will grant the character a
 * list of trained weapons as well as a single pre-defined trade good.</p>
 *
 * <p>This class is used as a blueprint for occupation deserialization</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class Occupation {

  /**
   * The name of the occupation
   */
  private String name;

  /**
   * A list of trained weapons given by the chosen occupation.
   */
  private Weapon startingWeapon;

  /**
   * Trade good given by the chosen occupation. Trade Goods will not always be "standard"
   * equipment.
   */
  private Item tradeGood;

  /**
   * Constructor.
   *
   * @param name to be given to the occupation
   */
  public Occupation(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the occupation
   *
   * @return name of the occupation
   */
  public String getName() {
    return name;
  }

  /**
   * Mutator method to set the name of the occupation
   *
   * @param name to be set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the trained weapon of this occupation
   *
   * @return the weapon that is trained by this occupation
   */
  public Weapon getStartingWeapon() {
    return startingWeapon;
  }

  /**
   * Mutator method to add a trained weapon
   *
   * @param weapon to be added to the list
   * @throws NullPointerException if the weapon arg is null
   */
  public final void setStartingWeapon(Weapon weapon) {
    Objects.requireNonNull(weapon,
        "You cannot add a weapon to the trained weapon list if it is null");
    startingWeapon = weapon;
  }

  /**
   * Returns the good that is given by this occupation. May not be standard equipment.
   *
   * @return the trade good given by this occupation
   */
  public Item getTradeGood() {
    return tradeGood;
  }

  /**
   * Mutator method. Sets the trade good by the occupation.
   *
   * @param tradeGood to be set
   */
  public void addTradeGood(Item tradeGood) {
    this.tradeGood = tradeGood;
  }

}