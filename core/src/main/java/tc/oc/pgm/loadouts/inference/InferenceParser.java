package tc.oc.pgm.loadouts.inference;

import com.google.common.collect.Lists;
import tc.oc.pgm.loadouts.inference.types.*;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Optional;

public class InferenceParser implements ItemNode {

    private final ItemNode root;
    private static InferenceParser instance = null;

    private InferenceParser() {
        //create it here
        ItemNode parse = new ParentNode(
                Lists.newArrayList(new FoodChildNode(), new MeleeWeaponNode(), new ToolNode(),
                        new RangedWeaponNode(),
                        new ScaledItemNode(Material.ARROW, ItemType.ARROW),
                        new HealNode(),
                        new BlocksNode())
        );
        this.root = new MasterTypeParser(parse, new ToolTypeNode());
    }

    public static InferenceParser parsers() {
        if(instance == null) {
            instance = new InferenceParser();
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
