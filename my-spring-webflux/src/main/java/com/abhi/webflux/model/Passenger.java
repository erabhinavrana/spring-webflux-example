package com.abhi.webflux.model;

import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Created by Abhinav on 12/23/2018.
 */
@Document
@EqualsAndHashCode
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Passenger {
    private String recordID;
    private String firstName;
    private String lastName;
    private String modeOfTravel;
    private String dateOfTravel;

    public String getRecordID() {
        return recordID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getModeOfTravel() {
        return modeOfTravel;
    }

    public String getDateOfTravel() {
        return dateOfTravel;
    }
}
