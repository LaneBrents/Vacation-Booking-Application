package com.example.lane.services;

import com.example.lane.dao.CustomerRepository;
import com.example.lane.entities.Cart;
import com.example.lane.entities.CartItem;
import com.example.lane.entities.Customer;
import com.example.lane.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepository customerRepository;
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Retrieving order info
        Cart cart = purchase.getCart();

        // Generating tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populating cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (CartItem item : cartItems) {
            if (item.getVacation() != null && item.getVacation().getTravel_price() != null) {
                totalPrice = totalPrice.add(item.getVacation().getTravel_price());
            }
            if (item.getExcursions() != null) {
                for (var excursion : item.getExcursions()) {
                    if (excursion.getExcursion_price() != null) {
                        totalPrice = totalPrice.add(excursion.getExcursion_price());
                    }
                }
            }
        }
        totalPrice = totalPrice.multiply(BigDecimal.valueOf(cart.getParty_size()));
        cart.setPackagePrice(totalPrice);

        if (totalPrice.equals(BigDecimal.ZERO)){
            System.out.println("Total price is zero, aborting cart update.");
            return null;
        }

        cart.setStatus(StatusType.ordered);

        Customer customer = purchase.getCustomer();
        cart.setCustomer(customer);

        customer.getCarts().add(cart);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
