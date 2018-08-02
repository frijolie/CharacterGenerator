package com.frijolie.dcc.model;

import java.util.Random;

/**
 * A utility class used to simulate the rolling of a set number of dice.
 *
 * @author Frijolie
 * @version 0.1
 */
public class DiceRoller {

  /**
   * Simulates the roll of a set number of equal sided dice. For example, 2d6 = 2 six-sided dice.
   * This method assumes that all the dice are the same denomination.
   */
  public static int rollDice(int numberOfDice, int numberOfSides) {
    Random random = new Random();
    return random.ints(1, numberOfSides + 1)
        .limit(numberOfDice)
        .sum();
  }

}