package com.toyproject.springbootforbasicboard.auth.service;

import com.toyproject.springbootforbasicboard.vo.UserVO;
import java.util.Map;

public interface AuthService {

    public Map<String, Object> signUpUserData(Map<String, Object> inputData) throws Exception;

    public Map<String, Object> signInUserData(Map<String, Object> inputData) throws Exception;

    public Map<String, Object> testAPI() throws Exception;
}
