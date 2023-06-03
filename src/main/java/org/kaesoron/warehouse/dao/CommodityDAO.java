package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.Commodity;
import org.kaesoron.warehouse.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityDAO {
    @Autowired
    private CommodityRepository commodityRepository;

    public List<Commodity> index() {
        return commodityRepository.findAll();
    }
}
