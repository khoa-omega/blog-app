package khoa.nv.blogapp.controller;

import khoa.nv.blogapp.dto.UserDto;
import khoa.nv.blogapp.form.UserCreateForm;
import khoa.nv.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/users")
    public UserDto create(@RequestBody UserCreateForm form) {
        return userService.create(form);
    }
}
