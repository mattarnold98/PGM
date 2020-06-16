package tc.oc.pgm.loadouts.inference;

import com.google.common.collect.Lists;
import org.bukkit.inventory.ItemStack;

public class MasterTypeParser extends ParentNode {

    private final ItemNode parseGraph;

    public MasterTypeParser(ItemNode parseGraph, ItemNode extraParsers) {
        super(Lists.newArrayList(extraParsers, parseGraph));
        this.parseGraph = parseGraph;
    }

    @Override
    public ProbabilityMatrix matrix(ItemStack stack) {
        return parseGraph.matrix(stack);
    }
}
