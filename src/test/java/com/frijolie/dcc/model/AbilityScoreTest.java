package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AbilityScoreTest {

  AbilityScore abilityScore;

  @BeforeEach
  void setUp() {
    abilityScore = new AbilityScore();
  }

  @AfterEach
  void tearDown() {
    abilityScore = null;
  }

  @RepeatedTest(value = 150)
  void calculateAbilityScore_shouldBeValueBetween3and18() {
    var randomRoll = DiceRoller.rollDice(3,6);
    assertTrue(randomRoll >= 3 && randomRoll <= 18,
        "An ability score roll should be between 3 and 18");
  }

  @Test
  void setValue_addingNumberLessThanThreeShouldThrowIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> abilityScore.setScore(2), "Attempting to set a value less than 3 should throw an IllegalArgumentException");
  }

  @Test
  void setValue_addingNumberGreaterThan18ShouldThrowIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> abilityScore.setScore(19), "Attempting to set a value greater than 18 should throw an IllegalArgumentException");
  }

}