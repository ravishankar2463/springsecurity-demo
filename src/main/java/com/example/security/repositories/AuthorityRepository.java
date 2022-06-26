package com.example.security.repositories;

import com.example.security.models.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority,Long> {
    Optional<List<Authority>> findAuthorityByUsername(String username);
}
