import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.Item;
import shop.StandardItem;
import storage.ItemStock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemStockTest {
    int id = 1;
    String name = "basketball ball";
    float price = 300;
    String category = "sport";
    int loyaltyPoints = 10;
    Item refItem;
    int count = 5;
    ItemStock itemStock;

    @BeforeEach
    public void setItemStock() {
        refItem = new StandardItem(id,name,price,category,loyaltyPoints);
        itemStock = new ItemStock(refItem);
    }

    @Test
    public void constructorRefItemParamTest(){
        assertEquals(itemStock.getItem(), refItem);
    }

    @Test
    public void constructorCountNotSetParamTest(){
        assertEquals(itemStock.getCount(), 0);
    }


    @ParameterizedTest(name = "increase count once")
    @CsvSource({"5, 5","6, 6"})
    public void increaseItemCountTest(int incrOnX, int res){
        ItemStock itemStock = new ItemStock(refItem);
        itemStock.IncreaseItemCount(incrOnX);
        assertEquals(itemStock.getCount(),res);
    }

    @ParameterizedTest(name = "{0} increase count by {1} should be equal to {2}")
    @CsvSource({"5, 6, 11","6, 10, 16"})
    public void doubleIncreaseItemCountTest(int incrOnX,int incrOnX2, int res){
        ItemStock itemStock = new ItemStock(refItem);
        itemStock.IncreaseItemCount(incrOnX);
        itemStock.IncreaseItemCount(incrOnX2);
        assertEquals(itemStock.getCount(),res);
    }


    @ParameterizedTest(name = "{0} increase count by {1} should be equal to {2}")
    @CsvSource({"6, 5, 1","10, 6, 4"})
    public void increaseDecreaseItemCountTest(int incrOnX,int decrOnX2, int res){
        ItemStock itemStock = new ItemStock(refItem);
        itemStock.IncreaseItemCount(incrOnX);
        itemStock.decreaseItemCount(decrOnX2);
        assertEquals(itemStock.getCount(),res);
    }

    @ParameterizedTest(name = "decrease count by {0} should be equal to {1}")
    @CsvSource({"6, 0","4, 0"})
    public void decreaseNegativeResItemCountTest(int decrOnX2, int res){
        ItemStock itemStock = new ItemStock(refItem);
        itemStock.decreaseItemCount(decrOnX2);
        assertEquals(itemStock.getCount(),res);
    }



}
