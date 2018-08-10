package com.frijolie.dcc.model;

import com.frijolie.dcc.model.inventory.Armor;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A class meant to represent all of the armor currently equipped by the character.
 *
 * <p>The equipped armor is stored in an observable list. This list will be bound to an element in
 * the user interface and is not meant to be modified by the user at this time. Future enhancements
 * may include the ability to purchase and sell items.</p>
 *
 * <p>Each time armor is added or removed from the list, the armor class must be recomputed.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class EquippedArmor {

  /**
   * An ObservableList of Armor. Whenever a character equips armor, the armor is added to this list.
   * This list will be bound to a ListView in the user interface.
   */
  private ObservableList<Armor> armorList;

  /**
   * Default zero argument constructor.
   */
  EquippedArmor() {
    armorList = FXCollections.observableArrayList();
  }

  /**
   * Allows a piece of armor to be added to the list (or equipped).
   *
   * <p>This method does not allow the same piece of armor to be equipped more than once. For
   * example, you cannot equip two shields or multiple suits of Studded Leather. You may, however,
   * equip a suit of armor and a shield.</p>
   *
   * <p>If a different model of similar itemType is passed, it will replace whatever is in the list. For
   * example, if a suit of Padded armor is equipped and you pass a suit of Full-plate, the plate
   * will replace the Padded armor (the padded armor will be removed).</p>
   *
   * @throws NullPointerException if the armor argument is null
   */
  final void addArmor(Armor armor) {
    Objects.requireNonNull(armor,
        "You must pass a valid piece of armor. You cannot add null.");
    if (armorList.size() == 0) {
      armorList.add(armor);
    } else if (!armorList.contains(armor)) {
      // remove the old armor (or shield)
      List<Armor> oldArmor = armorList.stream()
          .filter(a -> a.getItemType() == armor.getItemType())
          .collect(Collectors.toList());
      armorList.removeAll(oldArmor);
      // add the new one
      armorList.add(armor);
    }
  }

  /**
   * Returns an unmodifiable observable list that contains all of the currently equipped armor
   * @return a list of all the equipped armor, which is unmodifiable
   */
  public ObservableList<Armor> getArmorList() {
    return armorList;
  }

}