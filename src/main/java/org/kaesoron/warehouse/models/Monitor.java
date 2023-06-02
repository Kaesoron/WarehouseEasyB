package org.kaesoron.warehouse.models;

import jakarta.persistence.*;

@Entity
public class Monitor extends Commodity {
    @Column(name="diagonal")
    private int diagonal;

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }
}
