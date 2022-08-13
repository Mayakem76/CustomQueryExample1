package kemy.dev.CustomQueryExample1.controllers;

import kemy.dev.CustomQueryExample1.entities.Fligth;
import kemy.dev.CustomQueryExample1.entities.Status;
import kemy.dev.CustomQueryExample1.repositories.FlightRepository;
import kemy.dev.CustomQueryExample1.services.FligthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*has a FlightController:
mapped on flights
for the provisioning of 50 flights where:
all the string values are randomly generated (using random.ints())
the default status is ON_TIME
for retrieving all the flights in the db

 */
@RestController
@RequestMapping("/fligths")
public class FligthController {

    @Autowired
    public FligthService fligthService;

    //all the string values are randomly generated (using random.ints())


    @GetMapping("/create")
    public List<Fligth> createFligths(){
       return fligthService.createFligths();
         }


}
