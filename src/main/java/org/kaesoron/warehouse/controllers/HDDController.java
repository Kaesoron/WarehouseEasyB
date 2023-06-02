package org.kaesoron.warehouse.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.kaesoron.warehouse.dao.HDDDAO;
import org.kaesoron.warehouse.models.HDD;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hdd")
public class HDDController {
    private final HDDDAO hdddao;
    public HDDController(HDDDAO hdddao) {
        this.hdddao = hdddao;
    }

    @GetMapping("")
    public List<HDD> index() {
        return hdddao.index();
    }

    @GetMapping("{id}")
    public HDD show(@PathVariable("id") HDD hdd) {
        return hdd;
    }

    @Transactional
    @PostMapping("")
    public HDD create(@RequestBody HDD hdd) {
        return hdddao.save(hdd);
    }

    @Transactional
    @PutMapping("{id}")
    public HDD update(
            @PathVariable("id") HDD hddFromDB,
            @RequestBody HDD newHdd) {
        return hdddao.update(hddFromDB, newHdd);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") HDD hdd) {
        hdddao.delete(hdd);
    }

}
