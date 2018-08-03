package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.Ammunition;
import com.frijolie.dcc.model.inventory.DCCCurrency;
import com.frijolie.dcc.model.inventory.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmmunitionSerializer {

  private DCCCurrency gold, copper;
  private List<Item> ammoList;

  public AmmunitionSerializer() {
    gold = new DCCCurrency(DCCCurrency.Type.GOLD);
    copper = new DCCCurrency(DCCCurrency.Type.COPPER);
    ammoList = new ArrayList<>();
    populateAmmo();
  }

  private void populateAmmo() {
    Item arrows = new Ammunition("Arrows", 20);
    arrows.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Item silverTip = new Ammunition("Arrow, silver-tipped", 1);
    silverTip.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Item quarrels = new Ammunition("Quarrels", 30);
    quarrels.setCostInCopper(DCCCurrency.convert(10, gold, copper));

    Item slingStones = new Ammunition("Sling stones", 30);
    slingStones.setCostInCopper(DCCCurrency.convert(1, gold, copper));

    ammoList.add(arrows);
    ammoList.add(silverTip);
    ammoList.add(quarrels);
    ammoList.add(slingStones);
  }

  public final List<Item> getAmmoList() {
    return Collections.unmodifiableList(ammoList);
  }

  void writeToJson() {
    JsonWriter.writeToJson(getAmmoList(), "ammunition.json");
  }
}
