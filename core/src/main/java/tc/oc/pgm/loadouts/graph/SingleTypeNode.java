package tc.oc.pgm.loadouts.graph;

import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.ProbabilityMatrix;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class SingleTypeNode implements ItemNode {

    private final ItemType type;

    public SingleTypeNode(ItemType type) {
        this.type = type;
    }

    @Override
    public ProbabilityMatrix matrix(ItemStack stack) {
        return ProbabilityMatrix.singleProbability(type, typeProbability(stack));
    }

    @Override
    public List<ItemType> types() {
        return Collections.singletonList(type);
    }

    @Override
    public Optional<? extends ItemNode> forItem(ItemType type) {
        if(type == this.type) {
            return Optional.of(this);
        }
        return Optional.empty();
    }

    public abstract double typeProbability(ItemStack stack);
}
