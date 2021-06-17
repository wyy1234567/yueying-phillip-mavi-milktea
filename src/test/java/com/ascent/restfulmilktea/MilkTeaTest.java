package com.ascent.restfulmilktea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class MilkTeaTest {

    private MilkTea milkTea;

    @BeforeEach
    void setUp() {
        milkTea = new MilkTea();
    }

    @Test
    @DisplayName("MilkTea should be created with name and price")
    void shouldInitializedWithNameAndPrice() {
        MilkTea milkTea = new MilkTea("Jasmine Milk Tea", "$5.5");
        assertNotNull(milkTea.getName(), "Milk Tea is initialized with name");
        assertNotNull(milkTea.getPrice(), "Milk Tea is initialized with price");
    }

    @Test
    @DisplayName("MilkTea can set its name")
    void shouldSetItsName() {
        milkTea.setName("Jasmine Milk Tea");
        assertEquals("Jasmine Milk Tea", milkTea.getName());
    }

    @Test
    @DisplayName("MilkTea can set its price")
    void shouldSetItsPrice() {
        milkTea.setPrice("$5.5");
        assertEquals("$5.5", milkTea.getPrice());
    }

    @Test
    @DisplayName("MilkTea can set its ID")
    void shouldSetItsID() {
        milkTea.setId(1L);
        assertEquals(1L, milkTea.getId());
    }

    @Test
    @DisplayName("MilkTea can set its ingredients")
    void shouldSetItsIngredients() {
        milkTea.setIngredients(new ArrayList<String>(Arrays.asList("Tea",
                "Milk", "Sugar", "Cream")));
        assertEquals(new ArrayList<String>(Arrays.asList("Tea",
                "Milk", "Sugar", "Cream")), milkTea.getIngredients());
    }

    @Test
    @DisplayName("MilkTea can set its toppings")
    void shouldSetItsToppings() {
        milkTea.setToppings(new ArrayList<String>(Arrays.asList("Boba",
                "Cheese")));
        assertEquals(new ArrayList<String>(Arrays.asList("Boba",
                "Cheese")), milkTea.getToppings());
    }

    @Test
    @DisplayName("MilkTea can set its caffeinated value")
    void shouldSetItsCaffeinated() {
        milkTea.setCaffeinated(true);
        assertTrue(milkTea.isCaffeinated());
    }

    @Test
    @DisplayName("MilkTea can set its size")
    void shouldSetItsSize() {
        milkTea.setSize("Medium");
        assertEquals("Medium", milkTea.getSize());
    }
}
