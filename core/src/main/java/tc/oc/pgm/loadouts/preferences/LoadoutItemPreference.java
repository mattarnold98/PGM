package tc.oc.pgm.loadouts.preferences;

import tc.oc.pgm.loadouts.ItemType;

public class LoadoutItemPreference {

    private final ItemType itemType;
    private final LoadoutPreferencesImpl.ItemReplacementStrategy replacementStrategy;

    public LoadoutItemPreference(ItemType itemType, LoadoutPreferencesImpl.ItemReplacementStrategy replacementStrategy) {
        this.itemType = itemType;
        this.replacementStrategy = replacementStrategy;
    }

    public ItemType itemType() {
        return itemType;
    }

    public LoadoutPreferencesImpl.ItemReplacementStrategy replacementStrategy() {
        return replacementStrategy;
    }

    public enum ItemReplacementStrategy {
        NEXT,
        REPLACE
    }
}
