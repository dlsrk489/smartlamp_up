package com.talkingpotato.smartlamp.domain.streetlamp.repository;

import com.talkingpotato.smartlamp.domain.streetlamp.StreetlampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetlampRepository extends JpaRepository<StreetlampEntity,Long> {
}
