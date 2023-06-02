package org.kaesoron.warehouse.models;

public enum ScreenDiagonal {
    d13(13),
    d14(14),
    d15(15),
    d17(17);

    public final int count;

    ScreenDiagonal(int count){
        this.count=count;
    }
}
