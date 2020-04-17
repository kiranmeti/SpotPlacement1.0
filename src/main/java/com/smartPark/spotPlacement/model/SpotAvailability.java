/*
 * @(#)SpotAvailability.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

/**
 * SpotAvailability class use to fetch/update the spot availability details
 * @author LTTS-Compute vision
 * @version 1.0
 */

@Document(collection = "spot_availability")
public class SpotAvailability {

    @Id
    //global id of the spot
    private int id;

    //status to indicate spot is available or occupied.
    private String status;

    //cam_reports is the object of spot id and status
    private ArrayList<SpotStatus> cam_reports;

    //report date and time
    private long date;

    //constructor for SpotAvailability class
    public SpotAvailability(int id, String status, ArrayList<SpotStatus> cam_reports,
                            long date) {
        this.id = id;
        this.status = status;
        this.cam_reports = cam_reports;
        this.date = date;
    }

    /**
     * method to get global spot id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method to set id
     * @param id of type int
     */
    public void setId(int id) {
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

    /**
     * method to get cam_reports list
     * @return cam_reports
     */
    public ArrayList<SpotStatus> getCam_reports() {
        return cam_reports;
    }

    /**
     * method to set cam_reports
     * @param cam_reports of type List
     */
    public void setCam_reports(ArrayList<SpotStatus> cam_reports) {
        this.cam_reports = cam_reports;
    }

    /**
     * method to get date
     * @return date
     */
    public long getDate() {
        return date;
    }

    /**
     * method to set date
     * @param date of type long
     */
    public void setDate(long date) {
        this.date = date;
    }
}

