/*
 * @(#)SpotPlacementService.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.service;

import java.util.*;
import java.util.List;
import com.smartPark.spotPlacement.model.Map;
import com.smartPark.spotPlacement.model.*;
import com.smartPark.spotPlacement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * SpotPlacementService class which handles controller requests.
 * @author LTTS-Compute vision
 * @version 1.0
 */

@Service
public class SpotPlacementService {

    @Autowired
    private MapRepository mapRepo;
    @Autowired
    private SpotAvailabilityRepository spotAvailRepo;

    @Autowired
    private CamToGlobalIdRepository camToGlobalIdRepo;

    @Autowired
    private CamStatusRepository camStatusRepo;

    @Autowired
    private CamerasRepository camerasRepo;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    /**
     * method will update the Spot Status.
     * @param - SpotUpdateRequest of type List
     * @return - List<SpotAvailability>
     */
    public List<SpotAvailability> updateSpotStatus(
                ArrayList<SpotUpdateRequest> spotUpdateStatusBody) {

        int spotStatusSize = spotUpdateStatusBody.size();
        List<SpotAvailability> spotAvailUpdatedList = new ArrayList<>();
        //loop through all the record and update spots
        for (int i = 0; i < spotStatusSize; i++) {
            SpotUpdateRequest SpotsStatusObj = spotUpdateStatusBody.get(i);
            SpotAvailability spotAvailUpdatedObj = this.updateSpots(SpotsStatusObj);
            spotAvailUpdatedList.add(spotAvailUpdatedObj);
        }
        return spotAvailUpdatedList;
    }


    /**
     * method will create or update the spot records.
     * @param -SpotUpdateRequest
     * @return   SpotAvailability object
     */
    public SpotAvailability updateSpots(SpotUpdateRequest spotUpdateObj){

        String cameraId = spotUpdateObj.getCamId();
        ArrayList<SpotUpdateStatusRequest> spaceUpdates = spotUpdateObj.getSpaceUpdates();
        SpotAvailability res = null;
        int spaceUpdatesLength = spaceUpdates.size();
        // Loop through all the space updates
        for(int i = 0; i < spaceUpdatesLength; i++){
            SpotUpdateStatusRequest spotStatusObj =  spaceUpdates.get(i);
            String cameraSpotId = spotStatusObj.getId();
            String spotStatusString = spotStatusObj.getStatus();
            String camSpotId  = cameraId + cameraSpotId;
            long currentUnixTime = System.currentTimeMillis() / 1000L;
            Map spotDetail = this.fetchSpotDetailsByGlobalId(camSpotId);
            int globalId = spotDetail.getId();
            // Check if spot availability record is present or not
            SpotAvailability spotRecord = this.fetchSpotAvailabilityRecord(globalId);
            //if record is present then update the record else create new spot record
            if(spotRecord != null){
                // Update spot record
                ArrayList<SpotStatus> camArr= spotRecord.getCam_reports();
                for (int arrSize =0; arrSize<camArr.size();arrSize++){
                    String camId = camArr.get(arrSize).getId();
                    //get camera status by passing camID as an argument
                    CamStatus camStatusRecord = this.fetchCamStatus(camId);
                    //get camera records by passing camID as an argument
                    Cameras cameraObj = this.fetchCamerasRecord(camId);
                     res = this.updateSpotAvailability(globalId,spotStatusString);
                }
            }else {
                // Create a spot record
                SpotStatus spotStatusObject = new SpotStatus(cameraSpotId,spotStatusString);
                ArrayList<SpotStatus> spotStatusList = new ArrayList<>();
                spotStatusList.add(spotStatusObject);
                SpotAvailability newSpotAvailObj = new SpotAvailability(globalId,spotStatusString,spotStatusList,currentUnixTime);
                res = spotAvailRepo.save(newSpotAvailObj);

            }
        }
        return res;
    }

