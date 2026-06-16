package com.example.lane.bootstrap;

import com.example.lane.dao.CustomerRepository;
import com.example.lane.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("BOOTSTRAP DATA RUNNING");
        if (customerRepository.count() < 5) {

            Customer customer2 = new Customer();
            customer2.setFirstName("Jane");
            customer2.setLastName("Doe");
            customer2.setAddress("456 Oak Avenue");
            customer2.setPostal_code("22222");
            customer2.setPhone("555-222-2222");

            Customer customer3 = new Customer();
            customer3.setFirstName("Michael");
            customer3.setLastName("Brown");
            customer3.setAddress("789 Pine Road");
            customer3.setPostal_code("33333");
            customer3.setPhone("555-333-3333");

            Customer customer4 = new Customer();
            customer4.setFirstName("Sarah");
            customer4.setLastName("Wilson");
            customer4.setAddress("321 Maple Lane");
            customer4.setPostal_code("44444");
            customer4.setPhone("555-444-4444");

            Customer customer5 = new Customer();
            customer5.setFirstName("David");
            customer5.setLastName("Taylor");
            customer5.setAddress("654 Cedar Drive");
            customer5.setPostal_code("55555");
            customer5.setPhone("555-555-5555");

            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.println("Sample customers added");
        }
        else {
            System.out.println("Customers already exist. Skipping bootstrap.");
        }
    }
}
