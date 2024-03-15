package com.christian.pray.repositories;

import com.christian.pray.model.Church;
import com.christian.pray.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
