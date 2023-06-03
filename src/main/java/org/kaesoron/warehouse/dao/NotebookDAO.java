package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.Notebook;
import org.kaesoron.warehouse.repository.NotebookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotebookDAO {
    @Autowired
    private NotebookRepository notebookRepository;

    public List<Notebook> index() {
        return notebookRepository.findAll();
    }

    @Transactional
    public Notebook save(Notebook notebook) {
        notebookRepository.save(notebook);
        return notebook;
    }

    @Transactional
    public Notebook update(Notebook notebookFromDB, Notebook newNotebook) {
        BeanUtils.copyProperties(newNotebook, notebookFromDB, "id");
        notebookRepository.save(notebookFromDB);
        return notebookFromDB;
    }

    @Transactional
    public void delete (Notebook notebook) {
        notebookRepository.delete(notebook);
    }

}
