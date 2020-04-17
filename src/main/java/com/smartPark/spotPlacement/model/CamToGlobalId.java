/*
 * @(#)CamToGlobalId.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * CamToGlobalId class use for fetch the spot details by using globalID
 * @author LTTS-Compute vision
 * @version 1.0
 */

@Document(collection = "camid_to_global")
public class CamToGlobalId {

    @Id
    //this id is combination of primary cameraId and spotId
    private String id;

    //this is global_id for primary camId and spotId
    private int global_id;

    //constructor for CamToGlobalId class
    public CamToGlobalId(String id, int global_id) {
        this.id = id;
        this.global_id = global_id;
    }

    /**
     *  method to get id
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
     *  method to get globalId
     * @return global_id
     */
    public int getGlobalId() {
        return global_id;
    }

    /**
     * method to set globalId
     * @param globalId of type int
     */
    public void setGlobalId(int globalId) {
        this.global_id = globalId;
    }
}
