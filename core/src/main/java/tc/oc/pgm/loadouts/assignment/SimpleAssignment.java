package tc.oc.pgm.loadouts.assignment;

import com.google.common.collect.Sets;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tc.oc.pgm.kits.Slot;
import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.Loadout;
import tc.oc.pgm.loadouts.LoadoutState;
import tc.oc.pgm.util.inventory.InventoryUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.Comparator;

public class SimpleAssignment implements LoadoutAssignment {

    @Override
    public void applyLoadout(Loadout loadout, LoadoutState loadoutState) {
        Player player = loadoutState.player().getBukkit();

        List<Slot> slots = loadout.loadout().keySet()
                .stream()
                .sorted(Comparator.comparingInt(Slot::getIndex))
                .collect(Collectors.toList());

        Set<LoadoutState.LoadoutItem> added = Sets.newHashSet();

        player.sendMessage("" + loadoutState.itemsToAdd().size());
        for (Slot slot : slots) {
            ItemType type = loadout.loadout().get(slot);

            loadoutState.itemsToAdd().stream()
                    .filter(x -> !added.contains(x))
                    .max(Comparator.comparingDouble((LoadoutState.LoadoutItem x) -> x.probabilityMatrix().weight(type)))
                    .filter(x -> x.probabilityMatrix().weight(type) > 0.35)
                    .ifPresent(item -> {
                        player.sendMessage(item.itemStack().getType().name());
                        player.sendMessage(slot.getKey());
                        added.add(item);
                        ItemStack returned = slot.getItem(player);
                        slot.putItem(player, item.itemStack().clone());
                        if(!InventoryUtils.isNothing(returned)) {
                            loadoutState.itemsToAdd().add(
                                    LoadoutState.LoadoutItem.ofItem(returned)
                            );
                        }
                    });
        }

        loadoutState.itemsToAdd().stream()
                .filter(x -> !added.contains(x))
                .forEach(x -> {
                    player.sendMessage(x.itemStack().getType().name());
                    player.getInventory().addItem(x.itemStack());
                });
    }
}
