package tc.oc.pgm.loadouts;

import com.google.common.collect.Maps;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.graph.Parsers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemGiver {

    private final Map<Slot, ItemType> map;

    public ItemGiver() {
        this.map = Maps.newHashMap();
        map.put(Slot.Player.forIndex(0), ItemType.MELEE_WEAPON);
        map.put(Slot.Player.forIndex(1), ItemType.RANGED);
        map.put(Slot.Player.forIndex(2), ItemType.PICKAXE);
        map.put(Slot.Player.forIndex(3), ItemType.AXE);
        map.put(Slot.Player.forIndex(4), ItemType.SHOVEL);
        map.put(Slot.Player.forIndex(5), ItemType.HEAL);
        map.put(Slot.Player.forIndex(28), ItemType.ARROW);
    }

    public List<ItemStack> giveItems(HumanEntity player, List<ItemStack> toGive) {
        List<ItemBundle> bundles = toGive.stream()
                .map(x -> new ItemBundle(x, Parsers.parsers().matrix(x)))
                .collect(Collectors.toList());

        for(ItemBundle bundle: bundles) {

        }
    }

    private static class ItemBundle {

        private final ItemStack itemStack;
        private final ProbabilityMatrix matrix;

        public ItemBundle(ItemStack itemStack, ProbabilityMatrix matrix) {
            this.itemStack = itemStack;
            this.matrix = matrix;
        }
    }
}
