package tc.oc.pgm.loadouts.factory;

import com.google.common.collect.Maps;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.LoadoutState;
import tc.oc.pgm.loadouts.Loadout;
import tc.oc.pgm.loadouts.preferences.LoadoutPreferencesImpl;

import java.util.Map;

public class SimpleStaticLoadoutFactory implements LoadoutFactory {

    //TODO: Delete, only being used for testing

    @Override
    public Loadout createLoadout(LoadoutPreferencesImpl preferences, LoadoutState loadoutState) {
        Map<Slot, ItemType> map = Maps.newHashMap();

        for(Map.Entry<Slot, LoadoutPreferencesImpl.LoadoutItemPreference> entry: preferences) {
            map.put(entry.getKey(), entry.getValue().itemType());
        }

        return new Loadout(map);
    }
}
