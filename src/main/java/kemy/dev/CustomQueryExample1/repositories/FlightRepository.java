package kemy.dev.CustomQueryExample1.repositories;

import kemy.dev.CustomQueryExample1.entities.Flight;
import kemy.dev.CustomQueryExample1.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> , JpaSpecificationExecutor<Flight> {

    List<Flight> findByStatus(Status status);
    List<Flight> findByDepartures(String departures);
    List<Flight> findByArrivals(String arrivals);

    @Query("select f from Flight f where f.status = :p1 OR f.status = :p2")
    List <Flight> findFlightsByStatus(@Param("p1") Status p1, @Param("p2") Status p2);


}