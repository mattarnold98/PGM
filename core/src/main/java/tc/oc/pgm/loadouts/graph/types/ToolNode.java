package tc.oc.pgm.loadouts.graph.types;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import tc.oc.pgm.loadouts.graph.MultiTypeNode;
import tc.oc.pgm.loadouts.graph.Parsers;
import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.MapProbabilityMatrix;
import tc.oc.pgm.loadouts.ProbabilityMatrix;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ToolNode extends MultiTypeNode {

    public ToolNode() {
        super(Lists.newArrayList(ItemType.TOOL, ItemType.PICKAXE, ItemType.AXE, ItemType.SHOVEL, ItemType.HOE));
    }

    @Override
    public ProbabilityMatrix matrix(ItemStack stack) {
        ItemType toolType = toolTypeOrNull(stack);
        double score = 0d;

        if(toolType != null) {
            score = Parsers.parsers().needScore(ItemType.TOOL_TYPE, stack);
        }

        int level = stack.getEnchantmentLevel(Enchantment.DIG_SPEED);
        if(score == 0 && level > 0) {
            score = 0.2;
        }
        score += level * 0.01;

        Map<ItemType, Double> matrix = Maps.newEnumMap(ItemType.class);
        matrix.put(ItemType.TOOL, score);
        if(toolType != null) {
            matrix.put(toolType, score);
        }

        return MapProbabilityMatrix.of(matrix);
    }

    private ItemType toolTypeOrNull(ItemStack stack) {
        String type = stack.getType().name().toUpperCase();

        if(type.endsWith("_PICKAXE")) {
            return ItemType.PICKAXE;
        }
        if(type.endsWith("_AXE")) {
            return ItemType.AXE;
        }
        if(type.endsWith("_SPADE")) {
            return ItemType.SHOVEL;
        }
        if(type.endsWith("_HOE")) {
            return ItemType.HOE;
        }

        return null;
    }
}
