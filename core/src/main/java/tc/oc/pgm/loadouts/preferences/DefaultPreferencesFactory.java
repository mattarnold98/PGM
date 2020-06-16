package tc.oc.pgm.loadouts.preferences;

import tc.oc.pgm.api.player.MatchPlayer;
import tc.oc.pgm.loadouts.ItemType;

public class DefaultPreferencesFactory implements PreferencesFactory {

    @Override
    public LoadoutPreferencesImpl preferences(MatchPlayer player) {
        return LoadoutPreferencesBuilder.builder()
                    .addItemType(0, ItemType.MELEE_WEAPON, LoadoutPreferencesImpl.ItemReplacementStrategy.REPLACE)
                .addItemType(1, ItemType.MELEE_WEAPON, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(1, ItemType.RANGED, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(2, ItemType.PICKAXE, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(3, ItemType.AXE, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                //.addItemType4), ItemType.SHOVEL, ItemReplacementStrategy.NEXT)
                .addItemType(4, ItemType.BLOCK, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(5, ItemType.BLOCK, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(6, ItemType.SHOVEL, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(7, ItemType.HEAL, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(8, ItemType.FOOD, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(28, ItemType.ARROW, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                //even more temporary testing
                .addItemType(25, ItemType.RANGED, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .addItemType(1, ItemType.MELEE_WEAPON, LoadoutPreferencesImpl.ItemReplacementStrategy.NEXT)
                .build();
    }
}
