package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.model.inventory.DCCCurrency.Type;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AmmunitionTest {
  
  DCCCurrency gold;
  DCCCurrency copper;
  
  @BeforeAll
  void setUpAll() {
    gold = new DCCCurrency(Type.GOLD);
    copper = new DCCCurrency(Type.COPPER);
  }

  @Test
  void loadAmmo() {

    Item arrows = new Ammunition("Arrows", 20);
    arrows.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Item silverTip = new Ammunition("Arrow, silver-tipped", 1);
    silverTip.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Item quarrels = new Ammunition("Quarrels", 30);
    quarrels.setCostInCopper(DCCCurrency.convert(10, gold, copper));

    Item slingStones = new Ammunition("Sling stones", 30);
    slingStones.setCostInCopper(DCCCurrency.convert(1, gold, copper));

    //Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();
    List<String> ammo = new ArrayList<>();

    ammo.add(gson.toJson(arrows));
    ammo.add(gson.toJson(silverTip));
    ammo.add(gson.toJson(quarrels));
    ammo.add(gson.toJson(slingStones));

    ammo.forEach(System.out::println);
  }

}