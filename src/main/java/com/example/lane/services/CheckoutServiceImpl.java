package com.example.lane.services;

import com.example.lane.dao.CartRepository;
import com.example.lane.entities.Cart;
import com.example.lane.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        String trackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(trackingNumber);
        Customer customer = purchase.getCustomer();
        customer.getCarts().add(cart);
        cart.setCustomer(customer);
        cartRepository.save(cart);

        return new PurchaseResponse(trackingNumber);
    }
}
