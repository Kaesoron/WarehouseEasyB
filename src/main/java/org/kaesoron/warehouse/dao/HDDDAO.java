package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.exceptions.NotFoundException;
import org.kaesoron.warehouse.models.HDD;
import org.kaesoron.warehouse.repository.HDDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HDDDAO {
    @Autowired
    private HDDRepository hddRepository;

    public List<HDD> index() {
        return hddRepository.findAll();
    }

    public HDD show(long id) {
        return hddRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void save(HDD hdd) {
        hddRepository.save(hdd);
    }

    @Transactional
    public void update(long id, HDD hdd) {
        HDD toBeUpdated = show(id);
        toBeUpdated.setCommodityType(hdd.getCommodityType());
        toBeUpdated.setSeriesNumber(hdd.getSeriesNumber());
        toBeUpdated.setManufacturer(hdd.getManufacturer());
        toBeUpdated.setPrice(hdd.getPrice());
        toBeUpdated.setQuantity(hdd.getQuantity());
        toBeUpdated.setVolume(hdd.getVolume());
        toBeUpdated.setVolumeMeasure(hdd.getVolumeMeasure());
        hddRepository.save(toBeUpdated);
    }

    @Transactional
    public void delete (long id) {
        hddRepository.deleteById(id);
    }

}
