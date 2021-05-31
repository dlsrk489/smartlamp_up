package com.talkingpotato.smartlamp.domains.Weather.domain.repository;

import com.talkingpotato.smartlamp.domains.Weather.domain.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by wgPark on 2021-05-28.
 */
public interface WeatherRepository extends JpaRepository<WeatherEntity,Long> {
    Optional<WeatherEntity> findDistinctTopByGu(String gu);
    Optional<WeatherEntity> findTopByGu(String gu);
    Optional<WeatherEntity> findFirstByOrderByIdDesc();
}
