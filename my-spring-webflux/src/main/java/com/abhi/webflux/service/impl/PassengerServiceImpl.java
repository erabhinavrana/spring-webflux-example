package com.abhi.webflux.service.impl;

import com.abhi.webflux.model.Passenger;
import com.abhi.webflux.repo.PassengerRepo;
import com.abhi.webflux.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Abhinav on 12/23/2018.
 */
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepo passengerRepo;

    @Override
    public Mono<Passenger> createPassengerRecord(Passenger passenger) {
        return passengerRepo.createPassengerRecord(passenger);
    }

    @Override
    public Flux<Passenger> fetchAllPassengerRecords() {
        return passengerRepo.fetchAllPassengerRecords();
    }

    @Override
    public Mono<Passenger> findPassengerRecord(String recordID) {
        return passengerRepo.findPassengerRecord(recordID);
    }
}
