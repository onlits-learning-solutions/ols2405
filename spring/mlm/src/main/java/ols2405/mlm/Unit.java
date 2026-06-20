package ols2405.mlm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Unit {
    @Id
    private String unit;
    private String name;

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }
}
