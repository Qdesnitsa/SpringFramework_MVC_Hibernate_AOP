package by.sidina.it_shop.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class UserDto {
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{2,100}", message = "name should be between 2 and 100 symbols")
    private String name;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{2,100}", message = "surname should be between 2 and 100 symbols")
    private String surname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 5, max = 100, message = "password should be between 5 and 100 symbols")
    private String password;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{2,100}")
    private String country;

    public UserDto() {
    }

    public UserDto(String name, String surname, String email, String password, String country) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
