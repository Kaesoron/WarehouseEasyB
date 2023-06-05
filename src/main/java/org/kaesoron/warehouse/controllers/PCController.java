package org.kaesoron.warehouse.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kaesoron.warehouse.dao.PCDAO;
import org.kaesoron.warehouse.models.PC;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pcs")
@Tag(name = "PCs", description = "Personal computers operations controller")
public class PCController {
    private final PCDAO pcDao;
    public PCController(PCDAO pcDao) {
        this.pcDao = pcDao;
    }

    @GetMapping("")
    @Operation(summary = "Get list of PCs")
    public List<PC> index() {
        return pcDao.index();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get the info of PC by ID")
    public PC show(@Parameter(description = "Unique ID of PC")
                       @PathVariable("id") PC pc) {
        return pc;
    }

    @Transactional
    @PostMapping("")
    @Operation(summary = "Create new PC")
    public PC create(@RequestBody PC pc) {
        return pcDao.save(pc);
    }

    @Transactional
    @PutMapping("{id}")
    @Operation(summary = "Update PC information")
    public PC update(
            @Parameter(description = "Unique ID of PC")
            @PathVariable("id") PC pcFromDB,
            @RequestBody PC newPC) {
        return pcDao.update(pcFromDB, newPC);
    }

    @Transactional
    @DeleteMapping("{id}")
    @Operation(summary = "Delete PC information")
    public void delete(@Parameter(description = "Unique ID of PC")
                       @PathVariable("id") PC pc) {
        pcDao.delete(pc);
    }

}
