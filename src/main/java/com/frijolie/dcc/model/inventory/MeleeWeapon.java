package com.frijolie.dcc.model.inventory;

public class MeleeWeapon extends Weapon implements Melee {

  private String meleeDamage;

  /**
   * For deserialization, a zero-arg constructor.
   */
  public MeleeWeapon() {
  }

  public MeleeWeapon(String name) {
    super(name);
  }

  @Override
  public String getMeleeDamage() {
    return meleeDamage;
  }

  public void setMeleeDamage(String damage) {
    meleeDamage = damage;
  }

}
