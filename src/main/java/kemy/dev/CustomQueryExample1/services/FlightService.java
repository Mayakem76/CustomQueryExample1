package kemy.dev.CustomQueryExample1.services;

import kemy.dev.CustomQueryExample1.entities.Flight;
import kemy.dev.CustomQueryExample1.entities.Status;
import kemy.dev.CustomQueryExample1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    Optional <Flight> flight;


    public Optional<Flight> getSingleFlight(@PathVariable long id){

        if(flightRepository.existsById(id)){

            return flightRepository.findById(id);}
        else {
            System.out.println("Requested flight id: "+id+". Flight id not found");  //write in console "Not found!"
           flight = Optional.of(new Flight());
            return flight;
        }
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public List<Flight> getPaginatedByDeparture(@RequestParam int pageNumber, int size){
        Pageable pageAndSort= PageRequest.of(pageNumber, size, Sort.by("departures").ascending());
        System.out.println("Page number "+pageAndSort.getPageNumber());
        return flightRepository.findAll(pageAndSort).toList();


    }
    public List<Flight> getFlightsOnTime(){
        return flightRepository.findByStatus(Status.ONTIME);
    }
    public List <Flight> customSelectStatus(@RequestParam  Status p1, @RequestParam Status p2){
        return flightRepository.findFlightsByStatus(p1, p2);
    }
    public Flight createFlight(@RequestBody Flight flight){
        return flightRepository.save(flight);
    }
    public String deleteAllFlights(){
        flightRepository.deleteAll();
        System.out.println("deleted all Flights");
        return "deleted all Flights";
    }
    public String deleteSingleFlight(@PathVariable long id){
        flightRepository.deleteById(id);
        return "deleted Flight - id: "+id;
    }
    public String generateRandomValueForFlight() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    public List<Flight> createFlights(int numberOfFlights){
        List<Flight> flightList =new ArrayList<>();
        if (numberOfFlights==0)
            numberOfFlights=100;
        for (int i=0;i<numberOfFlights;i++){
            flightList.add(new Flight(generateRandomValueForFlight(),generateRandomValueForFlight(),
                    generateRandomValueForFlight(), Status.randomStatus()));
        }
        flightRepository.saveAllAndFlush(flightList);
        return flightList;
    }
}
