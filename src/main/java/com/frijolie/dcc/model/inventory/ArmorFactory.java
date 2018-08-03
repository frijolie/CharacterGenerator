package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.io.ArmorSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <p>ArmorFactory is a utility class used to provide armor to various other classes.</p>
 *
 * <p>ArmorFactory maintains an inventory of all armor used in the application. It is stored in a
 * collection and provides methods for them to be retrieved.</p>
 *
 * <p>Currently, the armor list is hard coded with objects. There is a JSON file, conveniently
 * named 'armor.json' which contains all the details necessary to deserialize them for use. However,
 * I've encountered issues loading them into collections before they're accessed. Need some
 * concurrency perhaps. I'll have to tackle this later.</p>
 *
 * <p>The collection containing the pieces of Armor are initialized within a static block</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class ArmorFactory {

  /**
   * A static list of all the armor. Only need one copy therefore static should be appropriate.
   */
  private static List<Armor> armorList;

  static {
    armorList = new ArrayList<>(new ArmorSerializer().getArmorList());
  }

  /**
   * Returns a piece of armor, retrieved by the name. Comparisons are done with the 'contains'
   * method so you don't have to have the exact name for retrieval.
   *
   * @param name the name of the armor to be retrieved
   * @return the suit of armor that has been discovered
   * @throws NullPointerException if the name param is null
   * @throws NoSuchElementException if the name of armor does not exist in the collection
   */
  public static Armor getByName(String name) {
    Objects.requireNonNull(name,
        "You must pass a valid name to retrieve a suit of armor. It cannot be null");
    return armorList.stream()
        .filter(e -> e.getName().contains(name))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException(name +
            " is not a valid suit of armor. It cannot be retrieved."));
  }

}