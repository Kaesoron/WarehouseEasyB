package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.Monitor;
import org.kaesoron.warehouse.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MonitorDAO {
    @Autowired
    private MonitorRepository monitorRepository;

    public List<Monitor> index() {
        return monitorRepository.findAll();
    }

    public Monitor show(long id) {
        return monitorRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Monitor monitor) {
        monitorRepository.save(monitor);
    }

    @Transactional
    public void update(long id, Monitor monitor) {
        Monitor toBeUpdated = show(id);
        toBeUpdated.setCommodityType(monitor.getCommodityType());
        toBeUpdated.setSeriesNumber(monitor.getSeriesNumber());
        toBeUpdated.setManufacturer(monitor.getManufacturer());
        toBeUpdated.setPrice(monitor.getPrice());
        toBeUpdated.setQuantity(monitor.getQuantity());
        toBeUpdated.setDiagonal(monitor.getDiagonal());
        monitorRepository.save(toBeUpdated);
    }

    @Transactional
    public void delete (long id) {
        monitorRepository.deleteById(id);
    }

}
