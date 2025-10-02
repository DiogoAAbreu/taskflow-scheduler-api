package dev.diogoalberto.taskflow_scheduler_api.infrastructure.security;


import dev.diogoalberto.taskflow_scheduler_api.business.dto.UserDTO;
import dev.diogoalberto.taskflow_scheduler_api.infrastructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserClient client;

    public UserDetails loadUserByUsernameAndToken(String email, String token){
        UserDTO userDTO = client.getUserByEmail(email,token);

        return User
                .withUsername(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
