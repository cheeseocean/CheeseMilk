package com.cheeseocean.core.web.api;

import com.cheeseocean.common.util.VerifyCodeGenerator;
import com.cheeseocean.common.web.response.Result;
import com.cheeseocean.core.api.UserService;
import com.cheeseocean.core.service.MailService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RegisterController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @PostMapping(value = "/check", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void check(@RequestBody String s) throws IOException {
//        System.out.println(request.getInputStream().read());
        System.out.println("check");
        System.out.println(s);
    }

    @GetMapping(value = "/check", params = "username")
    @ResponseStatus(HttpStatus.OK)
    public void usernameCheck(@RequestParam("username") String username) {

    }

    @GetMapping(value = "/code/email", params = "address")
    @ResponseStatus(HttpStatus.OK)
    public Result<String> verifyEmail(@RequestParam("address") @Email String email, Model model, HttpSession session) {

        String verifyCode = VerifyCodeGenerator.generate(6);
        mailService.sendMail(email, verifyCode);

        return Result.ok("verify email already send to: " + email);
    }

}
