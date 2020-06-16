package tc.oc.pgm.loadouts.inference.types;

import tc.oc.pgm.loadouts.inference.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ScaledItemNode extends SingleTypeNode {

    private final Material material;

    public ScaledItemNode(Material material, ItemType type) {
        super(type);
        this.material = material;
    }

    public static double scaledProbability(ItemStack stack) {
        return 0.9 + (double) stack.getAmount() / 640;
    }

    @Override
    public double typeProbability(ItemStack stack) {
        if(stack.getType() != material) {
            return 0d;
        }

        return scaledProbability(stack);
    }
}
