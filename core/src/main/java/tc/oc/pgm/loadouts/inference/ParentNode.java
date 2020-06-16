package tc.oc.pgm.loadouts.inference;

import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParentNode implements ItemNode {

    private final Collection<? extends ItemNode> children;

    public ParentNode(Collection<? extends ItemNode> children) {
        this.children = children;
    }

    @Override
    public ProbabilityMatrix matrix(ItemStack stack) {
        return children.stream()
                .map(x -> x.matrix(stack))
                .collect(ProbabilityMatrixCollector.collector());
    }

    @Override
    public List<ItemType> types() {
        return children.stream()
                .map(ItemNode::types)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<? extends ItemNode> forItem(ItemType type) {
        return children.stream()
                .filter(x -> x.types().contains(type))
                .findFirst()
                .flatMap(x -> x.forItem(type));
    }
}
