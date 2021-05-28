package com.talkingpotato.smartlamp.home.controller;

import com.talkingpotato.smartlamp.domains.Weather.service.WeatherService;
import com.talkingpotato.smartlamp.domains.covid.service.CovidCrawlingService;
import com.talkingpotato.smartlamp.domains.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    /**
     * Explanation : 컨트롤러 연결 data 페이지 <br/>
     * date : 2021-05-08 오전 12:36
     * @author : yjChoi
    */

    private final WeatherService weatherService;
    private final CovidService covidService;

    @Autowired
    public HomeController(WeatherService weatherService,CovidService covidService)
    {
        this.weatherService = weatherService;
        this.covidService = covidService;
    }

    @GetMapping("/")
    public String data(Model model)
    {
        model.addAttribute("weather",weatherService.getWeather());
        model.addAttribute("covid",covidService.getCovid());
        return "data";
    }
}
