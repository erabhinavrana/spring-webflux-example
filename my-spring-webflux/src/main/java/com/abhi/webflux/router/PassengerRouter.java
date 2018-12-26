package com.abhi.webflux.router;

import com.abhi.webflux.handler.PassengerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.nest;

/**
 * Created by Abhinav on 12/23/2018.
 */
@Configuration
public class PassengerRouter {

    private static final String MODULE_PATH = "/passenger";

    @Bean
    public RouterFunction<ServerResponse> route(PassengerHandler passengerHandler) {
        return nest(RequestPredicates.path(MODULE_PATH),
                RouterFunctions.route(RequestPredicates.POST("/create").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), passengerHandler::createPassengerRecord)
        .andRoute(RequestPredicates.GET("/find/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), passengerHandler::findPassengerRecord)
        .andRoute(RequestPredicates.GET("/fetchAll").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), passengerHandler::retrieveAllPassengerRecord));

    }
}
