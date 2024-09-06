package com.toyproject.springbootforbasicboard.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @RequestMapping(value = "/load-form", method = {RequestMethod.GET})
    @ResponseBody
    public String boardLoad() throws Exception {
        return "board.html";
    }

}
