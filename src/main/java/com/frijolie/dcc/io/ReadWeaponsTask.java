package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.Weapon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReadWeaponsTask implements Callable<List<Weapon>> {

  @Override
  public List<Weapon> call() throws Exception {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Weapon.class, this);
    JsonReader reader = new JsonReader(new InputStreamReader(
        getClass().getResourceAsStream("/json/weapons.json"), StandardCharsets.UTF_8));
    Gson gson = builder.create();
    Weapon[] weapons = gson.fromJson(reader, Weapon[].class);
    List<Weapon> weaponList = new ArrayList<>();
    weaponList.addAll(Arrays.asList(weapons));
    System.out.println("ReadWeaponsTask: weaponList has " + weaponList.size() + " elements.");
    TimeUnit.SECONDS.sleep(1);
    return weaponList;
  }
}