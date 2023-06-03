package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.dao.CommodityDAO;
import org.kaesoron.warehouse.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class DefaultController {

    private final CommodityDAO commodityDAO;
    public DefaultController(CommodityDAO commodityDAO) {
        this.commodityDAO = commodityDAO;
    }
    @GetMapping("")
    public List<Commodity> show() {
        return commodityDAO.index();
    }

    @GetMapping("{id}")
    public Commodity show(@PathVariable("id") Commodity commodity) {
        return commodity;
    }
}
