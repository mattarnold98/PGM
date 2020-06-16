package tc.oc.pgm.loadouts.factory;

import com.google.common.collect.Maps;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.Loadout;
import tc.oc.pgm.loadouts.LoadoutState;
import tc.oc.pgm.loadouts.preferences.LoadoutPreferencesImpl;

import java.util.*;

public class NormalLoadoutFactory implements LoadoutFactory {

    @Override
    public Loadout createLoadout(LoadoutPreferencesImpl preferences, LoadoutState loadoutState) {
        Map<Slot, ItemType> map = Maps.newHashMap();
        Set<ItemType> toSkip = EnumSet.noneOf(ItemType.class);
        List<LoadoutState.LoadoutItem> items = loadoutState.items();

        for (Map.Entry<Slot, LoadoutPreferencesImpl.LoadoutItemPreference> preference : preferences) {
            Slot slot = preference.getKey();
            if(map.containsKey(slot)) {
                //ignore if we've already got an item for this slot
                continue;
            }
            LoadoutPreferencesImpl.LoadoutItemPreference pref = preference.getValue();

            //check if we should skip this
            if(toSkip.contains(pref.itemType())) {
                toSkip.remove(pref.itemType());
                continue;
            }

            if(!containsCandidate(pref.itemType(), items)) {
                continue;
            }

            map.put(slot, pref.itemType());
            LoadoutPreferencesImpl.ItemReplacementStrategy replacementStrategy = pref.replacementStrategy();
            switch (replacementStrategy) {
                case NEXT:
                    continue;
                case REPLACE:
                    toSkip.add(pref.itemType());
            }

        }

        return new Loadout(map);
    }

    private boolean containsCandidate(ItemType itemType, List<LoadoutState.LoadoutItem> items) {
        for(int i = 0; i < items.size(); i++) {
            LoadoutState.LoadoutItem item = items.get(i);
            if(isCandidate(itemType, item)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean isCandidate(ItemType itemType, LoadoutState.LoadoutItem item) {
        return item.probabilityMatrix().maxWeighted() == itemType;
    }
}
