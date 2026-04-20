import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RandomIDGeneratorTest {

    @Test
    public void idGeneratorCreateDifferentIDs() {
        // arrange
        IDGeneration instance = new RandomIDGenerator();

        // act
        UUID uuid1 = instance.generateID();
        UUID uuid2 = instance.generateID();

        // assert
        assertNotEquals(uuid1, uuid2);
    }

    @Test
    public void twoIDGeneratorsCreateDifferentIDs() {
        // arrange
        IDGeneration instance1 = new RandomIDGenerator();
        IDGeneration instance2 = new RandomIDGenerator();

        // act
        UUID uuid1 = instance1.generateID();
        UUID uuid2 = instance2.generateID();

        // assert
        assertNotEquals(uuid1, uuid2);
        assertNotEquals(uuid1.toString(), uuid2.toString());
    }
}