package com.frijolie.dcc.model.inventory;

/**
 * <p>Ammunition represents a single piece of ammunition that is utilized in application</p>
 *
 * <p>Ammo is not typically sold individually. You don't buy a single throwing stone or a single
 * quarrel. They are traditionally sold in bunches. For example, 20 arrows or 30 sling stones. The
 * only exception is a silver-tipped arrow. These are sold individually.</p>
 *
 * <p>This is also used as a blueprint when deserializing ammunition.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class Ammunition extends Item {

  /**
   * The quantity of ammo. Sold in bunches.
   */
  private int quantity;

  /**
   * Constructor.
   *
   * @param name of the ammo to set.
   */
  Ammunition(String name, int quantity) {
    super(name);
    this.quantity = quantity;
  }

  /**
   * Returns the quantity of the bundle of ammo.
   *
   * @return the quantity
   */
  int getQuantity() {
    return quantity;
  }

  /**
   * Mutator method to set the quantity of the bundle
   *
   * @param quantity to be set
   */
  void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}