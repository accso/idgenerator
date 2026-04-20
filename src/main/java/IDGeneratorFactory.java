public final class IDGeneratorFactory {

    public enum GeneratorType {
        RANDOM,
        DETERMINISTIC_WITH_COUNTER,
        DETERMINISTIC_BASED_ON_INPUT
    }

    public static IDGeneration createGenerator(GeneratorType type, String... seed) {
        return switch (type) {
            case RANDOM -> new RandomIDGenerator();
            case DETERMINISTIC_WITH_COUNTER -> new DeterministicIDGeneratorUsingCounter(seed[0]);
            case DETERMINISTIC_BASED_ON_INPUT -> new DeterministicIDGeneratorUsingInputString(seed[0]);
            default -> throw new IllegalArgumentException("unknown type");
        };
    }
}