package com.example.lane.dao;
import com.example.lane.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface CartRepository
        extends JpaRepository<Cart, Long> {
}
