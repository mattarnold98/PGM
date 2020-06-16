package tc.oc.pgm.loadouts;

import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;

import java.util.List;
import java.util.Map;

public class Loadout {

    private final Map<Slot, ItemType> loadoutMap;

    public Loadout(Map<Slot, ItemType> loadoutMap) {
        this.loadoutMap = loadoutMap;
    }

    public ItemType forSlot(Slot slot) {
        return loadoutMap.get(slot);
    }

    public Map<Slot, ItemType> loadout() {
        return loadoutMap;
    }
}
