package org.kaesoron.warehouse.dao;

import jakarta.persistence.Column;
import org.kaesoron.warehouse.models.Commodity;
import org.kaesoron.warehouse.models.CommodityType;
import org.kaesoron.warehouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommodityDAO {
    @Autowired
    private CommodityRepository commodityRepository;

    public List<Commodity> index() {
        return commodityRepository.findAll();
    }

    public Commodity show(long id) {
        return commodityRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    @Transactional
    public void update(long id, Commodity commodity) {
        Commodity toBeUpdated = show(id);
        toBeUpdated.setCommodityType(commodity.getCommodityType());
        toBeUpdated.setSeriesNumber(commodity.getSeriesNumber());
        toBeUpdated.setManufacturer(commodity.getManufacturer());
        toBeUpdated.setPrice(commodity.getPrice());
        toBeUpdated.setQuantity(commodity.getQuantity());
        commodityRepository.save(toBeUpdated);
    }

    @Transactional
    public void delete (long id) {
        commodityRepository.deleteById(id);
    }

}
