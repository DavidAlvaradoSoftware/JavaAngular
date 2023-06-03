package com.example.revature.ShoppingCart.repository;

import com.example.revature.ShoppingCart.DAO.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCartRepo extends JpaRepository<Item, Long> {
}
