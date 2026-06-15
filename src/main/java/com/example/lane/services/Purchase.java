package com.example.lane.services;

import com.example.lane.entities.Cart;
import com.example.lane.entities.CartItem;
import com.example.lane.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
