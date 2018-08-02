package com.frijolie.dcc.view;

import java.text.DecimalFormat;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class PositivePrefixTextField extends TextField {

  public PositivePrefixTextField() {
    super();
    this.setEditable(false);
    this.setTextFormatter(positivePrefixFormat());
  }

  private TextFormatter<Integer> positivePrefixFormat() {
    DecimalFormat plusSign = new DecimalFormat();
    plusSign.setPositivePrefix("+");

    StringConverter<Integer> converter = new IntegerStringConverter() {

      @Override
      public String toString(Integer value) {
        return value == null ? "" : plusSign.format(value);
      }

    };

    return new TextFormatter<>(converter);
  }

}