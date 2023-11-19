package khoa.nv.blogapp.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserUpdateForm {
    @NotBlank(message = "The name must not be blank.")
    @Length(max = 255, message = "The name has a maximum of 255 characters.")
    private String name;

    @NotBlank(message = "The username must not be blank.")
    @Length(max = 255, message = "The username has a maximum of 255 characters.")
    private String username;

    @NotBlank(message = "The email must not be blank.")
    @Length(max = 255, message = "The email has a maximum of 255 characters.")
    private String email;

    @NotBlank(message = "The password must not be blank.")
    @Length(max = 255, message = "The password has a maximum of 255 characters.")
    private String password;
}
