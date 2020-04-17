/*
 * @(#)SpotUpdateStatusRequest.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;

/**
 * SpotUpdateStatusRequest class use to get/update the spot status
 * @author LTTS-Compute vision
 * @version 1.0
 */

public class SpotUpdateStatusRequest {

    //id is spot id name
    private String id;

    // spot status
    private String status;

    //constructor for SpotUpdateStatusRequest class
    public SpotUpdateStatusRequest(String id, String status) {
        this.id = id;
        this.status = status;
    }

    /**
     * method to get spot id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * method to set spot id
     * @param id of type String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method to get spot status
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
