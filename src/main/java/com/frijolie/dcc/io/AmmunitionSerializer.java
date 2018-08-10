package com.frijolie.dcc.io;

import com.frijolie.dcc.model.inventory.Ammunition;
import com.frijolie.dcc.model.inventory.DCCCurrency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmmunitionSerializer {

  private DCCCurrency gold, copper;
  private List<Ammunition> ammoList;

  AmmunitionSerializer() {
    gold = new DCCCurrency(DCCCurrency.Type.GOLD);
    copper = new DCCCurrency(DCCCurrency.Type.COPPER);
    ammoList = new ArrayList<>();
    populateAmmo();
  }

  private void populateAmmo() {
    Ammunition arrows = new Ammunition("Arrows", 20);
    arrows.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Ammunition silverTip = new Ammunition("Arrow, silver-tipped", 1);
    silverTip.setCostInCopper(DCCCurrency.convert(5, gold, copper));

    Ammunition quarrels = new Ammunition("Quarrels", 30);
    quarrels.setCostInCopper(DCCCurrency.convert(10, gold, copper));

    Ammunition slingStones = new Ammunition("Sling stones", 30);
    slingStones.setCostInCopper(DCCCurrency.convert(1, gold, copper));

    ammoList.add(arrows);
    ammoList.add(silverTip);
    ammoList.add(quarrels);
    ammoList.add(slingStones);
  }

  final List<Ammunition> getAmmoList() {
    return Collections.unmodifiableList(ammoList);
  }

  void writeToJson() {
    JsonWriter.writeToJson(getAmmoList(), "ammunition.json");
  }
}
