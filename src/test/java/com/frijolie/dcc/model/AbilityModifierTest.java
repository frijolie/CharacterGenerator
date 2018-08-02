package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AbilityModifierTest {
  
  AbilityModifier modifier;
  
  @Test
  void getModifier_AbilityScore3ShouldReturnNegativeThreeModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(3);
    assertEquals(-3, modifier.getModifier(),
        "An ability score of 3 should return a -3 modifier");
  }

  @Test
  void getModifier_AbilityScore4ShouldReturnNegativeTwoModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(4);
    assertEquals(-2, modifier.getModifier(),
        "An ability score of 4 should return a -2 modifier");
  }

  @Test
  void getModifier_AbilityScore5ShouldReturnNegativeTwoModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(5);
    assertEquals(-2, modifier.getModifier(),
        "An ability score of 5 should return a -2 modifier");
  }

  @Test
  void getModifier_AbilityScore6ShouldReturnNegativeOneModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(6);
    assertEquals(-1, modifier.getModifier(),
        "An ability score of 6 should return a -1 modifier");
  }

  @Test
  void getModifier_AbilityScore7ShouldReturnNegativeOneModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(7);
    assertEquals(-1, modifier.getModifier(),
        "An ability score of 7 should return a -1 modifier");
  }

  @Test
  void getModifier_AbilityScore8ShouldReturnNegativeOneModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(8);
    assertEquals(-1, modifier.getModifier(),
        "An ability score of 8 should return a -1 modifier");
  }

  @Test
  void getModifier_AbilityScore9ShouldReturnZeroModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(9);
    assertEquals(0, modifier.getModifier(),
        "An ability score of 9 should return a 0 modifier");
  }

  @Test
  void getModifier_AbilityScore10ShouldReturnZeroModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(10);
    assertEquals(0, modifier.getModifier(),
        "An ability score of 10 should return a 0 modifier");
  }

  @Test
  void getModifier_AbilityScore11ShouldReturnZeroModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(11);
    assertEquals(0, modifier.getModifier(),
        "An ability score of 11 should return a 0 modifier");
  }

  @Test
  void getModifier_AbilityScore12ShouldReturnZeroModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(12);
    assertEquals(0, modifier.getModifier(),
        "An ability score of 12 should return a 0 modifier");
  }

  @Test
  void getModifier_AbilityScore13ShouldReturnPositiveOneModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(13);
    assertEquals(1, modifier.getModifier(),
        "An ability score of 13 should return a +1 modifier");
  }

  @Test
  void getModifier_AbilityScore14ShouldReturnPositiveOneModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(14);
    assertEquals(1, modifier.getModifier(),
        "An ability score of 14 should return a +1 modifier");
  }

  @Test
  void getModifier_AbilityScore15ShouldReturnPositiveOneModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(15);
    assertEquals(1, modifier.getModifier(),
        "An ability score of 15 should return a +1 modifier");
  }

  @Test
  void getModifier_AbilityScore16ShouldReturnPositiveTwoModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(16);
    assertEquals(2, modifier.getModifier(),
        "An ability score of 16 should return a +2 modifier");
  }

  @Test
  void getModifier_AbilityScore17ShouldReturnPositiveTwoModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(17);
    assertEquals(2, modifier.getModifier(),
        "An ability score of 17 should return a +2 modifier");
  }

  @Test
  void getModifier_AbilityScore18ShouldReturnPositiveThreeModifier() {
    modifier = new AbilityModifier();
    modifier.calculateModifier(18);
    assertEquals(3, modifier.getModifier(),
        "An ability score of 18 should return a +3 modifier");
  }

  @Test
  void calculateModifier_abilityScoreLessThanThreeShouldThrowIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> {
      modifier = new AbilityModifier();
      modifier.calculateModifier(2);
    });
  }

  @Test
  void calculateModifier_abilityScoreGreaterThan18ShouldThrowIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> {
      modifier = new AbilityModifier();
      modifier.calculateModifier(19);
    });
  }

}