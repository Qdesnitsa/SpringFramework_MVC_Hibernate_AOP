package by.sidina.it_shop.controller;

import by.sidina.it_shop.dto.ConverterFromDtoToEntity;
import by.sidina.it_shop.dto.UserDto;
import by.sidina.it_shop.entity.user.User;
import by.sidina.it_shop.entity.user.UserRole;
import by.sidina.it_shop.entity.user.UserStatus;
import by.sidina.it_shop.service.exception.ServiceException;
import by.sidina.it_shop.service.user.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EntranceController {
    private final ConverterFromDtoToEntity converter;
    private final UserBaseService userBaseService;
    private final UserRoleBaseService userRoleBaseService;
    private final UserStatusBaseService userStatusBaseService;

    public EntranceController(@Qualifier("userService") UserBaseService userBaseService,
                              @Qualifier("userRoleService") UserRoleBaseService userRoleBaseService,
                              @Qualifier("userStatusService") UserStatusBaseService userStatusBaseService,
                              ConverterFromDtoToEntity converter) {
        this.userBaseService = userBaseService;
        this.userRoleBaseService = userRoleBaseService;
        this.userStatusBaseService = userStatusBaseService;
        this.converter = converter;
    }

    @GetMapping("/sign-up")
    public String signUpUser(@ModelAttribute("newUser") UserDto user) {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpUser(@Valid @ModelAttribute("newUser") UserDto user, BindingResult bindingResult, Model model,
                             @RequestParam("role_id") String roleId, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        try {
            if (userBaseService.findByEmail(user.getEmail()).isPresent()) {
                model.addAttribute("message", "User already exists");
            }
        } catch (ServiceException e) {
            UserRole userRole = (UserRole) userRoleBaseService.findById(Long.parseLong(roleId)).get();
            UserStatus userStatus = (UserStatus) userStatusBaseService.findById(1L).get();
            User userEntity = converter.convertUser(user, new User());
            userEntity.setUserRole(userRole);
            userEntity.setUserStatus(userStatus);
            userBaseService.add(userEntity);
            session.setAttribute("currentUser", userEntity);
            return "redirect:/home";
        }
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String signInUser(@ModelAttribute("existingUser") UserDto user) {
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String signInUser(@Valid @ModelAttribute("existingUser") UserDto user, BindingResult bindingResult,
                             Model model, HttpSession session) {
        Optional<User> existingUser = null;
        try {
            existingUser = userBaseService.findByEmail(user.getEmail());
            if (existingUser.isPresent()
                    && existingUser.get().getPassword().equals(user.getPassword())
                    && existingUser.get().getUserStatus().getId() != 2) {
                session.setAttribute("currentUser", existingUser.get());
                return "redirect:/home";
            } else {
                model.addAttribute("message", "Password is incorrect");
                return "sign-in";
            }
        } catch (ServiceException e) {
            model.addAttribute("message", "User is not registered");
            return "sign-in";
        }
    }

    @GetMapping("/home")
    public String getHomeUser() {
        return "home";
    }
}

