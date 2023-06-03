package com.example.revature.ShoppingCart.controllers;

import com.example.revature.ShoppingCart.DAO.Item;
import com.example.revature.ShoppingCart.services.ShoppingCartServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartController {

    ShoppingCartServ shoppingCartService;

    @Autowired
    ShoppingCartController(ShoppingCartServ shoppingCartServ){
        this.shoppingCartService = shoppingCartServ;
    }

    @GetMapping
    public List<Item> viewShoppingCart(){
        return shoppingCartService.viewAllItems();
    }

    @PostMapping
    public Item addItemToCart(@RequestBody Item item){
        return shoppingCartService.addItem(item);
    }

    @PutMapping
    public Item updateQuantity(@RequestBody Item item){
        return shoppingCartService.changeItemQuantity(item);
    }

    @DeleteMapping
    public void deleteItem(@RequestBody Item item){
        shoppingCartService.deleteItem(item);
    }

}
