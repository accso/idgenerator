import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class DeterministicIDGeneratorUsingInputString implements IDGeneration {

    private final String seed;

    public DeterministicIDGeneratorUsingInputString(String seed) {
        this.seed = seed;
    }

    public UUID generateID() {
        return generateID(null);
    }

    @Override
    public UUID generateID(Object input) {
        Integer inputHash = HashCodeBuilder.reflectionHashCode(input);
        return UUID.nameUUIDFromBytes((seed + inputHash).getBytes());
    }
}