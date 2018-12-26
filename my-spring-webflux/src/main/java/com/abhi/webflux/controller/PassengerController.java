package com.abhi.webflux.controller;

import com.abhi.webflux.model.Passenger;
import com.abhi.webflux.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Abhinav on 12/23/2018.
 */
@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping(value = "/create")
    public Mono<Passenger> createPassengerRecord(@RequestBody Passenger passenger){
        return passengerService.createPassengerRecord(passenger);
    }

    @GetMapping(value = "/retrieve")
    public Flux<Passenger> fetchAllPassengerRecord(){
        return passengerService.fetchAllPassengerRecords();
    }

}
