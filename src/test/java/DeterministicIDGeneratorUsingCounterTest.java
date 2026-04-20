import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeterministicIDGeneratorUsingCounterTest {

    @Test
    public void idGeneratorCreatesDeterministicIDs() {
        // arrange
        String seed = "myconstantseedstring";
        IDGeneration instance1 = IDGeneratorFactory.createGenerator(IDGeneratorFactory.GeneratorType.DETERMINISTIC_WITH_COUNTER, seed);
        IDGeneration instance2 = IDGeneratorFactory.createGenerator(IDGeneratorFactory.GeneratorType.DETERMINISTIC_WITH_COUNTER, seed);

        // act
        UUID uuid1 = instance1.generateID();
        UUID uuid2 = instance2.generateID();

        // assert
        assertEquals(uuid1.toString(), uuid2.toString());
    }

    @Test
    public void idGeneratorCreatesDifferentIDsInTwoCalls() {
        // arrange
        String seed = "myconstantseedstring";
        IDGeneration instance = IDGeneratorFactory.createGenerator(IDGeneratorFactory.GeneratorType.DETERMINISTIC_WITH_COUNTER, seed);

        // act
        UUID uuid1 = instance.generateID();
        UUID uuid2 = instance.generateID();

        // assert
        assertNotEquals(uuid1.toString(), uuid2.toString());
    }

}