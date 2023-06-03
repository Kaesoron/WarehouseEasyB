package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.dao.PCDAO;
import org.kaesoron.warehouse.models.PC;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pc")
public class PCController {
    private final PCDAO pcDao;
    public PCController(PCDAO pcDao) {
        this.pcDao = pcDao;
    }

    @GetMapping("")
    public List<PC> index() {
        return pcDao.index();
    }

    @GetMapping("{id}")
    public PC show(@PathVariable("id") PC pc) {
        return pc;
    }

    @Transactional
    @PostMapping("")
    public PC create(@RequestBody PC pc) {
        return pcDao.save(pc);
    }

    @Transactional
    @PutMapping("{id}")
    public PC update(
            @PathVariable("id") PC pcFromDB,
            @RequestBody PC newPC) {
        return pcDao.update(pcFromDB, newPC);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") PC pc) {
        pcDao.delete(pc);
    }

}
