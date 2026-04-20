import java.util.UUID;

public class RandomIDGenerator implements IDGeneration {

    public RandomIDGenerator () {
        // nope
    }

    @Override
    public UUID generateID() {
        return UUID.randomUUID();
    }

    @Override
    public UUID generateID(String input) {
        return generateID();
    }
}