import cz.cvut.fel.ts1.Pisnamar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PisnamarTest {
    @Test
    public void factorialTest() {
        long[] factorialResults = new long[] {1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600,
                6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L,
                121645100408832000L, 2432902008176640000L};
        for (int i = 0; i < factorialResults.length; i++) {
            Assertions.assertEquals(factorialResults[i], Pisnamar.factorial(i+1));
        }
    }
}
