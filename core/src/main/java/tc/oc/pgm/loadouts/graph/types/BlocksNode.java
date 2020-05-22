package tc.oc.pgm.loadouts.graph.types;

import tc.oc.pgm.loadouts.graph.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.inventory.ItemStack;

public class BlocksNode extends SingleTypeNode {

    public BlocksNode() {
        super(ItemType.BLOCK);
    }

    @Override
    public double typeProbability(ItemStack stack) {
        if(!stack.getType().isBlock()) {
            return 0d;
        }

        return ScaledItemNode.scaledProbability(stack);
    }
}
