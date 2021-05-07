package com.talkingpotato.smartlamp.domain.user.repository;

import com.talkingpotato.smartlamp.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUserEmail(String email);
}
