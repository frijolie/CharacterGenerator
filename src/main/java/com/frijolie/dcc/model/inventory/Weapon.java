package com.frijolie.dcc.model.inventory;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>Weapon represents a single weapon used in the application.</p>
 *
 * <p>A weapon has several attributes.</p>
 */
public abstract class Weapon extends Item {

  /**
   * Speical notes about this weapon. For example, "this weapon does 3x damage when used in mounted
   * combat"
   */
  List<String> notes;

  /**
   * Determines if this weapon is ONE_HANDED or TWO_HANDED
   */
  Wield wield;
  /**
   * The itemType of weapon. Values are: Melee, Ranged, or Both. This is used for deserialization.
   */
  Type weaponType;

  /**
   * Constructor.
   *
   * @param name to be set
   */
  public Weapon(final String name) {
    this.name = name;
    itemType = Item.Type.WEAPON;
    notes = new ArrayList<>();
  }

  /**
   * Returns the weapon itemType. Values are: Melee, Ranged, or Both (ranged and melee)
   * @return the weapon itemType
   */
  public Type getWeaponType() {
    return weaponType;
  }

  /**
   * For deserialization, a zero-arg constructor.
   */
  public Weapon() {
  }

  /**
   * Sets the weapon itemType from the enum constant.
   *
   * @param weaponType to be set
   */
  public void setWeaponType(final Type weaponType) {
    this.weaponType = weaponType;
  }

  public abstract String getDamage();

  /**
   * Returns a list of all the the notes on this weapon.
   *
   * @return this weapons notes
   */
  public List<String> getNotes() {
    return new ArrayList<>(notes);
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
  public void setWield(final Wield wield) {
    this.wield = wield;
  }

  /**
   * Adds a note to this weapon if it doesn't already exist.
   *
   * @param note to be set
   */
  public void addNotes(final String note) {
    if (notes.stream().noneMatch(s -> s.equals(note))) {
      notes.add(note);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Weapon weapon = (Weapon) o;

    // weapons are equal if the itemType and names are the same
    return weaponType == weapon.getWeaponType() && name.equals(weapon.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, weaponType);
  }

  /**
   * Enumeration of all possible weapon wield values. They are ONE_HANDED and TWO_HANDED
   */
  public enum Wield {
    ONE_HANDED,
    TWO_HANDED
  }

  public enum Type {
    @SerializedName("RANGED") RANGED,
    @SerializedName("MELEE") MELEE,
    @SerializedName("BOTH") BOTH
  }

}