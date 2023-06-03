package org.kaesoron.warehouse.dao;

import org.kaesoron.warehouse.models.PC;
import org.kaesoron.warehouse.repository.PCRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PCDAO {
    @Autowired
    private PCRepository pcRepository;

    public List<PC> index() {
        return pcRepository.findAll();
    }

    @Transactional
    public PC save(PC pc) {
        pcRepository.save(pc);
        return pc;
    }

    @Transactional
    public PC update(PC pcFromDB, PC newPc) {
        BeanUtils.copyProperties(newPc, pcFromDB, "id");
        pcRepository.save(pcFromDB);
        return pcFromDB;
    }

    @Transactional
    public void delete (PC pc) {
        pcRepository.delete(pc);
    }

}
