package kemy.dev.CustomQueryExample1.services;

import kemy.dev.CustomQueryExample1.entities.Fligth;
import kemy.dev.CustomQueryExample1.entities.Status;
import kemy.dev.CustomQueryExample1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FligthService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    Optional <Fligth> fligth ;
    public String generateRandomValueForFlight() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


    public List<Fligth> createFligths(){
        List<Fligth> fligthList=new ArrayList<>();
        for (int i=0;i<50;i++){
            fligthList.add(new Fligth((long) i,generateRandomValueForFlight(),generateRandomValueForFlight(),
                    generateRandomValueForFlight(), Status.randomStatus()));
        }
        flightRepository.saveAllAndFlush(fligthList);
        return fligthList;
    }

    public Optional<Fligth> getSingleFligth(@PathVariable long id){

        if(flightRepository.existsById(id)){

            return flightRepository.findById(id);}
        else {
            System.out.println("Requested flight id: "+id+". Flight id not found");  //write in console "Not found!"
           fligth = Optional.of(new Fligth());
            return fligth;
        }
    }

    public List<Fligth> getAllFligths(){
        return flightRepository.findAll();
    }
    public Fligth createFLigth(@RequestBody Fligth fligth){
        return flightRepository.save(fligth);
    }
    public String deleteAllFligths(){
        flightRepository.deleteAll();
        System.out.println("deleted all Fligths");
        return "deleted all Fligths";
    }
}
