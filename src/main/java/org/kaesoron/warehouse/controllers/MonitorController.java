package org.kaesoron.warehouse.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kaesoron.warehouse.dao.MonitorDAO;
import org.kaesoron.warehouse.models.Monitor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("monitors")
@Tag(name = "Monitors", description = "Monitors operations controller")
public class MonitorController {
    private final MonitorDAO monitorDao;
    public MonitorController(MonitorDAO monitorDao) {
        this.monitorDao = monitorDao;
    }

    @GetMapping("")
    @Operation(summary = "Get list of monitors")
    public List<Monitor> index() {
        return monitorDao.index();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get the info of monitor by ID")
    public Monitor show(@Parameter(description = "Unique ID of monitor")
                            @PathVariable("id") Monitor monitor) {
        return monitor;
    }

    @Transactional
    @PostMapping("")
    @Operation(summary = "Create new monitor")
    public Monitor create(@RequestBody Monitor monitor) {
        return monitorDao.save(monitor);
    }

    @Transactional
    @PutMapping("{id}")
    @Operation(summary = "Update monitor information")
    public Monitor update(
            @Parameter(description = "Unique ID of monitor")
            @PathVariable("id") Monitor monitorFromDB,
            @RequestBody Monitor newMonitor) {
        return monitorDao.update(monitorFromDB, newMonitor);
    }

    @Transactional
    @DeleteMapping("{id}")
    @Operation(summary = "Delete monitor information")
    public void delete( @Parameter(description = "Unique ID of monitor")
                        @PathVariable("id") Monitor monitor) {
        monitorDao.delete(monitor);
    }

}
