package org.kaesoron.warehouse.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kaesoron.warehouse.dao.CommodityDAO;
import org.kaesoron.warehouse.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@Tag(name = "Default commodities controller", description = "Methods for commodity list")
public class DefaultController {

    private final CommodityDAO commodityDAO;
    public DefaultController(CommodityDAO commodityDAO) {
        this.commodityDAO = commodityDAO;
    }
    @GetMapping("")
    @Operation(summary = "Show list of all commodities")
    public List<Commodity> show() {
        return commodityDAO.index();
    }

    @GetMapping("{id}")
    @Operation(summary = "Show the page of commodity by ID")
    public Commodity show(@Parameter(description = "Unique ID of commodity") @PathVariable("id") Commodity commodity) {
        return commodity;
    }
}
