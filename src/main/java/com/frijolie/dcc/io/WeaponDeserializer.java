package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.MeleeRangedWeapon;
import com.frijolie.dcc.model.inventory.MeleeWeapon;
import com.frijolie.dcc.model.inventory.RangedWeapon;
import com.frijolie.dcc.model.inventory.Weapon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeaponDeserializer implements JsonDeserializer<Weapon> {

  private List<Weapon> weaponList;
  private Gson gson;

  public WeaponDeserializer() {
    gson = new Gson();
    parseWeapons();
  }

  private void parseWeapons() {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Weapon.class, this);
    JsonReader reader = new JsonReader(new InputStreamReader(
        getClass().getResourceAsStream("/json/weapons.json"), StandardCharsets.UTF_8));
    gson = builder.create();
    Weapon[] weapons = gson.fromJson(reader, Weapon[].class);
    weaponList = new ArrayList<>();
    weaponList.addAll(Arrays.asList(weapons));
  }

  public final List<Weapon> getWeaponList() {
    return Collections.unmodifiableList(weaponList);
  }

  @Override
  public Weapon deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject jsonObject = (JsonObject) json;
    JsonElement jsonType = jsonObject.get("type");
    String type = jsonType.getAsString();

    switch (type) {
      case "MELEE":
        return context.deserialize(json, MeleeWeapon.class);
      case "RANGED":
        return context.deserialize(json, RangedWeapon.class);
      case "BOTH":
        return context.deserialize(json, MeleeRangedWeapon.class);
      default:
        return null;
    }
  }
}