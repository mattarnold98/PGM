package tc.oc.pgm.loadouts.graph.types;

import tc.oc.pgm.loadouts.graph.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.inventory.ItemStack;

public class FoodChildNode extends SingleTypeNode {

    public FoodChildNode() {
        super(ItemType.FOOD);
    }

    @Override
    public double typeProbability(ItemStack stack) {
        double amount = stack.getAmount();
        //calculate food restored, requires NMS but is possible... consider maybe?
        if(stack.getType().isEdible()) {
            return 0.4 + 0.6 * (amount / 64);
        }

        return 0;
    }
}
