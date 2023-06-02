package org.kaesoron.warehouse.models;

import jakarta.persistence.*;

@Entity
public class PC extends Commodity {
    @Column(name = "pc_type")
    private PCType pcType;

    public PCType getPcType() {
        return pcType;
    }

    public void setPcType(PCType pcType) {
        this.pcType = pcType;
    }
}
