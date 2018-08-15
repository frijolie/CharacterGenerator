package com.frijolie.dcc.io;

import com.frijolie.dcc.model.DCCCharacter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.hildan.fxgson.FxGson;

public class JsonWriter {

  public static void writeToJson(List list, String filepath) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    gsonBuilder.setPrettyPrinting();
    gsonBuilder.disableHtmlEscaping();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
    try (Writer writer = new OutputStreamWriter(
        new FileOutputStream(filepath), StandardCharsets.UTF_8)) {
      gson.toJson(list, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeToJson(DCCCharacter character, String filepath) {
    Gson fxGson = FxGson.coreBuilder()
        .disableHtmlEscaping()
        .setPrettyPrinting()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create();
    try (Writer writer = new OutputStreamWriter(new FileOutputStream(filepath),
        StandardCharsets.UTF_8)) {
      fxGson.toJson(character, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
