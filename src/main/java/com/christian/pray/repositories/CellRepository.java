package com.christian.pray.repositories;

import com.christian.pray.model.Cell;
import com.christian.pray.model.Church;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {
}
