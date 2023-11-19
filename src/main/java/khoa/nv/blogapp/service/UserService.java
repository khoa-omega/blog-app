package khoa.nv.blogapp.service;

import khoa.nv.blogapp.dto.UserDto;
import khoa.nv.blogapp.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}
