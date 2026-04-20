import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeterministicIDGeneratorTest {

    @Test
    public void idGeneratorCreatesDeterministicIDs() {
        // arrange
        String seed = "myconstantseedstring";
        IDGeneration instance1 = new DeterministicIDGenerator(seed);
        IDGeneration instance2 = new DeterministicIDGenerator(seed);

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
        IDGeneration instance = new DeterministicIDGenerator(seed);

        // act
        UUID uuid1 = instance.generateID();
        UUID uuid2 = instance.generateID();

        // assert
        assertNotEquals(uuid1.toString(), uuid2.toString());
    }

}