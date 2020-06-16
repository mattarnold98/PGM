package tc.oc.pgm.loadouts.preferences;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;

public class LoadoutPreferencesBuilder {

    private final Multimap<Slot, LoadoutPreferencesImpl.LoadoutItemPreference> map;

    private LoadoutPreferencesBuilder() {
        this.map = MultimapBuilder.linkedHashKeys().arrayListValues().build();
    }

    public LoadoutPreferencesBuilder addItemType(int slotNumber, ItemType itemType, LoadoutPreferencesImpl.ItemReplacementStrategy replacementStrategy) {
        return addItemType(Slot.Player.forIndex(slotNumber), itemType, replacementStrategy);
    }

    public LoadoutPreferencesBuilder addItemType(Slot slot, ItemType itemType, LoadoutPreferencesImpl.ItemReplacementStrategy replacementStrategy) {
        map.put(slot, new LoadoutPreferencesImpl.LoadoutItemPreference(itemType, replacementStrategy));
        return this;
    }

    public LoadoutPreferencesImpl build() {
        return new LoadoutPreferencesImpl(map);
    }

    public static LoadoutPreferencesBuilder builder() {
        return new LoadoutPreferencesBuilder();
    }
}
