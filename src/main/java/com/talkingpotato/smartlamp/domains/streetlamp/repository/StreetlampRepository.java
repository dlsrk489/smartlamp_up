package com.talkingpotato.smartlamp.domains.streetlamp.repository;

import com.talkingpotato.smartlamp.domains.streetlamp.StreetlampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetlampRepository extends JpaRepository<StreetlampEntity,Long> {
}
