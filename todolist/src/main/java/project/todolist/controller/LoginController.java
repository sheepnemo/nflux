package project.todolist.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.todolist.dto.UserDTO;
import project.todolist.form.LoginForm;
import project.todolist.service.UserService;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    private LoginController(UserService userService) {
        this.userService = userService;
    }

    //로그인
    @RequestMapping("/user/login")
    public String login(LoginForm loginForm, HttpSession session) {
        UserDTO loginUser = new UserDTO(loginForm.getLoginId(), loginForm.getLoginPw());

        if (userService.login(loginUser)) {
            session.setAttribute(SessionConst.LOGIN_USER, loginUser.getUserId());
        }
        else return "home";

        return "/login/menu";
    }

    //로그아웃
    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "home";
    }
}
