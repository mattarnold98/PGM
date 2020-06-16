package tc.oc.pgm.loadouts;

import com.google.common.collect.Lists;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.api.match.MatchModule;
import tc.oc.pgm.api.match.MatchScope;
import tc.oc.pgm.api.player.MatchPlayer;
import tc.oc.pgm.events.ListenerScope;
import tc.oc.pgm.kits.ItemKit;
import tc.oc.pgm.loadouts.assignment.*;
import tc.oc.pgm.loadouts.factory.LoadoutFactory;
import tc.oc.pgm.loadouts.factory.NormalLoadoutFactory;
import tc.oc.pgm.loadouts.preferences.DefaultPreferencesFactory;
import tc.oc.pgm.loadouts.preferences.LoadoutPreferencesImpl;
import tc.oc.pgm.loadouts.preferences.PreferencesFactory;

@ListenerScope(MatchScope.LOADED)
public class LoadoutMatchModule implements MatchModule {

    private final PreferencesFactory preferencesFactory = new DefaultPreferencesFactory();
    private final LoadoutFactory factory = new NormalLoadoutFactory();
    private final LoadoutAssignment assignment = new SimpleAssignment();

    public LoadoutMatchModule(Match match) {
    }

    public void applyLoadout(MatchPlayer player, ItemKit kit) {
        LoadoutState state = LoadoutState.ofPlayer(player, Lists.newArrayList(kit.getItems()));

        LoadoutPreferencesImpl prefs = preferencesFactory.preferences(player);
        Loadout loadout = factory.createLoadout(prefs, state);
        assignment.applyLoadout(loadout, state);
    }
}
