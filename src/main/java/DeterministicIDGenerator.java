import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class DeterministicIDGenerator implements IDGeneration {

    private final String seed;
    private final AtomicInteger counter = new AtomicInteger(0);

    public DeterministicIDGenerator(String seed) {
        this.seed = seed;
    }

    @Override
    public UUID generateID() {
        int i = counter.incrementAndGet();
        return UUID.nameUUIDFromBytes((seed + i).getBytes());
    }
}