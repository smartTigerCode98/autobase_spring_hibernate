package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getUserInfo(String email, String password) throws JsonProcessingException {
        String userInfo = "";
        UsersEntity usersEntity = userRepository.findByEmailAndPassword(email, password);
        if (usersEntity != null){
            usersEntity.setPassword("");
            ObjectMapper objectMapper = new ObjectMapper();
            userInfo = objectMapper.writeValueAsString(usersEntity);
        }
        return userInfo;
    }
}
