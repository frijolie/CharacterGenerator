package com.frijolie.dcc.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultProperties {

  static Properties defaultProperties = new Properties();

  static {
    String defaultPropertyFile = "/files/default.properties";
    try (InputStream in = DefaultProperties.class.getResourceAsStream(defaultPropertyFile)) {
      defaultProperties.load(in);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find \'default.properties\'");
    } catch (IOException e) {
      System.err.println("Could not load \'default.properties\'");
    }
  }

  public static boolean getBooleanValue(String key) {
    if (defaultProperties.containsKey(key)) {
      if (defaultProperties.getProperty(key).equalsIgnoreCase("true") ||
          defaultProperties.getProperty(key).equalsIgnoreCase("false")) {
        return Boolean.parseBoolean(defaultProperties.getProperty(key));
      } else {
        throw new IllegalArgumentException(key + " does not contain a boolean value");
      }
    }
    // should never reach this
    return false;
  }

  public static boolean getCheckMenuItem(String key) {
    if (defaultProperties.containsKey(key)) {
      if (defaultProperties.getProperty(key).equalsIgnoreCase("checked")) {
        return true;
      }
      if (defaultProperties.getProperty(key).equalsIgnoreCase("unchecked")) {
        return false;
      }
    } else {
      throw new IllegalArgumentException(key + " does not contain a checked/unchecked value");
    }
    // should never reach this
    return false;
  }

}