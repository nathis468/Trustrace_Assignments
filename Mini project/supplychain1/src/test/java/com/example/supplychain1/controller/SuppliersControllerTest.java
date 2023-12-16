package com.example.supplychain1.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.supplychain1.model.Facilities;
import com.example.supplychain1.model.Location;
import com.example.supplychain1.model.Suppliers;
import com.example.supplychain1.repository.FacilitiesRepository;
import com.example.supplychain1.service.SuppliersService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

@WebMvcTest(value = SuppliersController.class)
public class SuppliersControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    @SpyBean
    SuppliersService service;


    @Test
    void testWhetherClassExists() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier")));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/cd")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
        assertFalse(op.equals(null));

    }

    @Test
    void testWhetherClassNotExists() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(null);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/yet")).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
        // .andReturn().getResponse().getContent;
        assertFalse(op.equals(null));
    }


    @Test
    void testDeleteWorks() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier")));
        Mockito.when(service.delete("cd")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/cd")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        Boolean op = new ObjectMapper().readValue(result, Boolean.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);
    }
}