package com.frijolie.dcc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.dcc.model.DiceRoller;
import org.junit.jupiter.api.RepeatedTest;

class DiceRollerTest {

  @RepeatedTest(value = 150)
  void rollDice_3d6RollShouldBeValueBetween3and18() {
    var randomRoll = DiceRoller.rollDice(3,6);
    assertTrue(randomRoll >= 3 && randomRoll <= 18,
        "An 3d6 roll should be between 3 and 18. Instead it was : " + randomRoll);
  }
}