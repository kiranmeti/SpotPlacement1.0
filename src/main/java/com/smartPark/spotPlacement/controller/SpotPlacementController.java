/*
 * @(#)SpotPlacementController.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.controller;

import com.smartPark.spotPlacement.model.*;
import com.smartPark.spotPlacement.service.SpotPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * SpotPlacementController class which handles the get and put requests for spot status
 * @author LTTS-Compute vision
 * @version 1.0
 */

@RestController
public class SpotPlacementController {

    @Autowired
    SpotPlacementService spotPlacementService;

    //get spot availability details
    @GetMapping("/spots/status")
    public List<SpotAvailability> getSpotStatus() {
        return spotPlacementService.getSpotStatus();
    }

    //update spot status
    @PutMapping("/spots/status")
    public List<SpotAvailability> updateSpotStatus(@Valid @RequestBody ArrayList<SpotUpdateRequest> spotUpdateBody){
        return spotPlacementService.updateSpotStatus(spotUpdateBody);
    }
}
