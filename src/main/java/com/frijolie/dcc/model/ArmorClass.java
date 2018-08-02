package com.frijolie.dcc.model;

import com.frijolie.dcc.model.inventory.Armor;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

/**
 * <p>Armor class in DCC determines how difficult it is for a character to take damage. The higher
 * the armor class, the more difficult it becomes.</p>
 *
 * <p>All characters begin with a base of 10 armor class. It is then modified by agility and the
 * sum of all armor bonuses, if any. For example: If a character with an agility score of 18 (+3
 * modifier) is wearing Hide armor (+3) and has a shield (+1), their Armor Class would be 17
 * (10+3+3+1).</p>
 *
 * <p>{@code Armor Class = 10 + AgilityModifier + Armor Bonus Total}</p>
 *
 * <p>If a character purchases and equips armor, it raises the value of armor class. It must be
 * recalculated.</p>
 *
 * @author Frijolie
 * @version 0.1
 */
public class ArmorClass {

  /**
   * A read only integer property because Armor Class is a computed value. It should not be modified
   * by the user.
   */
  private ReadOnlyIntegerWrapper armorClass;

  /**
   * Constructor.
   */
  ArmorClass() {
    armorClass = new ReadOnlyIntegerWrapper(0);
  }

  /**
   * Returns the value of this characters armor class.
   *
   * @return an int value representing the characters armor class
   */
  int getValue() {
    return armorClass.get();
  }

  /**
   * Returns a read only integer property to represent the value of a characters armor class.
   *
   * @return a read only integer property of a characters armor class.
   */
  public ReadOnlyIntegerProperty armorClassProperty() {
    return armorClass.getReadOnlyProperty();
  }

  /**
   * Calculates the value of the characters armor class. Armor Class = 10 + Agility Modifier + Armor
   * Bonus
   *
   * @throws NullPointerException if the armorList is null
   */
  void calculateArmorClass(int agilityModifier, List<Armor> armorList) {
    Objects.requireNonNull(armorList,
        "You must pass a non-null list of armor to calculate the armor class.");
    // Armor Class = Armor.ACBonus + Shield.ACBonus + Agility Modifier + Magical Modifiers
    var armorBonus = armorList.stream()
        .map(Armor::getAcBonus)
        .reduce(0, Integer::sum);
    setArmorClass(10 + agilityModifier + armorBonus);
  }

  /**
   * Mutator method to set the value of the characters armor class. It is dependent on an agility
   * modifier as well as any equipped armor bonus.
   */
  private void setArmorClass(int value) {
    armorClass.set(value);
  }

}