package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.Notebook;
import org.kaesoron.warehouse.repository.NotebookRepository;
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

    public Notebook show(long id) {
        return notebookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Transactional
    public void update(long id, Notebook notebook) {
        Notebook toBeUpdated = show(id);
        toBeUpdated.setCommodityType(notebook.getCommodityType());
        toBeUpdated.setSeriesNumber(notebook.getSeriesNumber());
        toBeUpdated.setManufacturer(notebook.getManufacturer());
        toBeUpdated.setPrice(notebook.getPrice());
        toBeUpdated.setQuantity(notebook.getQuantity());
        toBeUpdated.setScreenDiagonal(notebook.getScreenDiagonal());
        notebookRepository.save(toBeUpdated);
    }

    @Transactional
    public void delete (long id) {
        notebookRepository.deleteById(id);
    }

}
