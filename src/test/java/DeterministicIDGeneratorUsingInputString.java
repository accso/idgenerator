import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeterministicIDGeneratorUsingInputStringTest {
    private record MyData(Integer i, String s) {}

    @Test
    public void idGeneratorCreatesDifferentIDsInTwoCallsBasedOnDifferentInput() {
        // arrange
        MyData myData          = new MyData(1, "mydata123");
        MyData differentMyData = new MyData(2, "mydata456");

        String seed = "myconstantseedstring";
        IDGeneration instance = IDGeneratorFactory.createGenerator(IDGeneratorFactory.GeneratorType.DETERMINISTIC_BASED_ON_INPUT, seed);

        // act
        UUID uuid1 = instance.generateID(myData);
        UUID uuid2 = instance.generateID(differentMyData);

        // assert
        assertNotEquals(uuid1.toString(), uuid2.toString());
    }

    @Test
    public void idGeneratorCreatesSameIDsInTwoCallsForSameInput() {
        // arrange
        MyData myData     = new MyData(1, "mydata123");
        MyData sameMyData = new MyData(1, "mydata123");

        String seed = "myconstantseedstring";
        IDGeneration instance = IDGeneratorFactory.createGenerator(IDGeneratorFactory.GeneratorType.DETERMINISTIC_BASED_ON_INPUT, seed);

        // act
        UUID uuid1 = instance.generateID(myData);
        UUID uuid2 = instance.generateID(myData);

        // assert
        assertEquals(uuid1.toString(), uuid2.toString());
    }

}