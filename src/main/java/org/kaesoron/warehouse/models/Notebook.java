package org.kaesoron.warehouse.models;

import jakarta.persistence.*;

@Entity
public class Notebook extends Commodity {
    @Column(name = "screenDiagonal")
    private ScreenDiagonal screenDiagonal;

    public ScreenDiagonal getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(ScreenDiagonal screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }
}
