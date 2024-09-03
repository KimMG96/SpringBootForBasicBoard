package com.toyproject.springbootforbasicboard.auth;

import com.toyproject.springbootforbasicboard.auth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/sign-up", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> signUpUser(@RequestBody Map<String, Object> inputData) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        try {
            resultMap.put("signUpInfo", authService.signUpUserData(inputData));
            resultMap.put("response", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultMap;
    }
}
