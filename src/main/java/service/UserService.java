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

    public UsersEntity getUserInfo(String email, String password){
        UsersEntity usersEntity = userRepository.findByEmailAndPassword(email, password);
        if (usersEntity != null){
            usersEntity.setPassword("");
        }
        return usersEntity;
    }
}
