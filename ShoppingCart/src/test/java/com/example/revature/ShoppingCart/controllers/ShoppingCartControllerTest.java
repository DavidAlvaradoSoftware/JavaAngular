package com.example.revature.ShoppingCart.controllers;
import com.example.revature.ShoppingCart.DAO.Item;
import com.example.revature.ShoppingCart.services.ShoppingCartServ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShoppingCartController.class)
class ShoppingCartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCartServ shoppingCartService;

    private Item item;

    @BeforeEach
    public void setup() {
        item = new Item(1L, "Test Item");
    }

    @Test
    public void testViewShoppingCart() throws Exception {
        List<Item> expectedItems = Arrays.asList(item);
        when(shoppingCartService.viewAllItems()).thenReturn(expectedItems);

        mockMvc.perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'Test Item'}]"));
    }

    @Test
    public void testAddItemToCart() throws Exception {
        when(shoppingCartService.addItem(any(Item.class))).thenReturn(item);

        mockMvc.perform(post("/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1,\"name\": \"Test Item\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1,'name': 'Test Item'}"));
    }

    @Test
    public void testUpdateQuantity() throws Exception {
        when(shoppingCartService.changeItemQuantity(any(Item.class))).thenReturn(item);

        mockMvc.perform(put("/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1,\"name\": \"Test Item\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1,'name': 'Test Item'}"));
    }

    @Test
    public void testDeleteItem() throws Exception {
        doNothing().when(shoppingCartService).deleteItem(any(Item.class));

        mockMvc.perform(delete("/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1,\"name\": \"Test Item\"}"))
                .andExpect(status().isOk());

        verify(shoppingCartService, times(1)).deleteItem(any(Item.class));
    }



}