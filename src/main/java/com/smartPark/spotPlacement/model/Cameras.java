/*
 * @(#)Cameras.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Cameras class use for fetch the camera records
 * @author LTTS-Compute vision
 * @version 1.0
 */

@Document(collection = "cameras")

public class Cameras {

   @Id
   //primary camera Id name
   private String id;

   //camera friendly is the name of the camera to display to the user.
   private String cam_friendly_name;

   //number of spots covered by primary camera
   private int number_of_spots;

   //the number of seconds to wait before a report from this camera.
   private int timeout;

   //constructor for camera class
    public Cameras(String id, String cam_friendly_name, int number_of_spots,
                   int timeout) {
        this.id = id;
        this.cam_friendly_name = cam_friendly_name;
        this.number_of_spots = number_of_spots;
        this.timeout = timeout;
    }


    /**
     * method to get primary camera Id
     * @return id
     */
    public String getId()
    {
        return id;
    }

    /**
     *method to set primary camera Id
     * @param  id of type string
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method to get camera friendly name
     * @return cam_friendly_name
     */
    public String getCamFriendlyName() {
        return cam_friendly_name;
    }

    /**
     * method to set camera friendly name
     * @param  camFriendlyName of type String
     */
    public void setCamFriendlyName(String camFriendlyName) {
        this.cam_friendly_name = camFriendlyName;
    }


    /**
     * method to get number of spots for primary camera
     * @return number_of_spots
     */
    public int getNumberOfSpots() {
        return number_of_spots;
    }

    /**
     * method to set number of spots for primary camera
     * @param  numberOfSpots of type int
     */
    public void setNumberOfSpots(int numberOfSpots) {
        this.number_of_spots = numberOfSpots;
    }


    /**
     * method to get timeout value of primary camera
     * @return timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * method to set timeout value for primary camera
     * @param timeout of type int
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
