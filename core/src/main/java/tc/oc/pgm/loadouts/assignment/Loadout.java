package tc.oc.pgm.loadouts.assignment;

import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;

import java.util.List;
import java.util.Map;

public interface Loadout {

    ItemType forSlot(Slot slot);

    Map<Slot, ItemType> loadout();

    //some way to apply the loadout to the player
    void applyLoadout();
}
