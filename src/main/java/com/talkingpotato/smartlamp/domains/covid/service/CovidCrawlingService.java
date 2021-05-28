package com.talkingpotato.smartlamp.domains.covid.service;

import com.talkingpotato.smartlamp.domains.covid.domain.CovidEntity;
import com.talkingpotato.smartlamp.domains.covid.domain.repository.CovidRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * Created by yjChoi on 2021-05-27.
 */
@Service
@RequiredArgsConstructor
public class CovidCrawlingService {
    private final CovidRepository covidRepository;

    @Scheduled(cron="0 0/1 * * * *")
    private void crawlingCorona()
    {
        String url = "https://www.busan.go.kr/covid19/Prevention06.do";
        Document doc = null;
        Elements tmp;
        String gu = "부산진구";
        Timestamp time = null;
        String num = null;
        int index = 0;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Elements element = doc.select("div.covid-state-table").select("tbody > tr:nth-child(1) > td:nth-child(6)");
        Elements element = doc.select("div.covid-state-table");

        System.out.println("== == == == == == == ==");
        Iterator<Element> ie1 = element.select("tbody > tr:nth-child(1) > td:nth-child(6)").iterator();

        System.out.println(ie1.next().text());
        num = ie1.next().text();

        System.out.println("== == == == == == == ==");

        if (num.equals("-"))
            num = "0";

        System.out.println("출력~" + num);
        covidRepository.save(CovidEntity.builder()
                .gu(gu)
                .date(LocalDateTime.now())
                .num(num)
                .build());
//        CV.add(new CovidVO(gu, num));
    }
}
