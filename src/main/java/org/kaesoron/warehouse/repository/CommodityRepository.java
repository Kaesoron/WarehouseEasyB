package org.kaesoron.warehouse.repository;

import org.kaesoron.warehouse.models.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
}
