package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.io.WeaponDeserializer;
import com.frijolie.dcc.io.WeaponSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <p>WeaponFactory is a factory class used to supply a Weapon to the calling method.</p>
 *
 * <p>WeaponFactory maintains a list of all possible Weapons used in the application. It provides
 * two utility methods to retrieve a Weapon. They can be retrieved via a Map (by index) or from a
 * List (by name).</p>
 *
 * <p>Currently the list is populated by hard coded objects and is not dynamic. As a future
 * enhancement, it would be nice if this was done via some sort of I/O process. I already have the
 * weapons in a JSON file, conveniently named 'weapons.json'. I have experimented reading and
 * populating with this and failed. Therefore, I have shelved it for the time being.</p>
 *
 * <p>The collection which contains the Weapons that are intended to be accessed by name are
 * initialized in a static block.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class WeaponFactory {

  /**
   * A list of Weapons. Currently populated by {@link WeaponSerializer#getWeaponList()}
   */
  private static List<Weapon> weaponList;
  private static Gson gson;
  private static GsonBuilder builder;

  static {
    weaponList = new ArrayList<>(new WeaponSerializer().getWeaponList());
    builder = new GsonBuilder();
    builder.registerTypeAdapter(Weapon.class, new WeaponDeserializer());
    gson = builder.create();
  }

  /**
   * Returns a newly deserialized (deep copy) of a Weapon accessed by name. The comparison is made
   * using {@code contains()} so you do not have to supply the exact string.
   *
   * @param weaponName the name of the weapon to be retrieved
   * @return a Weapon matching the name arg
   * @throws NullPointerException if the weaponName param is {@code null}
   * @throws NoSuchElementException if the weaponName could not be found in the collection
   */
  public static Weapon getByName(String weaponName) {
    Objects.requireNonNull(weaponName,
        "You must pass a weaponName for a weapon to be retrieved.");
    Weapon weapon = weaponList.stream()
        .filter(w -> w.getName().contains(weaponName))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException(weaponName
            + " is not a valid weapon. It cannot be retrieved"));

    // serializing and de-serializing to provide a deep copy.
    // many weapon names are modified when provided as a starting weapon. e.g. Hammer (as club)
    String weaponJson = gson.toJson(weapon);
    return gson.fromJson(weaponJson, Weapon.class);
  }

}