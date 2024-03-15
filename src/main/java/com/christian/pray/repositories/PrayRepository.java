package com.christian.pray.repositories;

import com.christian.pray.model.Pray;
import com.christian.pray.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayRepository extends JpaRepository<Pray, Long> {
}
