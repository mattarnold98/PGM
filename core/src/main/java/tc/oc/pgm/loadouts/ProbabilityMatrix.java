package tc.oc.pgm.loadouts;

import com.google.common.collect.Maps;

import java.util.Map;

public interface ProbabilityMatrix {

    double weight(ItemType type);

    Map<ItemType, Double> weights();

    static ProbabilityMatrix singleProbability(ItemType type, double probability) {
        Map<ItemType, Double> matrix = Maps.newHashMap();
        matrix.put(type, probability);
        return MapProbabilityMatrix.of(matrix);
    }
}
