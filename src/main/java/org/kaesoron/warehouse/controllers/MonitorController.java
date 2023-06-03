package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.dao.MonitorDAO;
import org.kaesoron.warehouse.models.Monitor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("monitor")
public class MonitorController {
    private final MonitorDAO monitorDao;
    public MonitorController(MonitorDAO monitorDao) {
        this.monitorDao = monitorDao;
    }

    @GetMapping("")
    public List<Monitor> index() {
        return monitorDao.index();
    }

    @GetMapping("{id}")
    public Monitor show(@PathVariable("id") Monitor monitor) {
        return monitor;
    }

    @Transactional
    @PostMapping("")
    public Monitor create(@RequestBody Monitor monitor) {
        return monitorDao.save(monitor);
    }

    @Transactional
    @PutMapping("{id}")
    public Monitor update(
            @PathVariable("id") Monitor monitorFromDB,
            @RequestBody Monitor newMonitor) {
        return monitorDao.update(monitorFromDB, newMonitor);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Monitor monitor) {
        monitorDao.delete(monitor);
    }

}
