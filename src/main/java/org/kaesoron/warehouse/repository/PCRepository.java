package org.kaesoron.warehouse.repository;

import org.kaesoron.warehouse.models.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepository extends JpaRepository<PC, Long> {
}
