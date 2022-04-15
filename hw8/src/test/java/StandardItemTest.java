import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.StandardItem;

import static org.junit.jupiter.api.Assertions.*;

public class StandardItemTest {

    StandardItem standardItem;
    int id = 1;
    String name = "basketball ball";
    float price = 300;
    String category = "sport";
    int loyaltyPoints = 10;
    StandardItem copyItem;

    @BeforeEach
    public void setStandardItem() {
        standardItem = new StandardItem(id,name,price,category,loyaltyPoints);
        copyItem = standardItem.copy();
    }

    @Test
    public void constructorIDParamTest(){
        assertEquals(standardItem.getID(), id);
    }
    @Test
    public void constructorNameParamTest(){
        assertEquals(standardItem.getName(), name);
    }
    @Test
    public void constructorPriceParamTest(){
        assertEquals(standardItem.getPrice(), price);
    }
    @Test
    public void constructorCategoryParamTest(){
        assertEquals(standardItem.getCategory(), category);
    }
    @Test
    public void constructorLoyaltyPointsParamTest(){
        assertEquals(standardItem.getLoyaltyPoints(), loyaltyPoints);
    }

    @Test
    public void copyIDTest(){
        assertEquals(standardItem.getLoyaltyPoints(), copyItem.getLoyaltyPoints());
    }
    @Test
    public void copyNameTest(){
        assertEquals(standardItem.getName(), copyItem.getName());
    }
    @Test
    public void copyPriceTest(){
        assertEquals(standardItem.getPrice(), copyItem.getPrice());
    }
    @Test
    public void copyCategoryTest(){
        assertEquals(standardItem.getCategory(), copyItem.getCategory());
    }
    @Test
    public void copyLoyaltyPointsTest(){
        assertEquals(standardItem.getLoyaltyPoints(), copyItem.getLoyaltyPoints());
    }

    @ParameterizedTest(name = "{0} multiple {1} should be equal to {2}")
    @CsvSource({"1, ball, 100, sport, 10, 1, ball, 100, sport, 10, true",
            "2, racket, 500, sport, 20, 2, ball, 500, sport, 20, false"})
    public void equalsTest(int id, String name, float price, String category, int loyaltyPoints,
                           int id2, String name2, float price2, String category2, int loyaltyPoints2,
                           boolean res
                           ){
        StandardItem standardItem = new StandardItem(id,name, price, category, loyaltyPoints);
        StandardItem standardItem2 = new StandardItem(id2,name2, price2, category2, loyaltyPoints2);
        Assertions.assertEquals(standardItem.equals(standardItem2),res);

    }

}
