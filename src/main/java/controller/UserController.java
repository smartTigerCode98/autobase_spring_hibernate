package controller;

import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import java.util.Map;

@RestController
@RequestMapping("/api/users")

public class UserController {

   @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UsersEntity> verifyUser(@RequestParam Map<String, String> requestParams) {
        return new ResponseEntity<>(userService.getUserInfo(requestParams.get("email"), requestParams.get("password")), HttpStatus.OK);
    }

}
