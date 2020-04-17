/*
 * @(#)CamToGlobalIdRepository.java 1.8 10/04/20
 * Copyright (c) 2020-2021
 */

package com.smartPark.spotPlacement.repository;

import com.smartPark.spotPlacement.model.CamToGlobalId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CamToGlobalIdRepository interface extends MongoRepository supports method for crud operations
 * @author LTTS-Compute vision
 * @version 1.0
 */

public interface CamToGlobalIdRepository extends MongoRepository<CamToGlobalId, Integer> {

}
