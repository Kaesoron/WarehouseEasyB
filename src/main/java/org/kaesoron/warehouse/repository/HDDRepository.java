package org.kaesoron.warehouse.repository;

import org.kaesoron.warehouse.models.HDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDRepository extends JpaRepository<HDD, Long> {
}
