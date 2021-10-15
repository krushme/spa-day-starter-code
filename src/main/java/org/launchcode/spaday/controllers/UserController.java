package org.launchcode.spaday.controllers;


import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {
    private User currentUser;

    //render form

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }
    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
//        model.addAttribute("user", user);
        String errorString = "Your passwords should match";
        if(Objects.equals(user.getPassword(), verify)) {
            UserData.add(user);
            currentUser = user;
            model.addAttribute("user", user);
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", errorString);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }

    }

    @GetMapping("")
    public String displayAllUsers(Model model) {
        model.addAttribute("user", UserData.getByID(currentUser.getId()));
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @GetMapping("userList/{id}")
    public String displayAllUsersOnPage(@PathVariable int id, Model model) {
        model.addAttribute("user", UserData.getByID(id));
        return "user/userInfo";
    }
}
