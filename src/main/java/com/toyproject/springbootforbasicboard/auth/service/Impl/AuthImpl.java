package com.toyproject.springbootforbasicboard.auth.service.Impl;

import com.toyproject.springbootforbasicboard.auth.service.AuthService;
import com.toyproject.springbootforbasicboard.auth.service.mapper.AuthMapper;
import com.toyproject.springbootforbasicboard.common.Sha256;
import com.toyproject.springbootforbasicboard.vo.HistoryVO;
import com.toyproject.springbootforbasicboard.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    @Override
    public Map<String, Object> signUpUserData(Map<String, Object> inputData) throws Exception {
        Map<String, Object> outputData = inputData;
        System.out.println("result : " + inputData.get("uiId"));
        int duplicateCnt = authMapper.selectUserCountByUserId(inputData.get("uiId").toString());
        if(duplicateCnt > 0){
            outputData.put("RESULT_CODE", "DUPLICATE_ID");
            return outputData;
        }

        Timestamp crtDate = new Timestamp(System.currentTimeMillis());
        // 생성일시 : 타임스탬프
        outputData.put("uiCrtDate", crtDate);

        // 패스워드 암호화 : Sha256
        outputData.put("uiPwd", Sha256.encrypt(inputData.get("uiPwd").toString()));

        int lastInsIdx = 0;
        try {
            // INSERT
            lastInsIdx = authMapper.insertUserInfo(outputData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> historyData = new HashMap<>();
        historyData.put("uhCrtDate", crtDate);
        historyData.put("uiIdx", lastInsIdx);
        historyData.put("uhDetail", "USER_SIGNUP");

        try {
            // INSERT
            authMapper.insertUseHistoryInfo(historyData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        outputData.put("RESULT_CODE", "SUCCESS_SIGNUP");
        return outputData;
    }


}
