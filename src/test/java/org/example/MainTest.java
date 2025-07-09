package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main inventory;
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        inventory = new Main();
        inventory.addProduct("Cheese", 20);
        inventory.addProduct("Milk", 20);
        inventory.addProduct("Bread", 10);
        inventory.addProduct("Eggs", 25);
        System.setOut(new PrintStream(outStream));
    }

    @Test
    void testAddProductShouldBeValid() {
        String actual = inventory.addProduct("Banana", 30);
        assertEquals(30, inventory.getQuantity("Banana"));
        assertEquals(true, inventory.hasProduct("Banana"));
        assertEquals("Product added!", actual);
    }

    @Test
    void testAddProductWithZeroQuantityAndAddingExistingProduct() {
        String actual = inventory.addProduct("Mango", 0);
        assertEquals(false, inventory.hasProduct("Mango"));
        assertEquals("Not a valid quantity.", actual);
        String actual2 = inventory.addProduct("Milk", 50);
        assertEquals(50, inventory.getQuantity("Milk"));
        assertEquals(true, inventory.hasProduct("Milk"));
        assertEquals("Product already exists in the inventory. Updating quantity...", actual2);
    }

    @Test
    void testCheckingForExistingAndNonExistingProduct() {
        String actual = inventory.checkProduct("Milk");
        assertEquals(true, inventory.hasProduct("Milk"));
        assertEquals("Milk is in stock: 20", actual);
        String actual2 = inventory.checkProduct("Ice Cream");
        assertEquals(false, inventory.hasProduct("Ice Cream"));
        assertEquals("Product not found.", actual2);
    }

    @Test
    void testUpdateExistingAndNonExistingProduct() {
        String actual = inventory.updateProduct("Bread", 25);
        assertEquals(true, inventory.hasProduct("Bread"));
        assertEquals(25, inventory.getQuantity("Bread"));
        assertEquals("Stock updated!", actual);
        String actual2 = inventory.updateProduct("Tofu", 10);
        assertEquals(false, inventory.hasProduct("Tofu"));
        assertEquals("Product not found.", actual2);
    }

    @Test
    void testRemoveExistingAndNonExistingProduct() {
        String actual = inventory.removeProduct("Eggs");
        assertEquals(false, inventory.hasProduct("Eggs"));
        assertEquals("Product removed.", actual);
        String actual2 = inventory.removeProduct("Pizza");
        assertEquals(false, inventory.hasProduct("Pizza"));
        assertEquals("Product not found.", actual2);
    }

    @Test
    void testViewInventoryPrintsCorrectOutput() {
        inventory.viewInventory();

        String output = outStream.toString().trim();
        assertTrue(output.contains("Cheese - 20pcs"));
        assertTrue(output.contains("Milk - 20pcs"));
        assertTrue(output.contains("Bread - 10pcs"));
        assertTrue(output.contains("Eggs - 25pcs"));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}