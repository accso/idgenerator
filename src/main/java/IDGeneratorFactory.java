public final class IDGeneratorFactory {

    public enum GeneratorType {
        RANDOM,
        DETERMINISTIC
    }

    public static IDGeneration createGenerator(GeneratorType type, String... seed) {
        return switch (type) {
            case RANDOM -> new RandomIDGenerator();
            case DETERMINISTIC -> new DeterministicIDGenerator(seed[0]);
            default -> throw new IllegalArgumentException("unknown type");
        };
    }
}