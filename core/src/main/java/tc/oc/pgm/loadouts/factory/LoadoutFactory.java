package tc.oc.pgm.loadouts.factory;

import tc.oc.pgm.loadouts.LoadoutState;
import tc.oc.pgm.loadouts.Loadout;
import tc.oc.pgm.loadouts.preferences.LoadoutPreferencesImpl;

public interface LoadoutFactory {

    Loadout createLoadout(LoadoutPreferencesImpl preferences, LoadoutState loadoutState);
}
