package tc.oc.pgm.loadouts.assignment;

import tc.oc.pgm.api.player.MatchPlayer;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ProbabilityMatrix;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SimpleStaticLoadoutFactory implements LoadoutFactory {

    @Override
    public Loadout createLoadout(MatchPlayer player, Map<Slot, ProbabilityMatrix> inventory, Collection<? extends ProbabilityMatrix> toAdd) {
        return null;
    }
}
