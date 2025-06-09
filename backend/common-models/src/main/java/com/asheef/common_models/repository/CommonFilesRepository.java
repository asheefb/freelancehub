package com.asheef.common_models.repository;

import com.asheef.common_models.mongo_models.CommonFiles;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonFilesRepository extends MongoRepository<CommonFiles, ObjectId> {

}
