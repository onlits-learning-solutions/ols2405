package ols2405.mlm.form;

import jakarta.validation.constraints.NotBlank;

public class ProductForm {
    @NotBlank
    private String name;

    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
