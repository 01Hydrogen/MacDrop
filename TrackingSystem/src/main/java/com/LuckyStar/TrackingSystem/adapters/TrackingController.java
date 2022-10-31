package com.LuckyStar.TrackingSystem.adapters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
public class TrackingController {
    private final String ENDPOINT = "/created";

}
