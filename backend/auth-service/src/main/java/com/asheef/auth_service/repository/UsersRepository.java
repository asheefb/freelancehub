package com.asheef.auth_service.repository;

import com.asheef.auth_service.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);
}
