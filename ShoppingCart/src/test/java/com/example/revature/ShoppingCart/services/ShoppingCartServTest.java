package com.example.revature.ShoppingCart.services;

import com.example.revature.ShoppingCart.DAO.Item;
import com.example.revature.ShoppingCart.repository.ShoppingCartRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ShoppingCartServTest {


    @InjectMocks
    ShoppingCartServ shoppingCartServ;

    @Mock
    ShoppingCartRepo shoppingCartRepo;

    private Item item;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        item = new Item(1L, "Test Item");
    }

    @Test
    public void testAddItem() {
        when(shoppingCartRepo.save(any(Item.class))).thenReturn(item);
        Item returnedItem = shoppingCartServ.addItem(item);
        assertEquals(item, returnedItem);
    }

    @Test
    public void testChangeItemQuantity() {
        when(shoppingCartRepo.findById(any(Long.class))).thenReturn(Optional.of(item));
        when(shoppingCartRepo.save(any(Item.class))).thenReturn(item);
        Item returnedItem = shoppingCartServ.changeItemQuantity(item);
        assertEquals(item, returnedItem);
    }

    @Test
    public void testDeleteItem() {
        doNothing().when(shoppingCartRepo).delete(any(Item.class));
        shoppingCartServ.deleteItem(item);
        verify(shoppingCartRepo, times(1)).delete(item);
    }

    @Test
    public void testViewAllItems() {
        List<Item> expectedItems = Arrays.asList(item);
        when(shoppingCartRepo.findAll()).thenReturn(expectedItems);
        List<Item> returnedItems = shoppingCartServ.viewAllItems();
        assertEquals(expectedItems, returnedItems);
    }
}