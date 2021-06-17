package com.ascent.restfulmilktea;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

@WebMvcTest
public class MilkTeaControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MilkTeaService milkTeaService;

    private List<MilkTea> milkTeaList;

    @BeforeEach
    void setup() {
        milkTeaList = new ArrayList<>();
        milkTeaList.add(new MilkTea("Jasmine Tea", "$5.0"));
        milkTeaList.add(new MilkTea("Classic Milk Tea", "$5.5"));
        milkTeaList.add(new MilkTea("Hong Kong Milk Tea", "$6.0"));
        milkTeaList.add(new MilkTea("Four Seasons Milk Tea", "$6.5"));
    }

    @Test
    @DisplayName("Get /milktea should display all milk tea")
    void findAllMilkTeas_shouldReturnAllMilkTea() throws Exception {
        when(milkTeaService.findAllMilkTeas()).thenReturn(milkTeaList);

        mockMvc.perform(get("/milkTea"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    @DisplayName("Post /milkTea should add milk tea")
    void addMilkTea_shouldAddNewMilkTeaToTheList() throws Exception {
        when(milkTeaService.addMilkTea(any(MilkTea.class))).thenReturn(new MilkTea("Classic Milk Tea", "$5.0"));

        String JSON = "{\"name\": \"Classic Milk Tea\", \"price\": \"$5.0\"}";

        mockMvc.perform(post("/milkTea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Classic Milk Tea"));
    }

    @Test
    @DisplayName("Delete /milkTea/{milkTeaId} should delete a single milktea")
    void deleteMilkTea_shouldDeleteMilkTea() throws Exception{
        MilkTea actual = new MilkTea("Classic Milk Tea", "$5.0");
        actual.setId(1L);
        when(milkTeaService.deleteMilkTea(1L)).thenReturn(actual.getId());

        mockMvc.perform(delete("/milkTea/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get MilkTea by Id using /milkTea/{milkTeaId}")
    void getMilkTeaById_shouldGetSingleMilkTea() throws Exception {
        MilkTea actual = new MilkTea("Classic Milk Tea", "$5.0");
        actual.setId(1L);
        when(milkTeaService.getMilkTeaById(anyLong())).thenReturn(actual);
        mockMvc.perform(get("/milkTea/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Classic Milk Tea"));
    }

    @Test
    @DisplayName("Patch /milkTea/{milkTeaId} should update a single milktea")
    void updateMilkTea_shouldUpdateMilkTea() throws Exception {
        MilkTea actual = new MilkTea("Classic Milk Tea", "$5.0");
        actual.setId(666L);
        String JSON = "{\"name\": \"testtesttest\"}";
        HashMap<String, Object> update = new HashMap<>();
        update.put("name", "testtesttest");
        when(milkTeaService.updateMilkTea(actual, update)).thenReturn(actual);
        mockMvc.perform(patch("/milkTea/666")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isOk());
    }
}