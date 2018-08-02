package com.frijolie.dcc.view;

import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * AbilityScoreTextField is a text field that requires certain value validation. The values in these
 * fields are determined by a 3d6 roll of dice. Therefore, their values must be between 3 and 18.
 * These fields are allowed to be modified by the user so some post processing must take place to
 * only allow valid values. Initially these fields will only allow two digits to be typed into the
 * field. After focus has left the field it will attempt to validate the value. If the two digits
 * are not between 3 and 18, it clears the field and sets the field border to red.
 *
 * @author Frijolie
 * @version 0.1
 */
public class AbilityScoreTextField extends TextField {

  /**
   * A regex pattern used to validate the input of the fields. Pattern to match is either one or two
   * digits.
   */
  private static Pattern digitsPattern = Pattern.compile("[0-9]{1,2}");

  /**
   * Constructor.
   */
  public AbilityScoreTextField() {
    super();
    this.setTextFormatter(digitsFormatter());
    addListeners();
  }

  /**
   * Returns a TextFormatter for the text field. Requires text to not be empty and to match the
   * required pattern.
   *
   * @return a TextFormatter with a predefined pattern.
   */
  private TextFormatter<Integer> digitsFormatter() {
    return new TextFormatter<>(
        c -> {
          var newText = c.getControlNewText();
          if (newText.isEmpty()) {
            return c;
          } else if (digitsPattern.matcher(newText).matches()) {
            return c;
          } else {
            return null;
          }
        }
    );
  }

  /**
   * Adds a listener for when the text changes in the field. It first ensures that the text matches
   * the pattern (either 1 or 2 digits). Then it checks to see if the digits are of a valid value,
   * which is between 3 and 18. If the value is not valid, it clears the field and sets a red
   * border.
   */
  private void addListeners() {
    this.focusedProperty().addListener(((observable, oldValue, newValue) -> {
      String fieldText = getText();
      if (digitsPattern.matcher(fieldText).matches()) {
        // it is safe to parse to int. it is one or two digits
        int value = Integer.parseInt(fieldText);
        if (value >= 3 && value <= 18) {
          this.setStyle("-fx-border-color: null; -fx-border-width: null;");
        } else {
          setText("");
          this.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
        }
      } else {
        setText("");
        this.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
      }
    }));
  }

  /**
   * Checks the value in the text fields. Must be a value between 3 and 18 to be valid.
   *
   * @return {@code true} if the text in the field is a value between 3 and 18
   */
  public boolean isValid() {
    String text = getText();
    // if the field contains only two digits
    if (digitsPattern.matcher(text).matches()) {
      // parse the String text to an Integer value
      int intText = Integer.parseInt(text);
      return intText >= 3 && intText <= 18;
    }
    // all other conditions return false, the field is not valid
    return false;
  }

}