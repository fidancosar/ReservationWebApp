package Controller;

import Business.UserService;
import Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getAllUserByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(){
        return ResponseEntity.ok(userService.createUser());
    }
}
