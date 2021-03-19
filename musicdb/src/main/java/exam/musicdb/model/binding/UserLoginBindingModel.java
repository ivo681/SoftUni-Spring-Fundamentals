package exam.musicdb.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty string")
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password cannot be empty string")
    @Length(min = 5, max = 20 ,message = "Length must be between 5 and 20 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
