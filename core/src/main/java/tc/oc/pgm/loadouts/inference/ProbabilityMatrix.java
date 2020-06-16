package tc.oc.pgm.loadouts.inference;

import com.google.common.collect.Maps;
import tc.oc.pgm.loadouts.ItemType;

import java.util.Map;
import java.util.Optional;

public interface ProbabilityMatrix {

    double weight(ItemType type);

    Map<ItemType, Double> weights();

    ItemType maxWeighted();

    default Optional<ItemType> maxWeightedAbove(double weight) {
        ItemType max = maxWeighted();
        if(max != null && weight(max) >= weight) {
            return Optional.of(max);
        }

        return Optional.empty();
    }

    static ProbabilityMatrix singleProbability(ItemType type, double probability) {
        Map<ItemType, Double> matrix = Maps.newHashMap();
        matrix.put(type, probability);
        return MapProbabilityMatrix.of(matrix);
    }
}
