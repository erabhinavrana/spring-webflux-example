package com.abhi.webflux.service;

import com.abhi.webflux.model.Passenger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Abhinav on 12/23/2018.
 */
public interface PassengerService {
    Mono<Passenger> createPassengerRecord(Passenger passenger);
    Flux<Passenger> fetchAllPassengerRecords();
    Mono<Passenger> findPassengerRecord(String recordID);
}
