package com.toyproject.springbootforbasicboard.auth;

import com.toyproject.springbootforbasicboard.auth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/sign-in", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> signInUser(@RequestBody Map<String, Object> inputData) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        try {
            resultMap.put("signInInfo", authService.signInUserData(inputData));
            resultMap.put("response", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultMap;
    }

    @RequestMapping(value = "/test", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> test() throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        try {
            resultMap.put("RESULT", authService.testAPI());
            resultMap.put("RESPONSE", true);
        } catch ( Exception e ) {
            resultMap.put("RESPONSE", false);
            System.out.println(e.getMessage());
        }

        return resultMap;
    }
}
