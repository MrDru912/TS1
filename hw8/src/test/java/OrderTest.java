import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;
import shop.StandardItem;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    ArrayList<Item> items;
    String customerName;
    String customerAddress;
    int state;
    Order order;
    Order order2;

    @BeforeEach
    public void setOrder() {
        items = new ArrayList<>();
        items.add(new StandardItem(1,"basketball ball",100,"sport",10));
        items.add(new StandardItem(1,"baseball ball",150,"sport",20));
        customerName = "Michal Jordan";
        customerAddress = "Prazska 11";
        state = 0;
        order = new Order(new ShoppingCart(items),"Michal Jordan","Prazska 11");
        order2 = new Order(new ShoppingCart(null),null,null);
    }

    @Test
    public void constructorShoppingCartParamTest() {
        assertEquals(order.getItems(), items);
    }
    @Test
    public void constructorCustomerNameParamTest(){
        assertEquals(order.getCustomerName(), customerName);
    }
    @Test
    public void constructorCustomerAddressParamTest(){
        assertEquals(order.getCustomerAddress(), customerAddress);
    }

    @Test
    public void constructorStateParamTest(){
        assertEquals(order.getState(), state);
    }

    @Test
    public void constructorItemsNullParamTest(){
        assertEquals(order2.getItems(), null);
    }

    @Test
    public void constructorCustomerNameNullParamTest(){
        assertEquals(order2.getCustomerName(), null);

    }
    @Test
    public void constructorCustomerAddressNullParamTest(){
        assertEquals(order2.getCustomerAddress(), null);
    }

}
