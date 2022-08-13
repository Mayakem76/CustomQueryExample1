package kemy.dev.CustomQueryExample1.services;

import kemy.dev.CustomQueryExample1.entities.Fligth;
import kemy.dev.CustomQueryExample1.entities.Status;
import kemy.dev.CustomQueryExample1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FligthService {
    @Autowired
    private FlightRepository flightRepository;
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
                    generateRandomValueForFlight(), Status.ONTIME));
        }
        flightRepository.saveAllAndFlush(fligthList);
        return fligthList;
    }

}
