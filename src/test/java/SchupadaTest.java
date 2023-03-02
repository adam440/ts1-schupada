import cz.cvut.fel.ts1.Schupada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SchupadaTest {
    @Test
    public void factorialTest() {
        Assertions.assertEquals(2, Schupada.factorial(2));
    }
}