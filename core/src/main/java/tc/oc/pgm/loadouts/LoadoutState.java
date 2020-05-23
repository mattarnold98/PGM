package tc.oc.pgm.loadouts;

import com.google.common.collect.Maps;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import tc.oc.pgm.api.player.MatchPlayer;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.graph.Parsers;
import tc.oc.pgm.util.inventory.InventoryUtils;

import java.util.List;
import java.util.Map;

public class LoadoutState {

    private final MatchPlayer player;
    private final Map<Slot, LoadoutItem> inventory;
    private final List<? extends LoadoutItem> items;

    private LoadoutState(MatchPlayer player, Map<Slot, LoadoutItem> inventory, List<? extends LoadoutItem> items) {
        this.player = player;
        this.inventory = inventory;
        this.items = items;
    }

    public MatchPlayer player() {
        return player;
    }

    public Map<Slot, LoadoutItem> inventory() {
        return inventory;
    }

    public List<? extends LoadoutItem> itemsToAdd() {
        return items;
    }

    public static LoadoutState ofPlayer(MatchPlayer player, List<? extends LoadoutItem> loadoutItems) {
        return new LoadoutState(player, playerInventory(player), loadoutItems);
    }

    private static Map<Slot, LoadoutItem> playerInventory(MatchPlayer player) {
        PlayerInventory inv = player.getInventory();
        Map<Slot, LoadoutItem> itemMap = Maps.newHashMap();
        Parsers parsers = Parsers.parsers();

        for(int i = 0; i < 36; i++) {
            ItemStack item = inv.getItem(i);
            if(!InventoryUtils.isNothing(item)) {
                ProbabilityMatrix matrix = parsers.matrix(item);
                itemMap.put(Slot.Player.forIndex(i), new LoadoutItem(matrix, item));
            }
        }

        return itemMap;
    }

    public static class LoadoutItem {

        private final ProbabilityMatrix probabilityMatrix;
        private final ItemStack itemStack;

        public LoadoutItem(ProbabilityMatrix probabilityMatrix, ItemStack itemStack) {
            this.probabilityMatrix = probabilityMatrix;
            this.itemStack = itemStack;
        }
    }
}
