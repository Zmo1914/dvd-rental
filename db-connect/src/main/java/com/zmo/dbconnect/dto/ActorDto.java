package com.zmo.dbconnect.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ActorDto implements Serializable {
    private final String firstName;
    private final String lastName;
}
