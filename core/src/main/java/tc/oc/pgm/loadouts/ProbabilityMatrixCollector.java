package tc.oc.pgm.loadouts;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProbabilityMatrixCollector implements Collector<ProbabilityMatrix, List<ProbabilityMatrix>, ProbabilityMatrix> {

    public static ProbabilityMatrixCollector collector() {
        return new ProbabilityMatrixCollector();
    }

    @Override
    public Supplier<List<ProbabilityMatrix>> supplier() {
        return Lists::newArrayList;
    }

    @Override
    public BiConsumer<List<ProbabilityMatrix>, ProbabilityMatrix> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<ProbabilityMatrix>> combiner() {
        return (x, y) -> Stream.concat(x.stream(), y.stream()).collect(Collectors.toList());
    }

    @Override
    public Function<List<ProbabilityMatrix>, ProbabilityMatrix> finisher() {
        return MapProbabilityMatrix::of;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Sets.newHashSet(Characteristics.UNORDERED);
    }
}
