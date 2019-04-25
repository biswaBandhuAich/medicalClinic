package com.example.medical.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class TimeSupplier {

    @GetMapping(value = "/time", produces = MediaType.APPLICATION_JSON_VALUE)
    public ZonedDateTime currentTime() {
        return ZonedDateTime.now();
    }

    @GetMapping(value = "/SecretTime", produces = "aaplication/Json")
    public ZonedDateTime currentSecretTime() {
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
