package com.christian.pray.repositories;

import com.christian.pray.model.Pray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrayRepository extends JpaRepository<Pray, Long> {

    List<Pray> getPraysByPersonId(long memberId);
}
