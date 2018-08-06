package com.frijolie.dcc.model.inventory;

public class MeleeRangedWeapon extends Weapon implements Ranged, Melee {

  private String meleeDamage;
  private String rangedDamage;
  private String range;

  /**
   * For deserialization, a zero-arg constructor.
   */
  public MeleeRangedWeapon() {
  }

  public MeleeRangedWeapon(String name) {
    super(name);
  }

  @Override
  public String getMeleeDamage() {
    return meleeDamage;
  }

  public void setMeleeDamage(String damage) {
    meleeDamage = damage;
  }

  @Override
  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  @Override
  public String getRangedDamage() {
    return rangedDamage;
  }

  public void setRangedDamage(String damage) {
    rangedDamage = damage;
  }

}