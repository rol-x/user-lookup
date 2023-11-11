package com.codeshop.userlookup.repository;

import com.codeshop.userlookup.repository.entity.LoginRequest;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends CrudRepository<LoginRequest, UUID> {
  Optional<LoginRequest> findByLogin(String login);
}
