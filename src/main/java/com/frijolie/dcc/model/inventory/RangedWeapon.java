package com.frijolie.dcc.model.inventory;

public class RangedWeapon extends Weapon implements Ranged {

  /**
   * The amount of distance this weapon can be used if ranged. Will be three values separated by a
   * forward slash '/'. They represent short, medium, and long range distances. For example,
   * 20/40/60
   */
  private String range;

  private String rangedDamage;

  /**
   * For deserialization, a zero-arg constructor.
   */
  public RangedWeapon() {
  }

  public RangedWeapon(String name) {
    super(name);
  }

  @Override
  public String getRangedDamage() {
    return rangedDamage;
  }

  public void setRangedDamage(String damage) {
    rangedDamage = damage;
  }

  @Override
  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

}
