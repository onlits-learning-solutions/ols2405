package ols2405.mlm.form;

import jakarta.validation.constraints.NotBlank;

public class UnitForm {
    @NotBlank    
    private String unit;
    
    @NotBlank
    private String name;

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
