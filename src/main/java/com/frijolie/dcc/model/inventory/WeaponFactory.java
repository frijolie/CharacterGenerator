package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.io.WeaponSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class WeaponFactory {

  private static List<Weapon> weaponList;

  static {
    weaponList = new ArrayList<>(new WeaponSerializer().getWeaponList());
  }

  public static Weapon getByName(String weaponName) {
    Objects.requireNonNull(weaponName,
        "You must pass a weaponName for a weapon to be retrieved.");
    Weapon weapon = weaponList.stream()
        .filter(e -> e.getName().contains(weaponName))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException(weaponName
            + " is not a valid weapon. It cannot be retrieved"));
    try {
      return weapon.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }

}