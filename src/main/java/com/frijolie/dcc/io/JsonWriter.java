package com.frijolie.dcc.io;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonWriter {

  public static void writeToJson(List list, String filepath) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setPrettyPrinting();
    gsonBuilder.disableHtmlEscaping();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
    Gson gson = gsonBuilder.create();

    try(Writer writer = new OutputStreamWriter(
        new FileOutputStream(filepath), StandardCharsets.UTF_8)) {
      gson.toJson(list, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
