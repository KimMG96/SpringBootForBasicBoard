package com.toyproject.springbootforbasicboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime uiCrtDate;
    private LocalDateTime uiUpdDate;
    private int uiState;
    private int uiAuth;

}
