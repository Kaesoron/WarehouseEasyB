package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.Monitor;
import org.kaesoron.warehouse.repository.MonitorRepository;
import org.springframework.beans.BeanUtils;
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

    @Transactional
    public Monitor save(Monitor monitor) {
        monitorRepository.save(monitor);
        return monitor;
    }

    @Transactional
    public Monitor update(Monitor monitorFromDB, Monitor newMonitor) {
        BeanUtils.copyProperties(newMonitor, monitorFromDB, "id");
        monitorRepository.save(monitorFromDB);
        return monitorFromDB;
    }

    @Transactional
    public void delete (Monitor monitor) {
        monitorRepository.delete(monitor);
    }

}
