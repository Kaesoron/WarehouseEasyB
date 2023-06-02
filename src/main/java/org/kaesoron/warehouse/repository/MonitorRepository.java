package org.kaesoron.warehouse.repository;

import org.kaesoron.warehouse.models.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
