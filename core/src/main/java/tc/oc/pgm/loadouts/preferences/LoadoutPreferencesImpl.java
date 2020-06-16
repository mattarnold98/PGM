package tc.oc.pgm.loadouts.preferences;

import com.google.common.collect.Multimap;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;

import java.util.Iterator;
import java.util.Map;

public class LoadoutPreferencesImpl implements Iterable<Map.Entry<Slot, LoadoutPreferencesImpl.LoadoutItemPreference>> {

    private final Multimap<Slot, LoadoutItemPreference> map;

    public LoadoutPreferencesImpl(Multimap<Slot, LoadoutItemPreference> map) {
        this.map = map;
    }

    @Override
    public Iterator<Map.Entry<Slot, LoadoutItemPreference>> iterator() {
        return map.entries().iterator();
    }

    public static class LoadoutItemPreference {

        private final ItemType itemType;
        private final ItemReplacementStrategy replacementStrategy;

        public LoadoutItemPreference(ItemType itemType, ItemReplacementStrategy replacementStrategy) {
            this.itemType = itemType;
            this.replacementStrategy = replacementStrategy;
        }

        public ItemType itemType() {
            return itemType;
        }

        public ItemReplacementStrategy replacementStrategy() {
            return replacementStrategy;
        }
    }

    public enum ItemReplacementStrategy {
        NEXT,
        REPLACE
    }
}
