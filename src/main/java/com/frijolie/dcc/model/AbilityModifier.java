package com.frijolie.dcc.model;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

/**
 * <p>AbilityModifier calculates the value of an ability modifier in Dungeon Crawl Classics
 * RPG.</p>
 *
 * <p>There are six AbilityModifier values: StrengthMod, AgilityMod, StaminaMod, PersonalityMod,
 * LuckMod, and IntelligenceMod. Each modifier is based on a respective {@link AbilityScore}. An
 * ability score must have a value between 3 and 18 (inclusive). An ability modifier is an integer
 * value between -3 and 3. The higher the value of an ability score the higher (bonus) of the
 * ability modifier. The lower the value of an ability score the higher (penalty) of the ability
 * modifier.</p>
 *
 * <p>The ability modifier values are initialized in a Map within a static block.</p>
 *
 * <p>For more on Ability Modifiers, see Dungeon Crawl Classics Core Rule Book (DCCCRB)
 * 4<sup>th</sup> edition p.18</p>
 *
 * @author Frijolie
 * @version 0.1
 * @see AbilityScore
 */
public class AbilityModifier {

  /**
   * A Map to retrieve the value of the AbilityModifier. An AbilityScore represents the key and an
   * AbilityModifier is the value of the map.
   */
  private static Map<Integer, Integer> modifiers;
  /**
   * The ReadOnlyIntegerProperty of the AbilityModifier. This value will be used in the user
   * interface as well as for some calculation. It is read-only because it is a computed value and
   * not meant to be modified by the user.
   */
  private ReadOnlyIntegerWrapper modifier;

  static {
    modifiers = new HashMap<>();
    modifiers.put(3, -3);
    modifiers.put(4, -2);
    modifiers.put(5, -2);
    modifiers.put(6, -1);
    modifiers.put(7, -1);
    modifiers.put(8, -1);
    modifiers.put(9, 0);
    modifiers.put(10, 0);
    modifiers.put(11, 0);
    modifiers.put(12, 0);
    modifiers.put(13, 1);
    modifiers.put(14, 1);
    modifiers.put(15, 1);
    modifiers.put(16, 2);
    modifiers.put(17, 2);
    modifiers.put(18, 3);
  }

  /**
   * Default zero-arg constructor.
   */
  AbilityModifier() {
    modifier = new ReadOnlyIntegerWrapper(0);
  }

  /**
   * Sets the value of the ability modifier given the ability score. The ability score must be
   * between 3 and 18 (inclusive).
   *
   * @param abilityScore used to retrieve the value of the ability modifier.
   * @throws IllegalArgumentException if the ability modifier argument is not between 3 and 18.
   */
  final void calculateModifier(int abilityScore) {
    if (modifiers.containsKey(abilityScore)) {
      setModifier(modifiers.get(abilityScore));
    } else {
      throw new IllegalArgumentException(abilityScore +
          " is not a valid ability score. Cannot set the value of the ability modifier");
    }
  }

  /**
   * Returns the int value of the ability modifier
   *
   * @return the value of the ability modifier
   */
  final int getModifier() {
    return modifier.get();
  }

  /**
   * Returns the IntegerProperty of the ability modifier
   *
   * @return the ability modifier property
   */
  public final ReadOnlyIntegerProperty modifierProperty() {
    return modifier.getReadOnlyProperty();
  }

  /**
   * Sets the value of the ability modifier. Not much validation is needed here as the value is
   * retrieved from the Map and this method is private. Am I crazy?
   */
  private void setModifier(int modifier) {
    this.modifier.set(modifier);
  }

}