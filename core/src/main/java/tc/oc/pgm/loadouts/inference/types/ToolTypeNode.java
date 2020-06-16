package tc.oc.pgm.loadouts.inference.types;

import tc.oc.pgm.loadouts.inference.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.inventory.ItemStack;

public class ToolTypeNode extends SingleTypeNode {

    public ToolTypeNode() {
        super(ItemType.TOOL_TYPE);
    }

    /**
     * Parses the material of the specified item/tool
     *
     * @param stack
     * @return
     */
    @Override
    public double typeProbability(ItemStack stack) {
        String matName = stack.getType().name().toUpperCase();

        if(matName.startsWith("WOOD_")) {
            return 0.4;
        }
        if(matName.startsWith("STONE_")) {
            return 0.5;
        }
        if(matName.startsWith("GOLD_")) {
            return 0.6;
        }
        if(matName.startsWith("IRON_")) {
            return 0.7;
        }
        if(matName.startsWith("DIAMOND_")) {
            return 0.8;
        }

        return 0;
    }
}
