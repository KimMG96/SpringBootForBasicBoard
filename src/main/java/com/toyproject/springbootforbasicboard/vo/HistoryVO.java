package com.toyproject.springbootforbasicboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryVO {

    private Timestamp uhCrtDate;
    private int uiIdx;
    private String uhDetail;

}
