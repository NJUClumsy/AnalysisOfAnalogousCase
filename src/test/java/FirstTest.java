import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstTest {

    private First first;

    @Before
    public void setUp() throws Exception {
        first = new First();
    }

    @Test
    public void testHelloWorld() {
        String result = first.HelloWorld();
        assertEquals("The expected HelloWorld does not appear!", "HelloWorld", result);
    }

}