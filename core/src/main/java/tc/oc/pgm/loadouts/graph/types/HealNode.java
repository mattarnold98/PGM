package tc.oc.pgm.loadouts.graph.types;

import tc.oc.pgm.loadouts.graph.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;

public class HealNode extends SingleTypeNode {

    public HealNode() {
        super(ItemType.HEAL);
    }

    @Override
    public double typeProbability(ItemStack stack) {
        if(stack.getType() == Material.GOLDEN_APPLE) {
            return ScaledItemNode.scaledProbability(stack);
        }

        if(stack.getType() == Material.POTION && stack.getItemMeta() instanceof PotionMeta) {
            PotionMeta meta = (PotionMeta) stack;
            if(meta.hasCustomEffect(PotionEffectType.ABSORPTION)
                    || meta.hasCustomEffect(PotionEffectType.HEAL)
                    || meta.hasCustomEffect(PotionEffectType.HEALTH_BOOST)) {
                return 0.8;
            }
        }

        return 0;
    }
}
