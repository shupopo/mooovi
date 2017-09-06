package com.mooovi.web.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext context; // ①

    private MockMvc mockMvc; // ②

    @Before // ③
    public void setupMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build(); // ④
    }
    
    @Test
    public void testShow() throws Exception{
        mockMvc.perform(get("/products/51"))  // ①
            .andExpect(status().isOk())  // ②
            .andExpect(view().name(is("products/show")));  // ③
    }
    
    @Test
    public void testSearch() throws Exception{
        mockMvc.perform(get("/products/search").param("keyword", "the"))  // ①
            .andExpect(status().isOk())  // ②
            .andExpect(view().name(is("products/search")))  // ③
            .andExpect(model().attribute("products", hasSize(6)));  // ④
    }

}