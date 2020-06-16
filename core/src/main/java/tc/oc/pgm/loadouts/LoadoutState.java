package tc.oc.pgm.loadouts;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import tc.oc.pgm.api.player.MatchPlayer;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.inference.InferenceParser;
import tc.oc.pgm.loadouts.inference.ProbabilityMatrix;
import tc.oc.pgm.util.inventory.InventoryUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoadoutState {

    private final MatchPlayer player;
    private final Map<Slot, LoadoutItem> inventory;
    private final List<LoadoutItem> items;

    private LoadoutState(MatchPlayer player, Map<Slot, LoadoutItem> inventory, List<LoadoutItem> items) {
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

    public List<LoadoutItem> itemsToAdd() {
        return items;
    }

    public List<LoadoutItem> items() {
        List<LoadoutItem> items = Lists.newArrayList();
        items.addAll(this.inventory.values());
        items.addAll(this.items);
        return items;
    }

    public static LoadoutState ofPlayer(MatchPlayer player, List<ItemStack> loadoutItems) {
        return new LoadoutState(player, playerInventory(player), loadoutItems.stream().map(LoadoutItem::ofItem).collect(Collectors.toList()));
    }

    private static Map<Slot, LoadoutItem> playerInventory(MatchPlayer player) {
        PlayerInventory inv = player.getInventory();
        Map<Slot, LoadoutItem> itemMap = Maps.newHashMap();
        InferenceParser parsers = InferenceParser.parsers();

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

        public static LoadoutItem ofItem(ItemStack itemStack) {
            return new LoadoutItem(InferenceParser.parsers().matrix(itemStack), itemStack);
        }

        public ProbabilityMatrix probabilityMatrix() {
            return probabilityMatrix;
        }

        public ItemStack itemStack() {
            return itemStack;
        }
    }
}
