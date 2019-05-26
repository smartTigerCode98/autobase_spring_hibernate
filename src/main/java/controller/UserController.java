package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import java.util.Map;

@RestController
@RequestMapping("/api/verifyUser")

public class UserController {

   @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> verifyUser(@RequestParam Map<String, String> requestParams) {
        try {
            String userInfo = userService.getUserInfo(requestParams.get("email"), requestParams.get("password"));
            System.out.println(userInfo);
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }

}
