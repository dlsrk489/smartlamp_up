package com.talkingpotato.smartlamp.domains.covid.domain.repository;

import com.talkingpotato.smartlamp.domains.covid.domain.CovidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidRepository extends JpaRepository<CovidEntity,Long> {
    CovidEntity findDistinctTopByGu(String gu);
    CovidEntity findFirstByOrderByIdDesc();
}
