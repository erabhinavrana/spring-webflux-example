package com.abhi.webflux.repo;

import com.abhi.webflux.model.Passenger;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Abhinav on 12/23/2018.
 */
public interface PassengerRepo {
    Mono<Passenger> createPassengerRecord(Passenger passenger);
    Flux<Passenger> fetchAllPassengerRecords();
    Mono<Passenger> findPassengerRecord(String recordID);
}
