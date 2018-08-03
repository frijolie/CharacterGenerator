package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.io.EquipmentSerializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <p>EquipmentFactory is a class used to provide Equipment to other classes</p>
 *
 * <p>EquipmentFactory maintains a list of all equipment used in the application. It provides
 * utility methods to retrieve a piece of equipment from the collection. They can be retrieved by
 * name or int index (of a map).</p>
 *
 * <p>As a future enhancement, I would like to implement the equipment being populated by a
 * deserialization process. I have the json file, conveniently named 'equipment.json', prepared and
 * eager to be used. I have encountered some issues with populating the list before it is accessed
 * so I've been receiving NullPointerExceptions. Therefore, I've shelved this functionality for
 * another date/time.</p>
 *
 * <p>Currently the Map is being populated in a static block and the List is hard coded with
 * objects</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class EquipmentFactory {

  /**
   * A list of equipment. This is used to return an object by name. There only needs to be a single
   * copy so static, I think, is appropriate.
   */
  private static List<Equipment> equipmentList;
  /**
   * A map which contains an int index (key) as well as a piece of Equipment as the value. There are
   * methods that randomly roll dice and can use this method to easily retrieve a piece of equipment
   * by the result of the roll. Also only one map is necessary so static should be a good fit here.
   */
  private static Map<Integer, Equipment> equipmentByIndex;

  static {
    equipmentList = new ArrayList<>(new EquipmentSerializer().getEquipmentList());
    equipmentByIndex = new HashMap<>();
    equipmentByIndex.put(1, equipmentList.get(0));
    equipmentByIndex.put(2, equipmentList.get(1));
    equipmentByIndex.put(3, equipmentList.get(2));
    equipmentByIndex.put(4, equipmentList.get(3));
    equipmentByIndex.put(5, equipmentList.get(4));
    equipmentByIndex.put(6, equipmentList.get(5));
    equipmentByIndex.put(7, equipmentList.get(6));
    equipmentByIndex.put(8, equipmentList.get(7));
    equipmentByIndex.put(9, equipmentList.get(8));
    equipmentByIndex.put(10, equipmentList.get(9));
    equipmentByIndex.put(11, equipmentList.get(10));
    equipmentByIndex.put(12, equipmentList.get(11));
    equipmentByIndex.put(13, equipmentList.get(12));
    equipmentByIndex.put(14, equipmentList.get(13));
    equipmentByIndex.put(15, equipmentList.get(14));
    equipmentByIndex.put(16, equipmentList.get(15));
    equipmentByIndex.put(17, equipmentList.get(16));
    equipmentByIndex.put(18, equipmentList.get(17));
    equipmentByIndex.put(19, equipmentList.get(18));
    equipmentByIndex.put(20, equipmentList.get(19));
    equipmentByIndex.put(21, equipmentList.get(20));
    equipmentByIndex.put(22, equipmentList.get(21));
    equipmentByIndex.put(23, equipmentList.get(22));
    equipmentByIndex.put(24, equipmentList.get(23));
  }

  /**
   * Returns a piece of equipment from the map which is accessed by the int index.
   *
   * @param index to be used in retrieval
   * @return a piece Equipment given the desired index (key)
   * @throws IllegalArgumentException if the index arg does not exist in the map
   */
  public static Equipment getByIndex(int index) {
    if (equipmentByIndex.containsKey(index)) {
      return equipmentByIndex.get(index);
    } else {
      throw new IllegalArgumentException(index
          + " is not a valid key in equipmentByIndex. Therefore, no Equipment can be retrieved");
    }
  }

  /**
   * Returns a piece of equipment given the name. Comparisons are done using {@code contains()} so
   * you do not have to have the exact string for retrieval.
   *
   * @return a piece of equipment if the name exists.
   * @throws NullPointerException if the name param is {@code null}
   * @throws NoSuchElementException if there was no match on the name arg
   */
  public static Equipment getByName(String name) {
    Objects.requireNonNull(name, "You must pass a valid equipment name. It cannot be null");
    return equipmentList.stream()
        .filter(e -> e.getName().contains(name))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException(name +
        " is not a valid piece of equipment. It cannot be retrieved."));
  }

}