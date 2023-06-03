package com.example.revature.ShoppingCart.services;

import com.example.revature.ShoppingCart.DAO.Item;
import com.example.revature.ShoppingCart.repository.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServ {

    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    public ShoppingCartServ(ShoppingCartRepo repo){
        this.shoppingCartRepo = repo;
    }
    public Item addItem(Item item) {
        return shoppingCartRepo.save(item);
    }

    public Item changeItemQuantity(Item item) {
        Optional<Item> itemInDB = shoppingCartRepo.findById(item.getId());
        if (itemInDB.isPresent()){
            return shoppingCartRepo.save(item);
        }
        return new Item();
    }

    public void deleteItem(Item item){
        shoppingCartRepo.delete(item);
    }

    public List<Item> viewAllItems(){
        return shoppingCartRepo.findAll();
    }
}