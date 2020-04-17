/*
 * @(#)SpotUpdateRequest.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */


package com.smartPark.spotPlacement.model;

import java.util.ArrayList;

/**
 * SpotUpdateRequest class use to update the spot requests.
 * @author LTTS-Compute vision
 * @version 1.0
 */

public class SpotUpdateRequest {

    //primary camera ID name
    private String camId;

    //spaceUpdates is a list of id and status.
    private ArrayList<SpotUpdateStatusRequest> spaceUpdates;

    //constructor for SpotUpdateRequest class
    public SpotUpdateRequest(String cam_id, ArrayList<SpotUpdateStatusRequest> space_updates) {
        this.camId = cam_id;
        this.spaceUpdates = space_updates;
    }

    /**
     * method to get camId
     * @return camId
     */
    public String getCamId() {
        return camId;
    }

    /**
     * method to set camId
     * @param camId of type String
     */
    public void setCamId(String camId) {
        this.camId = camId;
    }

    /**
     * method to get spaceUpdates
     * @return spaceUpdates
     */
    public ArrayList<SpotUpdateStatusRequest> getSpaceUpdates() {
        return spaceUpdates;
    }

    /**
     * method to set spaceUpdates
     * @param spaceUpdates of type List
     */
    public void setSpaceUpdates(ArrayList<SpotUpdateStatusRequest> spaceUpdates) {
        this.spaceUpdates = spaceUpdates;
    }
}
