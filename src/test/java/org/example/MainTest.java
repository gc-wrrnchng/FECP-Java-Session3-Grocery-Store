package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private String name;
    private int quantity;
    private Main inventory;

    @BeforeEach
    void setup() {
        inventory = new Main();
        inventory.addProduct("Cheese", 20);
        inventory.addProduct("Milk", 20);
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
        assertEquals("Milk is in stock: 20", actual);
        String actual2 = inventory.checkProduct("Ice Cream");
        assertEquals("Product not found.", actual2);
    }
}