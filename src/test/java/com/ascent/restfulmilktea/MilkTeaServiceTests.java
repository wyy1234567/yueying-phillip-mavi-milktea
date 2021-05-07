package com.ascent.restfulmilktea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MilkTeaServiceTests {

    MilkTeaService milkTeaService;

    private List<MilkTea> milkTeaList;

    @BeforeEach
    void setup() {
        milkTeaList = new ArrayList<>();
        milkTeaService = new MilkTeaService();
        MilkTea t1 = new MilkTea("Jasmine Tea", "$5.0");
        MilkTea t2 = new MilkTea("Classic Milk Tea", "$5.5");
        MilkTea t3 = new MilkTea("Hong Kong Milk Tea", "$6.0");
        MilkTea t4 = new MilkTea("Four Seasons Milk Tea", "$6.5");

        milkTeaService.addMilkTea(t1);
        milkTeaService.addMilkTea(t2);
        milkTeaService.addMilkTea(t3);
        milkTeaService.addMilkTea(t4);

        milkTeaList.add(t1);
        milkTeaList.add(t2);
        milkTeaList.add(t3);
        milkTeaList.add(t4);
    }

    @Test
    void findAllMilkTeas() {
        assertEquals(4, milkTeaService.findAllMilkTeas().size());
    }

    @Test
    void addMilkTea() {
        milkTeaService.addMilkTea(new MilkTea("3:15 PM Tea", "$1.0"));
        assertEquals(5, milkTeaService.findAllMilkTeas().size());
    }

    @Test
    void getById() {
        MilkTea expected = milkTeaList.get(0);
        expected.setId(1L);
        assertEquals(expected, milkTeaService.getMilkTeaById(1L));
    }

    @Test
    void updateMilkTea() {
        MilkTea hongKong = milkTeaService.getMilkTeaById(2L);
        Map<String, Object> updatePayload = new HashMap<String, Object>();
        updatePayload.put("name", "3:15PM Tea");
        milkTeaService.updateMilkTea(hongKong, updatePayload);
        assertEquals("3:15PM Tea", hongKong.getName());
    }

//    @Test
//    void getByName() {
//        MilkTea actual = milkTeaList.get(5);
//        assertEquals(actual, milkTeaService.getByName(actual.getName()));
//    }

}
