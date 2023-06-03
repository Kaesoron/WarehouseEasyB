package org.kaesoron.warehouse.controllers;

import org.kaesoron.warehouse.dao.NotebookDAO;
import org.kaesoron.warehouse.models.Notebook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notebooks")
public class NotebookController {
    private final NotebookDAO notebookDao;
    public NotebookController(NotebookDAO notebookDao) {
        this.notebookDao = notebookDao;
    }

    @GetMapping("")
    public List<Notebook> index() {
        return notebookDao.index();
    }

    @GetMapping("{id}")
    public Notebook show(@PathVariable("id") Notebook notebook) {
        return notebook;
    }

    @Transactional
    @PostMapping("")
    public Notebook create(@RequestBody Notebook notebook) {
        return notebookDao.save(notebook);
    }

    @Transactional
    @PutMapping("{id}")
    public Notebook update(
            @PathVariable("id") Notebook notebookFromDB,
            @RequestBody Notebook newNotebook) {
        return notebookDao.update(notebookFromDB, newNotebook);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Notebook notebook) {
        notebookDao.delete(notebook);
    }

}
