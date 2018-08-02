package com.frijolie.dcc.model.inventory;

/**
 * <p>Item represents a single item in Dungeon Crawl Classics.</p>
 *
 * <p>An item is something that is not a defined piece of equipment, weapon, ammunition, armor, or
 * mounted gear. Most of these will be special items granted to a character as a trade good.</p>
 *
 * <p>Note: ALL COST VALUES ARE SET IN COPPER DENOMINATION</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class Item {

  /**
   * The name of the item, represented by a word.
   */
  String name;
  /**
   * The cost of the item in copper pieces (CP)
   */
  double costInCopper;

  /**
   * Constructor. Must pass the name of the item.
   *
   * @param name to be set
   */
  public Item(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the item
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the item.
   *
   * @param name to be set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the cost of this item in copper currency.
   *
   * @return the cost of this item
   */
  public double getCostInCopper() {
    return costInCopper;
  }

  /**
   * Sets the cost of this item in copper pieces
   *
   * @param costInCopper the amount to be set
   */
  public void setCostInCopper(double costInCopper) {
    this.costInCopper = costInCopper;
  }

}