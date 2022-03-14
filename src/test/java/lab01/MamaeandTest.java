package lab01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MamaeandTest {

    @Test
    public void factorialTest(){

        Assertions.assertEquals(1, Mamaeand.factorialRecursive(1));
    }
}
