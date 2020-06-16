package tc.oc.pgm.loadouts.preferences;

import tc.oc.pgm.api.player.MatchPlayer;

public interface PreferencesFactory {

    LoadoutPreferencesImpl preferences(MatchPlayer player);
}
