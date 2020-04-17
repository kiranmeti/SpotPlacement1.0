/*
 * @(#)SpotDetailsController.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.controller;

import com.smartPark.spotPlacement.model.Map;
import com.smartPark.spotPlacement.service.SpotPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * SpotDetailsController class is a rest api controller
 * @author LTTS-Compute vision
 * @version 1.0
 */


@RestController
public class SpotDetailsController {

    @Autowired
    SpotPlacementService spotPlacementService;

    //get spot details
    @GetMapping("/spots/details")
    public List<Map> getSpots() {
        return spotPlacementService.getSpotDetails();
    }
}

