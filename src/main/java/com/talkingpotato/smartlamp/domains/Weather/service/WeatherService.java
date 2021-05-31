package com.talkingpotato.smartlamp.domains.Weather.service;


import com.talkingpotato.smartlamp.domains.Weather.domain.repository.WeatherRepository;
import com.talkingpotato.smartlamp.domains.Weather.domain.WeatherEntity;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * Created by yjChoi on 2021-05-27.
 */
@Service
@RequiredArgsConstructor
public class WeatherService {


    private final WeatherRepository weatherRepository;

    public WeatherEntity getWeather()
    {
        return weatherRepository.findFirstByOrderByIdDesc().orElseThrow(() -> new IllegalArgumentException("날씨정보가없습니다."));
    }
    @Scheduled(cron="0 0/1 * * * *")
    public void saveWeather()
    {
        weatherRepository.save(crawlingWeather());
    }

    private WeatherEntity crawlingWeather()
    {
        String url = "https://search.naver.com/search.naver?query=가야동날씨";
        Document doc = null;
        String gu = "부산진구";
        String temperature = null;
        String weather = null;
        String tmp2 = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements element = doc.select("p.info_temperature");

        System.out.println("== == == == == == == ==");
        Iterator<Element> ie1 = element.select("span.todaytemp").iterator();

        temperature = ie1.next().text();
        System.out.println(temperature);


        System.out.println("== == == == == == == ==");

        element = doc.select("ul.info_list");
        ie1 = element.select("p.cast_txt").iterator();

        tmp2 = ie1.next().text();

        int idx = tmp2.indexOf(",");
        weather = tmp2.substring(0, idx);

        System.out.println(weather);

        return WeatherEntity.builder()
                .gu(gu)
                .date(LocalDateTime.now())
                .weather(weather)
                .temperature(temperature)
                .build();
    }
}
