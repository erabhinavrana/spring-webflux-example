package com.abhi.webflux.handler;

import com.abhi.webflux.model.Passenger;
import com.abhi.webflux.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * Created by Abhinav on 12/23/2018.
 */
@Component
public class PassengerHandler {

    @Autowired
    private PassengerService passengerService;

    public Mono<ServerResponse> createPassengerRecord(final ServerRequest request) {
        return request.bodyToMono(Passenger.class)
                .flatMap(passenger -> passengerService.createPassengerRecord(passenger))
                .flatMap(passenger -> ServerResponse.created(URI.create("/passenger/create/" + passenger.getRecordID()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(passenger), Passenger.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findPassengerRecord(final ServerRequest request) {
        return passengerService.findPassengerRecord(request.pathVariable("id"))
                .flatMap(passenger -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(passenger), Passenger.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> retrieveAllPassengerRecord(final ServerRequest request) {
        return passengerService.fetchAllPassengerRecords()
                .collectList()
                .flatMap(passengers -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(passengers), List.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
