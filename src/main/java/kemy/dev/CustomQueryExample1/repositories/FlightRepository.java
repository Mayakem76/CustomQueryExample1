package kemy.dev.CustomQueryExample1.repositories;

import kemy.dev.CustomQueryExample1.entities.Fligth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Fligth,Long> {
}
