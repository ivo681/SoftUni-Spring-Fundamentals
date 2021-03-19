package exam.musicdb.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserRegisterBindingModel {
    private String username;
    private String fullName;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty string")
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Full name cannot be empty string")
    @Length(min = 3, max = 20, message = "Full name length must be between 3 and 20 characters")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NotBlank(message = "Password cannot be empty string")
    @Length(min = 5, max = 20 ,message = "Password length must be between 5 and 20 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Password cannot be empty string")
    @Length(min = 5, max = 20 ,message = "Password length must be between 5 and 20 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
