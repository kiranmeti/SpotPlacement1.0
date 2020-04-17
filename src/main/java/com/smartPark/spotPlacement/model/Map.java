/*
 * @(#)Map.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Map class is use to get all the info related to camera name gps points etc.
 * @author LTTS-Compute vision
 * @version 1.0
 */

@Document(collection = "map")

public class Map {

    @Id
    //this global id for each spots
    private int id;

    //primary camera name
    private String primary_camera;

    //Full text to display the spot
    private String textlong;

    //4 points in GPS coordinates that make up the spot
    private Object gps_points;

    //background color to fill the parking space
    private String bkcolor;

    //path to the image used for the spot
    private String image;

    //type of the spot
    private String type;

    //alternate text display spot
    private String textshort;

    //name of the camera and area which is covering
    private Object cam_id_and_area;

    //text color of the font
    private String txtcolor;

    //constructor for the Map class
    public Map(int id, String primary_camera, String textlong, Object gps_points,
               String bkcolor, String image, String type, String textshort,
               Object cam_id_and_area, String txtcolor) {

        this.id = id;
        this.primary_camera = primary_camera;
        this.textlong = textlong;
        this.gps_points = gps_points;
        this.bkcolor = bkcolor;
        this.image = image;
        this.type = type;
        this.textshort = textshort;
        this.cam_id_and_area = cam_id_and_area;
        this.txtcolor = txtcolor;
    }

    /**
     * method to get id
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
     * method to get Primary_camera
     * @return primary_camera
     */
    public String getPrimary_camera() {
        return primary_camera;
    }

    /**
     * method to set Primary_camera
     * @param primary_camera of type string
     */
    public void setPrimary_camera(String primary_camera) {
        this.primary_camera = primary_camera;
    }

    /**
     * method to get Textlong
     * @return textlong
     */
    public String getTextlong() {
        return textlong;
    }

    /**
     * method to set Textlong
     * @param textlong of type String
     */
    public void setTextlong(String textlong) {
        this.textlong = textlong;
    }

    /**
     * method to get Gps_points
     * @return gps_points object
     */
    public Object getGps_points() {
        return gps_points;
    }

    /**
     * method to set gps_points
     * @param gps_points of type Object
     */
    public void setGps_points(Object gps_points) {
        this.gps_points = gps_points;
    }

    /**
     * method to get Bkcolor
     * @return bkcolor
     */
    public String getBkcolor() {
        return bkcolor;
    }

    /**
     * method to set bkcolor
     * @param  bkcolor of type String
     */
    public void setBkcolor(String bkcolor) {
        this.bkcolor = bkcolor;
    }

    /**
     * method to get image
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * method to set image
     * @param image of type String
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * method to get type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * method to set type
     * @param type string
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * method to get textshort
     * @return textshort
     */
    public String getTextshort() {
        return textshort;
    }

    /**
     * method to set textshort
     * @param textshort of type String
     */
    public void setTextshort(String textshort) {
        this.textshort = textshort;
    }

    /**
     * method to get cam_id_and_area
     * @return cam_id_and_area
     */
    public Object getCam_id_and_area() {
        return cam_id_and_area;
    }

    /**
     * method to set cam_id_and_area
     * @param  cam_id_and_area of type Object
     */
    public void setCam_id_and_area(Object cam_id_and_area) {
        this.cam_id_and_area = cam_id_and_area;
    }

    /**
     * method to get txtcolor
     * @return txtcolor
     */
    public String getTxtcolor() {
        return txtcolor;
    }

    /**
     * method to set txtcolor
     * @param  txtcolor of type string
     */
    public void setTxtcolor(String txtcolor) {
        this.txtcolor = txtcolor;
    }
}