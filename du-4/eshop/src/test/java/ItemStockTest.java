import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.StandardItem;
import storage.ItemStock;

public class ItemStockTest {

    StandardItem standardItem = new StandardItem(1, "polozka", 5.5f, "kategorie", 10);
    ItemStock itemStock = new ItemStock(standardItem);

    @Test
    public void ItemStock_Constructor() {
        Assertions.assertEquals(standardItem, itemStock.getItem());
        Assertions.assertEquals(0, itemStock.getCount());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 5, 5",
            "10, 5, 15",
            "20, -5, 15"
    })
    void testIncreaseItemCount(int initialCount, int increaseBy, int expectedCount) {
        itemStock.IncreaseItemCount(increaseBy);
        Assertions.assertEquals(expectedCount, itemStock.getCount());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "10, 10, 0",
            "20, -5, 25"
    })
    void testDecreaseItemCount(int initialCount, int decreaseBy, int expectedCount) {
        itemStock.decreaseItemCount(decreaseBy);
        Assertions.assertEquals(expectedCount, itemStock.getCount());
    }
}
