package com.abhi.webflux.repo.impl;

import com.abhi.webflux.model.Passenger;
import com.abhi.webflux.repo.PassengerRepo;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav on 12/23/2018.
 */
@Repository
public class PassengerRepoImpl implements PassengerRepo {

    List<Passenger> passengerList;

    public PassengerRepoImpl() {
        this.passengerList = new ArrayList<>();
    }

    @Override
    public Mono<Passenger> createPassengerRecord(Passenger passenger) {
        this.passengerList.add(passenger);
        return Mono.just(passenger);
    }

    @Override
    public Flux<Passenger> fetchAllPassengerRecords() {
        return (Flux.fromStream(this.passengerList.stream()));
    }

    @Override
    public Mono<Passenger> findPassengerRecord(String recordID) {
        return Mono.just(this.passengerList.stream().filter(passenger -> recordID.equalsIgnoreCase(passenger.getRecordID())).findFirst().get());
    }
}
