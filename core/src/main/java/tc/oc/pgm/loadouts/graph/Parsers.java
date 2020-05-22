package tc.oc.pgm.loadouts.graph;

import com.google.common.collect.Lists;
import tc.oc.pgm.loadouts.graph.types.*;
import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.ProbabilityMatrix;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Optional;

public class Parsers implements ItemNode {

    private final ItemNode root;
    private static Parsers instance = null;

    private Parsers() {
        //create it here
        ItemNode parse = new ParentNode(
                Lists.newArrayList(new FoodChildNode(), new MeleeWeaponNode(), new ToolNode(),
                        new RangedWeaponNode(),
                        new ScaledItemNode(Material.ARROW, ItemType.ARROW),
                        new HealNode())
        );
        this.root = new MasterTypeParser(parse, new ToolTypeNode());
    }

    public static Parsers parsers() {
        if(instance == null) {
            instance = new Parsers();
        }
        return instance;
    }

    @Override
    public ProbabilityMatrix matrix(ItemStack stack) {
        return root.matrix(stack);
    }

    @Override
    public List<ItemType> types() {
        return root.types();
    }

    @Override
    public Optional<? extends ItemNode> forItem(ItemType type) {
        return root.forItem(type);
    }
}
