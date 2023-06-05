package org.kaesoron.warehouse.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kaesoron.warehouse.dao.HDDDAO;
import org.kaesoron.warehouse.models.HDD;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hdds")
@Tag(name = "HDDs", description = "HDDs operations controller")
public class HDDController {
    private final HDDDAO hddDao;
    public HDDController(HDDDAO hdddao) {
        this.hddDao = hdddao;
    }

    @GetMapping("")
    @Operation(summary = "Get list of HDDs")
    public List<HDD> index() {
        return hddDao.index();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get the info of HDD by ID")
    public HDD show(@Parameter(description = "Unique ID of HDD")
                        @PathVariable("id") HDD hdd) {
        return hdd;
    }

    @Transactional
    @PostMapping("")
    @Operation(summary = "Create new HDD")
    public HDD create(@RequestBody HDD hdd) {
        return hddDao.save(hdd);
    }

    @Transactional
    @PutMapping("{id}")
    @Operation(summary = "Update HDD information")
    public HDD update(
            @Parameter(description = "Unique ID of HDD")
            @PathVariable("id") HDD hddFromDB,
            @RequestBody HDD newHdd) {
        return hddDao.update(hddFromDB, newHdd);
    }

    @Transactional
    @DeleteMapping("{id}")
    @Operation(summary = "Delete HDD information")
    public void delete(@Parameter(description = "Unique ID of HDD")
                           @PathVariable("id") HDD hdd) {
        hddDao.delete(hdd);
    }

}
