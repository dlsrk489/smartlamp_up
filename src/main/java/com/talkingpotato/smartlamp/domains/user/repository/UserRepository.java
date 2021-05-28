package com.talkingpotato.smartlamp.domains.user.repository;

import com.talkingpotato.smartlamp.domains.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUserEmail(String email);
}
