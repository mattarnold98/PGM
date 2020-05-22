package tc.oc.pgm.loadouts.graph;

import tc.oc.pgm.loadouts.ItemType;

import java.util.List;
import java.util.Optional;

public abstract class MultiTypeNode implements ItemNode {

    private final List<ItemType> types;

    public MultiTypeNode(List<ItemType> types) {
        this.types = types;
    }

    @Override
    public List<ItemType> types() {
        return types;
    }

    @Override
    public Optional<? extends ItemNode> forItem(ItemType type) {
        if(types.contains(type)) {
            return Optional.of(this);
        }

        return Optional.empty();
    }
}
