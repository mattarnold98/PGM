package tc.oc.pgm.loadouts.assignment;

import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;

import java.util.Map;

public class MappedLoadout implements Loadout {

    private final Map<Slot, ItemType> loadout;

    public MappedLoadout(Map<Slot, ItemType> loadout) {
        this.loadout = loadout;
    }

    @Override
    public ItemType forSlot(Slot slot) {
        return null;

    }

    @Override
    public Map<Slot, ItemType> loadout() {
        return null;
    }
}
