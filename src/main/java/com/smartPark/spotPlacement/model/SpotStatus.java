/*
 * @(#)SpotStatus.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;

/**
 * SpotStatus class is use to update the status records.
 * @author LTTS-Compute vision
 * @version 1.0
 */

public class SpotStatus {

    //id for the spot
    private String id;

    //status indicates available or occupied spot
    private String status;

    //constructor for SpotStatus class
    public SpotStatus(String id, String status) {
        this.id = id;
        this.status = status;
    }

    /**
     * method to get id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * method to set id
     * @param id of type String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method to get status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * method to set status
     * @param status of type String
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
