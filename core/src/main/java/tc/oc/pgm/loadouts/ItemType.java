package tc.oc.pgm.loadouts;

public enum ItemType {

    FOOD,
    HEAL,
    MELEE_WEAPON,
    RANGED,
    ARROW,
    BLOCK,
    TOOL,
    PICKAXE(TOOL),
    SHOVEL(TOOL),
    AXE(TOOL),
    HOE(TOOL),
    TOOL_TYPE;

    private final ItemType parent;

    ItemType() {
        this.parent = null;
    }

    ItemType(ItemType parent) {
        this.parent = parent;
    }
}
