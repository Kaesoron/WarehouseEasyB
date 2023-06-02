package org.kaesoron.warehouse.models;

import jakarta.persistence.*;

@Entity
public class HDD extends Commodity {

    @Column(name = "volume")
    private long volume;
    @Column(name="measure")
    private HDDVolumeMeasure volumeMeasure;

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public HDDVolumeMeasure getVolumeMeasure() {
        return volumeMeasure;
    }

    public void setVolumeMeasure(HDDVolumeMeasure volumeMeasure) {
        this.volumeMeasure = volumeMeasure;
    }
}
