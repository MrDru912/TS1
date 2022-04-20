import archive.ItemPurchaseArchiveEntry;
import archive.PurchasesArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;
import shop.StandardItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PurchasesArchiveTest {
    HashMap<Integer, ItemPurchaseArchiveEntry> itemPurchaseArchive;

    StandardItem standardItem;
    StandardItem standardItem2;
    PurchasesArchive purchasesArchive;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;

    ArrayList<Order> orderArchive;

    @BeforeEach
    public void setPurchasesArchive() {
        System.setOut(new PrintStream(outContent));
        itemPurchaseArchive = new HashMap<>();
        orderArchive = new ArrayList<>();
        standardItem = new StandardItem(1, "basketball ball", 300, "sport", 10);
        standardItem2 = new StandardItem(2, "iphone 11", 1000, "mobiles", 100);
        itemPurchaseArchive.put(standardItem.getID(), new ItemPurchaseArchiveEntry(standardItem));
        itemPurchaseArchive.put(standardItem2.getID(), new ItemPurchaseArchiveEntry(standardItem2));
        purchasesArchive = new PurchasesArchive(itemPurchaseArchive, orderArchive);

    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printItemPurchaseStatisticsTest() {
        purchasesArchive.printItemPurchaseStatistics();
        String expected = "ITEM PURCHASE STATISTICS:\n" +
                "ITEM  Item   ID 1   NAME basketball ball   CATEGORY sport   PRICE 300.0   LOYALTY POINTS 10   HAS BEEN SOLD 1 TIMES\n" +
                "ITEM  Item   ID 2   NAME iphone 11   CATEGORY mobiles   PRICE 1000.0   LOYALTY POINTS 100   HAS BEEN SOLD 1 TIMES\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void getHowManyTimesHasBeenItemSold() {
        ItemPurchaseArchiveEntry i = itemPurchaseArchive.get(1);
        assertEquals(i.getCountHowManyTimesHasBeenSold(), 1);
    }

    @Test
    public void putOrderToPurchasesArchiveContainsNewItemTest() {
        int itemId = 3;
        ArrayList<Item> items = new ArrayList<>();
        Order order = new Order(new ShoppingCart(items), "Andrei", "Prazska 11");
        StandardItem standardItem3 = new StandardItem(itemId, "football ball", 300, "sport", 10);
        items.add(standardItem3);
        purchasesArchive.putOrderToPurchasesArchive(order);
        assertEquals(standardItem3, itemPurchaseArchive.get(itemId).getRefItem());
    }

    @Test
    public void putOrderToPurchasesArchiveOldItemHasIncrementedBuysTest() {
        int expectedCountHowManyTimesHasBeenSold = 2;
        int itemId = 4;
        ArrayList<Item> items = new ArrayList<>();
        Order order = new Order(new ShoppingCart(items), "Andrei", "Prazska 11");
        StandardItem standardItem3 = new StandardItem(itemId, "tennis racket", 300, "sport", 10);
        items.add(standardItem3);
        purchasesArchive.putOrderToPurchasesArchive(order);
        purchasesArchive.putOrderToPurchasesArchive(order);
        assertEquals(expectedCountHowManyTimesHasBeenSold, itemPurchaseArchive.get(itemId).getCountHowManyTimesHasBeenSold());
    }

    @Test
    public void constructorItemPurchaseArchiveEntrySoldCountEqualsOneAtBeginningTest() {
        Item standardItem = new StandardItem(1, "basketball ball", 300, "sport", 10);
        ItemPurchaseArchiveEntry mockEntry = new ItemPurchaseArchiveEntry(standardItem);
        assertEquals(1,mockEntry.getCountHowManyTimesHasBeenSold());
    }

    @Test
    public void constructorItemPurchaseArchiveEntryRefItemTest() {
        Item standardItem = new StandardItem(1, "basketball ball", 300, "sport", 10);
        ItemPurchaseArchiveEntry mockEntry = new ItemPurchaseArchiveEntry(standardItem);
        assertEquals(standardItem,mockEntry.getRefItem());
    }

    @Test
    public void mockGetRefItemItemPurchaseArchiveEntryTest() {
        ItemPurchaseArchiveEntry itemPurchaseArchiveEntry = Mockito.mock(ItemPurchaseArchiveEntry.class);
        itemPurchaseArchiveEntry.getRefItem();
        verify(itemPurchaseArchiveEntry).getRefItem();
    }

    @Test
    public void mockIncreaseCount2TimesItemPurchaseArchiveEntryTest(){
        ItemPurchaseArchiveEntry itemPurchaseArchiveEntry = Mockito.mock(ItemPurchaseArchiveEntry.class);
        itemPurchaseArchiveEntry.getCountHowManyTimesHasBeenSold();
        itemPurchaseArchiveEntry.getCountHowManyTimesHasBeenSold();
        verify(itemPurchaseArchiveEntry,times(2)).getCountHowManyTimesHasBeenSold();
    }

    @Test
    public void mockAddOrderArchiveTest() {
        ArrayList<Item> items = new ArrayList<>();
        Order order = new Order(new ShoppingCart(items), "Andrei", "Prazska 11");
        ArrayList<Order> orderArchive = Mockito.mock(ArrayList.class);
        orderArchive.add(order);
        verify(orderArchive).add(Mockito.any());
    }

    @Test
    public void mockRemoveOrderArchiveTest() {
        ArrayList<Item> items = new ArrayList<>();
        Order order = new Order(new ShoppingCart(items), "Andrei", "Prazska 11");
        ArrayList<Order> orderArchive = Mockito.mock(ArrayList.class);
        orderArchive.remove(order);
        verify(orderArchive).remove(Mockito.any());
    }

    @Test
    public void mockSizeOrderArchiveTest() {
        ArrayList<Order> orderArchive = Mockito.mock(ArrayList.class);
        orderArchive.size();
        verify(orderArchive).size();
    }


}