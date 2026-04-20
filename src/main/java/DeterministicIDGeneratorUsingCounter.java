import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class DeterministicIDGeneratorUsingCounter implements IDGeneration {

    private final String seed;
    private final AtomicInteger counter = new AtomicInteger(0);

    public DeterministicIDGeneratorUsingCounter(String seed) {
        this.seed = seed;
    }

    /** creates deterministic IDs, different for each call, depends on the order of calls */

    @Override
    public UUID generateID() {
        int i = counter.incrementAndGet();
        return UUID.nameUUIDFromBytes((seed + i).getBytes());
    }

    @Override
    public UUID generateID(Object input) {
        return generateID();
    }
}