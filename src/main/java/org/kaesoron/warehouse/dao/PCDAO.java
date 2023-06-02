package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.PC;
import org.kaesoron.warehouse.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PCDAO {
    @Autowired
    private PCRepository pcRepository;

    public List<PC> index() {
        return pcRepository.findAll();
    }

    public PC show(long id) {
        return pcRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(PC notebook) {
        pcRepository.save(notebook);
    }

    @Transactional
    public void update(long id, PC pc) {
        PC toBeUpdated = show(id);
        toBeUpdated.setCommodityType(pc.getCommodityType());
        toBeUpdated.setSeriesNumber(pc.getSeriesNumber());
        toBeUpdated.setManufacturer(pc.getManufacturer());
        toBeUpdated.setPrice(pc.getPrice());
        toBeUpdated.setQuantity(pc.getQuantity());
        toBeUpdated.setPcType(pc.getPcType());
        pcRepository.save(toBeUpdated);
    }

    @Transactional
    public void delete (long id) {
        pcRepository.deleteById(id);
    }

}
