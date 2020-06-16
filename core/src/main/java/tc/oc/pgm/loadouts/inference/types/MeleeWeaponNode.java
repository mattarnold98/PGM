package tc.oc.pgm.loadouts.inference.types;

import tc.oc.pgm.loadouts.inference.InferenceParser;
import tc.oc.pgm.loadouts.inference.SingleTypeNode;
import tc.oc.pgm.loadouts.ItemType;
import tc.oc.pgm.loadouts.inference.ProbabilityMatrix;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class MeleeWeaponNode extends SingleTypeNode {

    public MeleeWeaponNode() {
        super(ItemType.MELEE_WEAPON);
    }

    /**
     * Calculates the probability that the item stack is
     * of the type melee weapon
     *
     * @param stack the item stack
     * @return an item in the range of 0-1, with:
     * <p>swords falling in the range of 0.9-1 depending on the material of the sword/enchantment</p>
     * <p>items falling in the range of 0.9-0.85 if enchanted with a damage dealing enchantment (sharpness)</p>
     * <p>tools falling in the range of 0.6-0.85 depending on the material of the too and the type of tool</p>
     * <p>items falling in the range of 0.4-0.6 depending on their enchantments</p>
     */
    @Override
    public double typeProbability(ItemStack stack) {
        double score = swordScore(stack);
        if(score != 0d) {
            System.out.println("SWORD_SCORE:" + score);
            return score;
        }

        score = sharpItemScore(stack);
        if(score != 0d) {
            return score;
        }

        score = toolWeaponScore(stack);
        if(score != 0d) {
            System.out.println("TOOL_SCORE: " + score);
            return score;
        }

        score = miscCombatEnchant(stack);
        return score;
    }

    private double swordScore(ItemStack stack) {
        if(!stack.getType().name().toUpperCase().endsWith("_SWORD")) {
            return 0d;
        }

        return 0.9 + InferenceParser.parsers().needScore(ItemType.TOOL_TYPE, stack) * 0.05 + 0.2 * stack.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
    }

    private double sharpItemScore(ItemStack stack) {
        int level = stack.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
        if(level == 0) {
            return 0d;
        }

        return 0.85 + 0.02 * level;
    }

    private double toolWeaponScore(ItemStack stack) {
        ProbabilityMatrix matrix = InferenceParser.parsers().needItem(ItemType.TOOL).matrix(stack);
        if(matrix.weight(ItemType.TOOL) == 0) {
            return 0d;
        }

        double extra = 0d;
        if(matrix.weight(ItemType.AXE) > 0) {
            extra = 0.03;
        }
        else if(matrix.weight(ItemType.PICKAXE) > 0) {
            extra = 0.02;
        }
        else if(matrix.weight(ItemType.SHOVEL) > 0 || matrix.weight(ItemType.HOE) > 0) {
            extra = 0.015;
        }

        return 0.6 + (matrix.weight(ItemType.TOOL) * 0.2) + extra;
    }

    private double miscCombatEnchant(ItemStack stack) {
        int knockback = stack.getEnchantmentLevel(Enchantment.KNOCKBACK);
        int fire = stack.getEnchantmentLevel(Enchantment.FIRE_ASPECT);

        if(knockback == 0 && fire == 0) {
            return 0d;
        }

        return 0.4 + 0.2 * fire + 0.2 * knockback;
    }
}
