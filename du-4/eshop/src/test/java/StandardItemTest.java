import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import shop.StandardItem;

import java.util.stream.Stream;

public class StandardItemTest {

    StandardItem standardItem = new StandardItem(1, "polozka", 5.5f, "kategorie", 10);
    StandardItem standardItem2 = standardItem.copy();

    @Test
    public void StandardItem_Constructor() {
        Assertions.assertEquals(1, standardItem.getID());
        Assertions.assertEquals("polozka", standardItem.getName());
        Assertions.assertEquals(5.5f, standardItem.getPrice());
        Assertions.assertEquals("kategorie", standardItem.getCategory());
        Assertions.assertEquals(10, standardItem.getLoyaltyPoints());
    }

    @Test
    public void StandardItem_copy() {
        Assertions.assertEquals(standardItem2, standardItem.copy());
    }


    static Stream<Arguments> equalsTestCases() {
        StandardItem item1 = new StandardItem(1, "polozka", 5.5f, "kategorie", 10);
        StandardItem item2 = new StandardItem(1, "polozka", 5.5f, "kategorie", 10);
        StandardItem item3 = new StandardItem(3, "polozka3", 5.5f, "kategorie3", 10);

        return Stream.of(
                Arguments.of(item1, item1, true),
                Arguments.of(item1, item2, true),
                Arguments.of(item1, item3, false),
                Arguments.of(item1, null, false),
                Arguments.of(item1, "Some string", false)
        );
    }

    @ParameterizedTest
    @MethodSource("equalsTestCases")
    void testEquals(StandardItem item1, Object item2, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, item1.equals(item2));
    }
}
