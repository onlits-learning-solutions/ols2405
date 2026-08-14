package ols2405.mlm.form;

import jakarta.validation.constraints.NotBlank;

public class LoginForm {
    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
