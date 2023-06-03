package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.dao.*;
import org.kaesoron.warehouse.models.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class DefaultController {
    private final HDDDAO hdddao;
    private final NotebookDAO notebookDAO;
    private final PCDAO pcdao;
    private final MonitorDAO monitorDAO;
    public DefaultController(
                             HDDDAO hdddao,
                             NotebookDAO notebookDAO,
                             PCDAO pcdao,
                             MonitorDAO monitorDAO) {
        this.notebookDAO = notebookDAO;
        this.pcdao = pcdao;
        this.hdddao = hdddao;
        this.monitorDAO = monitorDAO;
    }


    @GetMapping
    public void index() {
        notebookDAO.save(new Notebook());
        pcdao.save(new PC());
        hdddao.save(new HDD());
        monitorDAO.save(new Monitor());
    }

    @GetMapping("{id}")
    public Commodity show(@PathVariable("id") Commodity commodity) {
        return commodity;
    }

}
