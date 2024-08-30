package com.toyproject.springbootforbasicboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private String uiId;
    private String uiPwd;
    private String uiName;
    private String uiPhone;
    private String uiEmail;
    private Timestamp uiCrtDate;
    private Timestamp uiUpdDate;
    private int uiState;
    private int uiAuth;

}
