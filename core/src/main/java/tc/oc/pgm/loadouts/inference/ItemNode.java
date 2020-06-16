package tc.oc.pgm.loadouts.inference;

import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Optional;

public interface ItemNode {

    ProbabilityMatrix matrix(ItemStack stack);

    List<ItemType> types();

    Optional<? extends ItemNode> forItem(ItemType type);

    default ItemNode needItem(ItemType type) {
        return forItem(type)
                .orElseThrow(IllegalStateException::new);
    }

    default double needScore(ItemType type, ItemStack stack) {
        return forItem(type)
                .map(x -> x.matrix(stack))
                .map(x -> x.weight(type))
                .orElseThrow(IllegalStateException::new);
    }
}
