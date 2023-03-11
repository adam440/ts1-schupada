import hw2.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void add_MethodReturns5_5() {
        assertEquals(5, calculator.add(3,2));
    }
    @Test
    public void subtract_MethodReturns3_3() {
        assertEquals(3, calculator.subtract(5,2));
    }
    @Test
    public void multiply_MethodReturns25_25() {
        assertEquals(25, calculator.multiply(5,5));
    }
    @Test
    public void divide_MethodReturns5_5() throws Exception {
        assertEquals(5, calculator.divide(10,2));
    }
    @Test
    public void divide_MethodReturnsException_Exception() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0));
        assertEquals("ERROR: Division by zero!", exception.getMessage());
    }
}