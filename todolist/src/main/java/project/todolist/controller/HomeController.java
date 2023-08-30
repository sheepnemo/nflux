package project.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.todolist.dto.UserDTO;
import project.todolist.form.EnrollForm;
import project.todolist.service.UserService;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    //html 이동 (home 페이지)
    @GetMapping("/")
    public String home() { return "home"; }

    //html 이동 (회원 가입 페이지)
    @GetMapping("/enroll/enrollUser")
    public String enrollUser() { return "/enroll/enrollUser"; }

    //html 이동 (로그인 후 페이지)
    @GetMapping("/login/menu")
    public String loginMenu() { return "/login/menu"; }

    //회원 가입
    @PostMapping("/user/enroll")
    public String enrollUser(EnrollForm enrollForm) {
        UserDTO userDTO = new UserDTO(enrollForm.getUserName(), enrollForm.getUserId(), enrollForm.getUserPw());
        userService.join(userDTO);
        return "redirect:/";
    }
}
