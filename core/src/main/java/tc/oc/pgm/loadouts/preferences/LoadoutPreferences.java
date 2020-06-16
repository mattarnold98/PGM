package tc.oc.pgm.loadouts.preferences;

import tc.oc.pgm.kits.Slot;

import java.util.List;
import java.util.Map;

public interface LoadoutPreferences {

    Iterable<Map.Entry<Slot, LoadoutItemPreference>> preferences();

    List<LoadoutItemPreference> preferencesForSlot(Slot slot);

    void setPreferences(Map<Slot, List<LoadoutItemPreference>> preferences);
}
