import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Order;
import shop.ShoppingCart;

public class OrderTest {
    Order order1 = new Order(new ShoppingCart(null), "Novak", "Adresa");
    Order order2 = new Order(new ShoppingCart(null), "Novak", "Adresa", 1);
    Order orderNull = new Order(new ShoppingCart(null), null, null);

    @Test
    public void OrderTest_Constructor() {
        Assertions.assertEquals(null, order1.getItems());
        Assertions.assertEquals("Novak", order1.getCustomerName());
        Assertions.assertEquals("Adresa", order1.getCustomerAddress());
        Assertions.assertEquals(null, order2.getItems());
        Assertions.assertEquals("Novak", order2.getCustomerName());
        Assertions.assertEquals("Adresa", order2.getCustomerAddress());
        Assertions.assertEquals(1, order2.getState());
        Assertions.assertEquals(null, orderNull.getItems());
        Assertions.assertEquals(null, orderNull.getCustomerName());
        Assertions.assertEquals(null, orderNull.getCustomerAddress());
    }
}
