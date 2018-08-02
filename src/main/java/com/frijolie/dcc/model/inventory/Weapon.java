package com.frijolie.dcc.model.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Weapon represents a single weapon used in the application.</p>
 *
 * <p>A weapon has several attributes.</p>
 */
public class Weapon extends Item implements Cloneable {

  /**
   * Determines if this weapon is ONE_HANDED or TWO_HANDED
   */
  private Wield wield;

  /**
   * The die which is used to determine the amount of damage this weapon will deal in melee, also
   * known as hand-to-hand, combat. For example, 1d8 (you would roll 1 eight-sided die).
   */
  private String meleeDamageRoll;

  /**
   * The die which is used to determine the amount of damage this weapon will deal in ranged combat.
   * For example, a thrown dagger uses a 1d10 (you would roll 1 ten-sided die)
   */
  private String rangedDamageRoll;

  /**
   * Speical notes about this weapon. For example, "this weapon does 3x damage when used in mounted
   * combat"
   */
  private List<String> notes;

  /**
   * Is true if this weapon can be used in ranged combat.
   */
  private boolean isRanged;

  /**
   * The amount of distance this weapon can be used if ranged. Will be three values separated by a
   * forward slash '/'. They represent short, medium, and long range distances. For example,
   * 20/40/60
   */
  private String range;

  public Weapon() {
    this("");
  }

  public Weapon(String name) {
    super(name);
    notes = new ArrayList<>();
  }

  /**
   * Enumeration of all possible weapon wield values. They are ONE_HANDED and TWO_HANDED
   */
  public enum Wield {
    ONE_HANDED, TWO_HANDED
  }

  /**
   * Returns the die you roll to determine the amount of damage this weapon deals in melee combat
   *
   * @return the die to determine melee damage for this weapon. For example, "2d10"
   */
  public String getMeleeDamageRoll() {
    return meleeDamageRoll;
  }

  /**
   * Sets the die needed to determine melee damage for this weapon.
   *
   * @param meleeDamageRoll the die to set
   */
  public void setMeleeDamageRoll(String meleeDamageRoll) {
    this.meleeDamageRoll = meleeDamageRoll;
  }

  /**
   * Returns the die needed to determine ranged damage for this weapon.
   *
   * @return the die to determine ranged damage
   */
  public String getRangedDamageRoll() {
    return rangedDamageRoll;
  }

  /**
   * Sets the die for this weapons ranged damage
   *
   * @param rangedDamageRoll the die to set
   */
  public void setRangedDamageRoll(String rangedDamageRoll) {
    this.rangedDamageRoll = rangedDamageRoll;
  }

  /**
   * Returns true if this weapon can be used in ranged combat. Not all weapons can.
   *
   * @return {@code true} if this weapon can be used in ranged combat.
   */
  public boolean isRanged() {
    return isRanged;
  }

  /**
   * Sets the value for isRanged
   *
   * @param ranged true if can be thrown or used in ranged combat.
   */
  public void setIsRanged(boolean ranged) {
    isRanged = ranged;
  }

  /**
   * Returns a string value to represent short, medium, and long ranged distances.
   *
   * @return a string of ranged distances
   */
  public String getRange() {
    return range;
  }

  /**
   * Sets the value of ranged distances for this weapon
   *
   * @param range the value of ranged distance
   */
  public void setRange(String range) {
    this.range = range;
  }

  /**
   * Returns ONE_HANDED or TWO_HANDED
   *
   * @return the weapon wield value
   */
  public Wield getWield() {
    return wield;
  }

  /**
   * Sets the weapons wield value;
   *
   * @param wield the value to set
   */
  public void setWield(Wield wield) {
    this.wield = wield;
  }

  /**
   * Returns a list of all the the notes on this weapon.
   *
   * @return this weapons notes
   */
  public List<String> getNotes() {
    return new ArrayList<>(notes);
  }

  /**
   * Adds a note to this weapon if it doesn't already exist.
   *
   * @param note to be set
   */
  public void addNotes(String note) {
    if (notes.stream().noneMatch(s -> s.equals(note))) {
      notes.add(note);
    }
  }

  public void addNotes(List<String> notes) {
    notes.addAll(notes);
  }

  @Override
  public Weapon clone() throws CloneNotSupportedException {
    return (Weapon) super.clone();
  }

}