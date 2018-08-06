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
   * Determines if this weapon is ONE_HANDED or TWO_HANDED
   */
  Wield wield;

  /**
   * The type of weapon. Values are: Melee, Ranged, or Both. This is used for deserialization.
   */
  Type type;

  /**
   * Speical notes about this weapon. For example, "this weapon does 3x damage when used in mounted
   * combat"
   */
  List<String> notes;

  /**
   * For deserialization, a zero-arg constructor.
   */
  public Weapon() {
  }

  /**
   * Constructor.
   *
   * @param name to be set
   */
  public Weapon(final String name) {
    super(name);
    notes = new ArrayList<>();
  }

  /**
   * Returns the weapon type. Values are: Melee, Ranged, or Both (ranged and melee)
   * @return the weapon type
   */
  public Type getType() {
    return type;
  }

  /**
   * Sets the weapon type from the enum constant.
   * @param type to be set
   */
  public void setType(final Type type) {
    this.type = type;
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

    // weapons are equal if the type and names are the same
    return type == weapon.getType() && name.equals(weapon.getName());
  }

  /**
   * Returns a list of all the the notes on this weapon.
   *
   * @return this weapons notes
   */
  public List<String> getNotes() {
    return new ArrayList<>(notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
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