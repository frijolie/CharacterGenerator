package com.frijolie.dcc.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HitPointsTest {

  private HitPoints hitPoints;

  @BeforeEach
  void setUp() {
    hitPoints = new HitPoints();
  }

  @AfterEach
  void tearDown() {
    hitPoints.setHitPoints(0);
    hitPoints = null;
  }

  // Hit Points = staminaMod + class Bonus + 1d4 (rolled in method). Hit Points must be >= 1

  @RepeatedTest(value = 50)
  void calculateHitPoints_staminaModOfPlusOneGreaterOrEqualToOne() {
    hitPoints.calculateHitPoints(1, 0);
    assertTrue(hitPoints.getHitPoints() >= 1,
        "Hit points should be equal or greater than 1. Instead it is: "
            + hitPoints.getHitPoints());
  }

  @RepeatedTest(value = 50)
  void calculateHitPoints_staminaModOfMinusTwoGreaterOrEqualToOne() {
    hitPoints.calculateHitPoints(-2, 0);
    assertTrue(hitPoints.getHitPoints() >= 1,
        "Hit points should be equal or greater than 1. Instead it is: "
            + hitPoints.getHitPoints());
  }
}