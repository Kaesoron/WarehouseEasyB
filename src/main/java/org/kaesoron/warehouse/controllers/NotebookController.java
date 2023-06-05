package org.kaesoron.warehouse.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kaesoron.warehouse.dao.NotebookDAO;
import org.kaesoron.warehouse.models.Notebook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notebooks")
@Tag(name = "Notebooks", description = "Notebooks operations controller")
public class NotebookController {
    private final NotebookDAO notebookDao;
    public NotebookController(NotebookDAO notebookDao) {
        this.notebookDao = notebookDao;
    }

    @GetMapping("")
    @Operation(summary = "Get list of notebooks")
    public List<Notebook> index() {
        return notebookDao.index();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get the info of notebook by ID")
    public Notebook show(@Parameter(description = "Unique ID of notebook")
                             @PathVariable("id") Notebook notebook) {
        return notebook;
    }

    @Transactional
    @PostMapping("")
    @Operation(summary = "Create new notebook")
    public Notebook create(@RequestBody Notebook notebook) {
        return notebookDao.save(notebook);
    }

    @Transactional
    @PutMapping("{id}")
    @Operation(summary = "Update notebook information")
    public Notebook update(
            @Parameter(description = "Unique ID of notebook")
            @PathVariable("id") Notebook notebookFromDB,
            @RequestBody Notebook newNotebook) {
        return notebookDao.update(notebookFromDB, newNotebook);
    }

    @Transactional
    @DeleteMapping("{id}")
    @Operation(summary = "Delete notebook information")
    public void delete( @Parameter(description = "Unique ID of notebook")
                        @PathVariable("id") Notebook notebook) {
        notebookDao.delete(notebook);
    }

}
