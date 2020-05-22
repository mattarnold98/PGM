package tc.oc.pgm.loadouts.graph.types;

import tc.oc.pgm.loadouts.graph.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class RangedWeaponNode extends SingleTypeNode {

    public RangedWeaponNode() {
        super(ItemType.RANGED);
    }

    @Override
    public double typeProbability(ItemStack stack) {
        Material type = stack.getType();
        if(type == Material.BOW) {
            //bow damage enchants come into play here
            double base = 0.8;
            base += 0.01 * stack.getEnchantmentLevel(Enchantment.ARROW_DAMAGE);
            base += 0.005 * stack.getEnchantmentLevel(Enchantment.ARROW_INFINITE);
            base += 0.0025 * stack.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK);
            base += 0.00125 * stack.getEnchantmentLevel(Enchantment.ARROW_FIRE);
            return base;
        }

        if(type == Material.EGG || type == Material.SNOW_BALL) {
            //#scaledProbability returns a value [0.9,1], want to change that to [0.5,0.6] so - 0.4
            return ScaledItemNode.scaledProbability(stack) - 0.4;
        }

        return 0;
    }
}
