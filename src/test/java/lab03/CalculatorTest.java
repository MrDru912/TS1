package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void addTest() {
        Calculator c = new Calculator();
        Assertions.assertEquals(4, c.add(2,2));
    }
    @Test
    public void substractTest() {
        Calculator c = new Calculator();
        Assertions.assertEquals(0, c.subtract(3,2));
    }    @Test
    public void multTest() {
        Calculator c = new Calculator();
        Assertions.assertEquals(4, c.multiply(2,2));
    }    @Test
    public void devideTest() {
        Calculator c = new Calculator();
        Assertions.assertEquals(1, c.divide(2,2));
    }
}
