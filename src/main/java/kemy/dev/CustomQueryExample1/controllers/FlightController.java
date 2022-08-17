package kemy.dev.CustomQueryExample1.controllers;

import kemy.dev.CustomQueryExample1.entities.Flight;
import kemy.dev.CustomQueryExample1.entities.Status;
import kemy.dev.CustomQueryExample1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    public FlightService flightService;

    @GetMapping("/generate")
    public List<Flight> create100Flights() {
    return flightService.createFlights(100);
    }
    @GetMapping("generate/{numberOfFlights}")
    public List<Flight> getSingleFlight(@PathVariable int numberOfFlights) {
        return flightService.createFlights(numberOfFlights);
    }
    @GetMapping("/{id}")
    public Optional<Flight> getSingleFlight(@PathVariable long id){
        return flightService.getSingleFlight(id);
    }
    @GetMapping("/all")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }
    @GetMapping("/onTime")
    public List<Flight> getFlightsOnTime(){
        return flightService.getFlightsOnTime();
    }
    @GetMapping("/customStatus")
    public List<Flight> getCustomStatus(@RequestParam Status p1, @RequestParam(required = false) Status p2) {
        return flightService.customSelectStatus(p1,p2) ;
    }
    @GetMapping("/departures")
    public List<Flight> getPaginatedByDeparture(@RequestParam int pageNumber, int size){
        return flightService.getPaginatedByDeparture(pageNumber,size);
    }

    @PostMapping("/post")
    public Flight postNewFlight(@RequestBody Flight flight){
        return flightService.createFlight(flight);
    }
    @DeleteMapping("")
    public String deleteAllFlights(){
        return flightService.deleteAllFlights();
    }
    @DeleteMapping("/{id}")
    public String deleteSingleFlight(@PathVariable long id){
        return flightService.deleteSingleFlight(id);
    }


}
