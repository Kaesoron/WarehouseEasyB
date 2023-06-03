package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.HDD;
import org.kaesoron.warehouse.repository.HDDRepository;
import org.springframework.beans.BeanUtils;
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

    @Transactional
    public HDD save(HDD hdd) {
        hddRepository.save(hdd);
        return hdd;
    }

    @Transactional
    public HDD update(HDD hddFromDB, HDD newHdd) {
        BeanUtils.copyProperties(newHdd, hddFromDB, "id");
        hddRepository.save(hddFromDB);
        return hddFromDB;
    }

    @Transactional
    public void delete (HDD hdd) {
        hddRepository.delete(hdd);
    }

}
