import archive.ItemPurchaseArchiveEntry;
import archive.PurchasesArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shop.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class PurchasesArchiveTest extends PurchasesArchive {
    PurchasesArchive purchasesArchive;
    ItemPurchaseArchiveEntry itemPurchaseArchiveEntry;
    private ArrayList<Order> mockOrderArchive;
    private HashMap<Integer, ItemPurchaseArchiveEntry> mockItemPurchaseArchive;
    StandardItem standardItem = new StandardItem(1, "polozka", 5.5f, "kategorie", 10);
    ShoppingCart shoppingCart = new ShoppingCart();
    Order order1;

    public PurchasesArchiveTest() {
        shoppingCart.addItem(standardItem);
        order1 = new Order(shoppingCart, "Novak", "Adresa");
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        mockOrderArchive = Mockito.mock(ArrayList.class);
        mockItemPurchaseArchive = Mockito.mock(HashMap.class);
        purchasesArchive = Mockito.mock(new PurchasesArchive(mockItemPurchaseArchive, mockOrderArchive).getClass());

        itemPurchaseArchiveEntry = new ItemPurchaseArchiveEntry(standardItem);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void itemPurchaseArchiveEntry_Constructor() {
        Assertions.assertEquals(standardItem, itemPurchaseArchiveEntry.getRefItem());
    }

    @Test
    public void printItemPurchaseStatistics_test() {
        purchasesArchive.printItemPurchaseStatistics();
        Assertions.assertEquals("ITEM PURCHASE STATISTICS:\r\n", outputStreamCaptor.toString());
    }

    @Test
    public void getHowManyTimesHasBeenItemSold_test() {
        int timesSold = purchasesArchive.getHowManyTimesHasBeenItemSold(standardItem);
        Assertions.assertEquals(0, timesSold);
    }

    @Test
    public void putOrderToPurchasesArchive_test() {
        purchasesArchive.putOrderToPurchasesArchive(order1);
        Mockito.verify(purchasesArchive).putOrderToPurchasesArchive(order1);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
