package com.discordance.discordance.controller.register;

import com.discordance.discordance.domain.user.User;
import com.discordance.discordance.domain.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class RegisterController {

    private final UserRepository userRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("user") User user) {
        return "register";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }



        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/")
    public Optional<User> read(String id){
        return userRepository.findById(id);
    }
}
