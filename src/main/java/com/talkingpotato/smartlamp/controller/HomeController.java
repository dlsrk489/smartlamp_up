package com.talkingpotato.smartlamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    /**
     * Explanation : 컨트롤러 연결 data 페이지 <br/>
     * date : 2021-05-08 오전 12:36
     * @author : wgPark
    */
    @GetMapping("/")
    public String data()
    {
        return "data";
    }
}
