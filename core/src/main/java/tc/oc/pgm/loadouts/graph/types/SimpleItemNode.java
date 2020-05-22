package tc.oc.pgm.loadouts.graph.types;

import tc.oc.pgm.loadouts.graph.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SimpleItemNode extends SingleTypeNode {

    private final Material material;

    public SimpleItemNode(Material material, ItemType type) {
        super(type);
        this.material = material;
    }

    @Override
    public double typeProbability(ItemStack stack) {
        if(material == stack.getType()) {
            return 1d;
        }

        return 0d;
    }
}
