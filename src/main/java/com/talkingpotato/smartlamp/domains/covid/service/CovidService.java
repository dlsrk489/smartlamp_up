package com.talkingpotato.smartlamp.domains.covid.service;

import com.talkingpotato.smartlamp.domains.covid.domain.CovidEntity;
import com.talkingpotato.smartlamp.domains.covid.domain.repository.CovidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by yjChoi on 2021-05-27.
 */

@Service
@RequiredArgsConstructor
public class CovidService {

    private final CovidRepository covidRepository;

    public CovidEntity getCovid()
    {
        return covidRepository.findFirstByOrderByIdDesc();
    }

}
