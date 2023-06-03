package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.dao.HDDDAO;
import org.kaesoron.warehouse.models.HDD;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hdd")
public class HDDController {
    private final HDDDAO hddDao;
    public HDDController(HDDDAO hdddao) {
        this.hddDao = hdddao;
    }

    @GetMapping("")
    public List<HDD> index() {
        return hddDao.index();
    }

    @GetMapping("{id}")
    public HDD show(@PathVariable("id") HDD hdd) {
        return hdd;
    }

    @Transactional
    @PostMapping("")
    public HDD create(@RequestBody HDD hdd) {
        return hddDao.save(hdd);
    }

    @Transactional
    @PutMapping("{id}")
    public HDD update(
            @PathVariable("id") HDD hddFromDB,
            @RequestBody HDD newHdd) {
        return hddDao.update(hddFromDB, newHdd);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") HDD hdd) {
        hddDao.delete(hdd);
    }

}
