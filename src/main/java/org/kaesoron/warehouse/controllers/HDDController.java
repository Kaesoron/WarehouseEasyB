package org.kaesoron.warehouse.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kaesoron.warehouse.dao.HDDDAO;
import org.kaesoron.warehouse.models.HDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hdd")
public class HDDController {
    private final HDDDAO hdddao;

    public HDDController(HDDDAO hdddao) {
        this.hdddao = hdddao;
    }
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("")
    public String index() throws JsonProcessingException {
        return objectMapper.writeValueAsString(hdddao.index());
    }

    @GetMapping("{id}")
    public HDD show(@PathVariable("id") HDD hdd) throws JsonProcessingException {
        return hdd;
//        return objectMapper.writeValueAsString(hdddao.show(id));
    }

    @Transactional
    @PostMapping("")
    public String create(@RequestBody String hddInput) throws JsonProcessingException {
        HDD hdd = objectMapper.readValue(hddInput, HDD.class);
        hdddao.save(hdd);
        return "redirect:/hdd";
    }

    @Transactional
    @PutMapping("")
    public String update(@PathVariable long id, @RequestBody String input) throws JsonProcessingException {
        HDD newHdd = objectMapper.readValue(input, HDD.class);
        hdddao.update(id, newHdd);
        return "id";
    }

    @Transactional
    @DeleteMapping("{id}")
    public String delete(@PathVariable long id) {
        //To get 404 if not found
        HDD hdd = hdddao.show(id);

        hdddao.delete(id);
        return "redirect:/hdd";
    }


}
