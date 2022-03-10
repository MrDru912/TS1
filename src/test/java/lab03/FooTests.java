package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTests {

    @Test
    public void returnNumberTest() {
        Foo foo = new Foo();
//        assert foo.returnNumber() == 5;
        Assertions.assertEquals(4, foo.returnNumber());
    }
}
