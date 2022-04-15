import archive.PurchasesArchive;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import shop.*;
import storage.NoItemInStorage;
import storage.Storage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class EShopControllerTests {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;
    Item[] storageItems = {
            new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5),
            new StandardItem(2, "Dancing Panda v.3 with USB port", 6000, "GADGETS", 10),
            new StandardItem(3, "Screwdriver", 200, "TOOLS", 5),
            new DiscountedItem(4, "Star Wars Jedi buzzer", 500, "GADGETS", 30, "1.8.2013", "1.12.2013"),
            new DiscountedItem(5, "Angry bird cup", 300, "GADGETS", 20, "1.9.2013", "1.12.2013"),
            new DiscountedItem(6, "Soft toy Angry bird (size 40cm)", 800, "GADGETS", 10, "1.8.2013", "1.12.2013")
    };

    @BeforeEach
    public void initEShopControllerWithStorage(){
        System.setOut(new PrintStream(outContent));
        EShopController.startEShop();
        int[] itemCount = {10,10,4,5,10,2};

        // insert data to the storage
        for (int i = 0; i < storageItems.length; i++) {
            EShopController.getStorage().insertItems(storageItems[i], itemCount[i]);
        }
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void emptyShoppingCartProcessTest() throws NoItemInStorage {
        ShoppingCart newEmptyCart = new ShoppingCart();
        try {
            EShopController.purchaseShoppingCart(newEmptyCart, "Jarmila Novakova", "Spojovaci 23, Praha 3");
            String expected = "Error: shopping cart is empty\n";
            assertEquals(expected, outContent.toString());
        }catch (NoItemInStorage e){};
    }

    @Test
    public void addingAndRemovingItemsToShoppingCartTest() throws NoItemInStorage {
        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(storageItems[0]);
        newCart.addItem(storageItems[1]);
        newCart.addItem(storageItems[2]);
        newCart.addItem(storageItems[4]);
        newCart.removeItem(2);
        newCart.addItem(storageItems[5]);
        try {
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova", "Kosmonautu 25, Praha 8");
            String expected = "Item with ID 1 added to the shopping cart.\n" +
                    "Item with ID 2 added to the shopping cart.\n" +
                    "Item with ID 3 added to the shopping cart.\n" +
                    "Item with ID 5 added to the shopping cart.\n" +
                    "Item with ID 6 added to the shopping cart.\n";
            Assertions.assertEquals(expected, outContent.toString());
        }catch (NoItemInStorage e){};
    }

    @Test
    public void orderWasArchivedMockArchiveTest(){
        PurchasesArchive archive = Mockito.mock(PurchasesArchive.class);
        EShopController.setArchive(archive);

        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(storageItems[0]);
        newCart.addItem(storageItems[1]);
        newCart.removeItem(0);
        newCart.addItem(storageItems[2]);
        newCart.addItem(storageItems[4]);
        newCart.addItem(storageItems[5]);
        try {
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova", "Kosmonautu 25, Praha 8");
            verify(archive).putOrderToPurchasesArchive(Mockito.any());
        }catch (NoItemInStorage e){};
    }

    @Test
    public void orderWasProcessedMockStorageTest(){
        Storage storage = Mockito.mock(Storage.class);
        EShopController.setStorage(storage);

        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(storageItems[0]);
        newCart.addItem(storageItems[1]);
        newCart.removeItem(1);
        newCart.addItem(storageItems[2]);
        newCart.addItem(storageItems[4]);
        newCart.addItem(storageItems[5]);
        try {
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova", "Kosmonautu 25, Praha 8");
            verify(storage).processOrder(Mockito.any());
        }catch (NoItemInStorage e){};
    }

    @Test
    public void startEShopControllerTest(){
        EShopController.startEShop();
        assertTrue(EShopController.getStorage()!=null &&
                EShopController.getArchive()!=null &&
                EShopController.getCarts()!=null &&
                EShopController.getOrders()!=null);
    }

    @Test
    public void removeNonExistingItemFromCartTest(){
        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(storageItems[0]);
        newCart.addItem(storageItems[1]);
        newCart.removeItem(2);
        newCart.addItem(storageItems[4]);
        newCart.addItem(storageItems[5]);
        Assertions.assertEquals(4,newCart.getItemsCount());
    }

    @Test
    public void addSameItemFromCartTest(){
        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(storageItems[0]);
        newCart.addItem(storageItems[0]);
        Assertions.assertEquals(2,newCart.getItemsCount());
    }


}
