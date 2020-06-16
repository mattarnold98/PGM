package tc.oc.pgm.loadouts.inference;

import tc.oc.pgm.loadouts.ItemType;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class MapProbabilityMatrix implements ProbabilityMatrix {

    private final Map<ItemType, Double> map;

    private MapProbabilityMatrix(Map<ItemType, Double> map) {
        this.map = map;
    }

    public static MapProbabilityMatrix of(Map<ItemType, Double> map) {
        return new MapProbabilityMatrix(map);
    }

    public static MapProbabilityMatrix of(Collection<? extends ProbabilityMatrix> matrices) {
        //two possible strategies are using max value, or additional with a ceil of 1... for now just use max value in combination
        Map<ItemType, Double> newMap = new EnumMap<>(ItemType.class);

        for(ItemType type: ItemType.values()) {
            double max = 0;
            for(ProbabilityMatrix matrix: matrices) {
                double matrixV = matrix.weight(type);
                if(matrixV > max) {
                    max = matrixV;
                }
            }
            newMap.put(type, max);
        }

        return of(newMap);
    }

    @Override
    public double weight(ItemType type) {
        //get the weight for this item type or 0 (ie, no relation)
        return map.getOrDefault(type, 0D);
    }

    @Override
    public Map<ItemType, Double> weights() {
        return map;
    }

    @Override
    public ItemType maxWeighted() {
        double max = 0;
        //anything as the default maxType
        ItemType maxType = null;
        for (Map.Entry<ItemType, Double> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                maxType = entry.getKey();
                max = entry.getValue();
            }
        }

        return maxType;
    }
}
