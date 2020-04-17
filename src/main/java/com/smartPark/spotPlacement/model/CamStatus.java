/*
 * @(#)CamStatus.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;

import org.springframework.data.annotation.Id;

/**
 * CamStatus use to fetch the camera status.
 * @author LTTS-Compute vision
 * @version 1.0
 */

public class CamStatus {

    @Id
    //primary camera Id name
    private String id;

    //last update time
    private long lastUpdate;

    //constructor for CamStatus class
    public CamStatus(String id, long lastUpdate) {
        this.id = id;
        this.lastUpdate = lastUpdate;
    }

    /**
     * method to get camera Id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * method to set camera Id
     * @param id of type String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method to get last update
     * @return lastUpdate
     */
    public long getLastUpdate() {
        return lastUpdate;
    }

    /**
     * method to set update
     * @param lastUpdate of type long
     */
    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
