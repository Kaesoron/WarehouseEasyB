package org.kaesoron.warehouse.repository;

import org.kaesoron.warehouse.models.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
