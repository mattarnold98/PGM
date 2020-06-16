package tc.oc.pgm.loadouts.assignment;

import tc.oc.pgm.loadouts.Loadout;
import tc.oc.pgm.loadouts.LoadoutState;

public interface LoadoutAssignment {

    void applyLoadout(Loadout loadout, LoadoutState loadoutState);
}
