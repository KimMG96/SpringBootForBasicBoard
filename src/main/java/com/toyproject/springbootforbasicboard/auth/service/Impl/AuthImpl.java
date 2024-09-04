package com.toyproject.springbootforbasicboard.auth.service.Impl;

import com.toyproject.springbootforbasicboard.auth.service.AuthService;
import com.toyproject.springbootforbasicboard.auth.service.mapper.AuthMapper;
import com.toyproject.springbootforbasicboard.common.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    @Override
    public Map<String, Object> signUpUserData(Map<String, Object> inputData) throws Exception {
        Map<String, Object> outputData = new HashMap<>();
        
        // 회원가입 중복 조회
        String uiId = inputData.get("uiId").toString();
        int duplicateCnt = 0;
        try {
            // SELECT
            duplicateCnt = authMapper.selectUserCountByUserId(uiId);
            if(duplicateCnt > 0){
                outputData.put("RESULT_CODE", "DUPLICATE_ID");
                return outputData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Timestamp crtDate = new Timestamp(System.currentTimeMillis());
        // 생성일시 : 타임스탬프
        inputData.put("uiCrtDate", crtDate);

        // 패스워드 암호화 : Sha256
        inputData.put("uiPwd", Sha256.encrypt(inputData.get("uiPwd").toString()));

        // 회원가입 정보 DB에 저장
        try {
            // INSERT
            authMapper.insertUserInfo(inputData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> historyData = new HashMap<>();
        historyData.put("uhCrtDate", crtDate);
        historyData.put("uiIdx", inputData.get("uiIdx"));
        historyData.put("uhDetail", "USER_SIGNUP");

        // 회원가입 DB로그 생성
        try {
            // INSERT
            authMapper.insertUseHistoryInfo(historyData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        outputData.put("RESULT_CODE", "SUCCESS_SIGNUP");
        return outputData;
    }

    @Override
    public Map<String, Object> signInUserData(Map<String, Object> inputData) throws Exception {
        Map<String, Object> outputData = new HashMap<>();
        
        // 로그인 PWD 암호화하여 기존 Map에 다시 담아주기
        String chgUiPwd = Sha256.encrypt(inputData.get("uiPwd").toString());
        inputData.remove(("uiPwd"));
        inputData.put("uiPwd", chgUiPwd);
        
        // 로그인 ID, PWD로 계정 조회
        int cnt = 0;
        try {
            cnt = authMapper.selectUserCountByUserIdWithPwd(inputData);
            if(cnt != 1) {
                outputData.put("RESULT_CODE", "NONEXISTENT_USER");
                return outputData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 로그인 ID, PWD로 계정 조회 및 출력
        Map<String, Object> userInfoData = new HashMap<>();
        try {
            // SELECT
//            outputData.put("USER_INFO", authMapper.selectUserInfoByUserIdUserPwd(inputData));
            userInfoData = authMapper.selectUserInfoByUserIdUserPwd(inputData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> historyData = new HashMap<>();
        Timestamp crtDate = new Timestamp(System.currentTimeMillis());
        historyData.put("uhCrtDate", crtDate);
        historyData.put("uiIdx", userInfoData.get("uiIdx"));
        historyData.put("uhDetail", "USER_SIGNIN");

        // 로그인 DB로그 생성
        try {
            // INSERT
            authMapper.insertUseHistoryInfo(historyData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        outputData.put("USER_INFO", userInfoData);
        outputData.put("RESULT_CODE", "SUCCESS_SIGNIN");
        return outputData;
    }

    @Override
    public Map<String, Object> testAPI() throws Exception {
        Map<String, Object> outputData = new HashMap<>();

        int cnt = authMapper.selectAllUsersCount();
        outputData.put("COUNT_RESULT", cnt);

        return outputData;
    }


}
