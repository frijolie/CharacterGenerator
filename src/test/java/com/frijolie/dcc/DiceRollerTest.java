package com.frijolie.dcc;

import static org.junit.jupiter.api.Assertions.*;

import com.frijolie.dcc.model.DiceRoller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class DiceRollerTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @RepeatedTest(value = 150)
  void rollDice_3d6RollShouldBeValueBetween3and18() {
    var randomRoll = DiceRoller.rollDice(3,6);
    assertTrue(randomRoll >= 3 && randomRoll <= 18,
        "An ability score roll should be between 3 and 18");
  }
}