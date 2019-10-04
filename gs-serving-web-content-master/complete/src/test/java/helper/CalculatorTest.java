package helper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
      Calculator c = new Calculator();
      int sum = c.add(2,3);
      assertEquals(5, sum);
    }
}
