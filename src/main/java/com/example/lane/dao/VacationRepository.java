package com.example.lane.dao;
import com.example.lane.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "vacations", path = "vacations")
@CrossOrigin("http://localhost:4200")
public interface VacationRepository
        extends JpaRepository<Vacation, Long> {
}