    /**
     * method will update all spot availability records into the spotavail repo.
     * @param  globalId, of type int
     * @param spotStatus of type  string
     * @return  SpotAvailability object
     */
    public SpotAvailability updateSpotAvailability(int globalId, String spotStatus){

        //get all the spot availability record from spot availability repository
        List<SpotAvailability> spotAvailList = spotAvailRepo.findAll();
        SpotAvailability spotAvailObj = null;
        for(int i=0 ; i < spotAvailList.size();i++){
            int spotAvailId = spotAvailList.get(i).getId();
            if(globalId == spotAvailId){
                spotAvailObj = spotAvailList.get(i);
                break;
            }
        }

        assert spotAvailObj != null;
        spotAvailObj.setDate(System.currentTimeMillis() / 1000L);
        spotAvailObj.setStatus(spotStatus);
        spotAvailObj = spotAvailRepo.save(spotAvailObj);
        return spotAvailObj;
    }

    /**
     * method will fetch camera status related to particular camID.
     * @param  camId of type String
     * @return  camStatus object
     */
    public CamStatus fetchCamStatus(String camId){
        List<CamStatus> camStatusList =  camStatusRepo.findAll();
        CamStatus finalCamStatus = null;
        for(int i=0;i<camStatusList.size();i++){
            String camStatusId = camStatusList.get(i).getId();
            if(camStatusId == camId){
                finalCamStatus = camStatusList.get(i);
                break;
            }
        }
        return finalCamStatus;
    }

    /**
     * method will fetch the camera records related to camID
     * @param camId of type String
     * @return  Cameras object
     */
    public Cameras fetchCamerasRecord(String camId){
        List<Cameras> camerasList =  camerasRepo.findAll();
        Cameras finalCamerasRec = null;
        //loop through all the records
        for(int i=0;i < camerasList.size(); i++){
            String cameraId = camerasList.get(i).getId();
            if(cameraId.equals(camId)){
                finalCamerasRec = camerasList.get(i);
                break;
            }
        }
        return finalCamerasRec;
    }

    /**
     * method is use to get spot availability records from spot avail repo
     * @param  globalId of type int
     * @return  SpotAvailability object
     */
    public SpotAvailability fetchSpotAvailabilityRecord(int globalId){

        List<SpotAvailability> spotAvailList = spotAvailRepo.findAll();
        SpotAvailability finalSpotAvailRecord = null;
        for (int i=0; i<spotAvailList.size();i++){
            int spotAvailId = spotAvailList.get(i).getId();
            if(spotAvailId == globalId){
                finalSpotAvailRecord = spotAvailList.get(i);
            }
        }
        return finalSpotAvailRecord;
    }

    /**
     * method is use to fetch spot details
     * @param  camSpotId of type String
     * @return  Map object
     */
    public Map fetchSpotDetailsByGlobalId(String camSpotId){

        List<CamToGlobalId> camToGlobalIdList = camToGlobalIdRepo.findAll();
        CamToGlobalId CamToGlobalIdRec = null;
        int globalId =0;
        for(int i =0; i < camToGlobalIdList.size(); i++){
            String currentId = camToGlobalIdList.get(i).getId();
            if(currentId.equals(camSpotId)){
                globalId = camToGlobalIdList.get(i).getGlobalId();
                break;
            }
        }

        Map finalMapObj = null;
        if(globalId > 0){
            List<Map> mapList = mapRepo.findAll();
            for(int j = 0; j < mapList.size(); j++){
                Map mapObj = mapList.get(j);
                int mapId = mapObj.getId();
                if(mapId == globalId){
                    finalMapObj = mapObj;
                    break;
                }
            }
        }
        return finalMapObj;
    }

    /**
     * method is use get the spot details from MapRepository
     * @return  List<Map> object
     */
    public List<Map> getSpotDetails(){
        List<Map> mapList =  mapRepo.findAll();
        return mapList;
    }

    /**
     * method is use get the spot availability status from spot avail repo
     * @return  List<SpotAvailability> object
     */
    public List<SpotAvailability> getSpotStatus(){
        List<SpotAvailability> spotStatusList =  spotAvailRepo.findAll();
        return spotStatusList;
    }
}
