package web.mvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.UserService;

@Controller
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{url}")
    public void loginForm() {

    }

    @PostMapping("/loginCheck")
    public String login(User user, HttpSession session) {
        log.info("user login uerIO={}, pwd={}",user.getUserId(), user.getPwd());

        User dbUser = userService.loginCheck(user);

        session.setAttribute("loginUser",dbUser);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("user logout");
        session.invalidate();//모든세션의정보를 무효화

        return "redirect:/";
    }
}
