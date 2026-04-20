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

    @Test
    public void idGeneratorCreatesDifferentIDsInTwoCallsBasedOnDifferentInput() {
        // arrange
        record MyData(Integer i, String s) {}

        String seed = "myconstantseedstring";
        IDGeneration instance = new DeterministicIDGenerator(seed);

        // act
        MyData myData1 = new MyData(1, "mydata123");
        UUID uuid1 = instance.generateID(""+myData1.hashCode());;
        MyData myData2 = new MyData(12, "mydata456");
        UUID uuid2 = instance.generateID(""+myData2.hashCode());

        // assert
        assertNotEquals(uuid1.toString(), uuid2.toString());
    }

    @Test
    public void idGeneratorCreatesSameIDsInTwoCallsForSameInput() {
        // arrange
        record MyData(Integer i, String s) {}

        String seed = "myconstantseedstring";
        IDGeneration instance = new DeterministicIDGenerator(seed);

        // act
        MyData myData1 = new MyData(1, "mydata123");
        UUID uuid1 = instance.generateID(""+myData1.hashCode());;
        MyData myData2 = new MyData(1, "mydata123");
        UUID uuid2 = instance.generateID(""+myData2.hashCode());

        // assert
        assertEquals(uuid1.toString(), uuid2.toString());
    }

}