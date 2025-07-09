package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.example.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private String name;
    private int quantity;

    @BeforeEach
    void setup() {
        HashMap<String, Integer> map = new HashMap<>();
    }

    @Test
    void testAddProductShouldBeValid() {
        String actual = addProduct("Banana", 10);
        assertEquals("Product added!", actual);
    }
}