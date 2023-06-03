package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.models.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class DefaultController {
    @GetMapping("{id}")
    public Commodity show(@PathVariable("id") Commodity commodity) {
        return commodity;
    }

}
