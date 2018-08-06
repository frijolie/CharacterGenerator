package com.frijolie.dcc.model.inventory;

public interface Ranged {

  /**
   * Returns a string value to represent short, medium, and long ranged distances.
   *
   * @return a string of ranged distances
   */
  String getRange();

  String getRangedDamage();

}