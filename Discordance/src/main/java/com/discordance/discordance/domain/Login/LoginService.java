package com.discordance.discordance.domain.Login;

import com.discordance.discordance.domain.user.User;
import com.discordance.discordance.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    public User login(String id, String userPassword) {
        return userRepository.findById(id)
                .filter(m -> m.getUserPassword().equals(userPassword))
                .orElse(null);
    }
}
