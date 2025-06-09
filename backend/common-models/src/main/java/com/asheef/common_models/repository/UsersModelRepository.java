package com.asheef.common_models.repository;

import com.asheef.common_models.mongo_models.UsersModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersModelRepository extends MongoRepository<UsersModel, ObjectId> {
}
