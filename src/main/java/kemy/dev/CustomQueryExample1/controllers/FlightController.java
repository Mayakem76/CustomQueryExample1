package kemy.dev.CustomQueryExample1.controllers;

import kemy.dev.CustomQueryExample1.entities.Fligth;
import kemy.dev.CustomQueryExample1.services.FligthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*has a FlightController:
mapped on flights
for the provisioning of 50 flights where:
all the string values are randomly generated (using random.ints())
the default status is ON_TIME
for retrieving all the flights in the db

 */
@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    public FligthService fligthService;

    //all the string values are randomly generated (using random.ints())

    @GetMapping("/generate")
    public List<Fligth> create100Flights() {
    return fligthService.createFligths(100);
    }
    @GetMapping("generate/{numberOfFlights}")
    public List<Fligth> createFlights(@PathVariable int numberOfFlights) {

        return fligthService.createFligths(numberOfFlights);
    }
    @GetMapping("/{id}")
    public Optional<Fligth> getSingleFlight(@PathVariable long id){
        return fligthService.getSingleFlight(id);
    }
    @GetMapping("/all")
    public List<Fligth> getAllFlights(){
        return fligthService.getAllFligths();
    }
    @PostMapping("/post")
    public Fligth createFlight(@RequestBody Fligth fligth){
        return fligthService.createFLigth(fligth);
    }
    @DeleteMapping("")
    public String deleteAllFlights(){
        return fligthService.deleteAllFligths();
    }


}
