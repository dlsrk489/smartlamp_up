package com.talkingpotato.smartlamp.config;

import com.talkingpotato.smartlamp.domain.user.UserEntity;
import com.talkingpotato.smartlamp.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements InitializingBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!userService.findUser("potato").isPresent())
        {
            UserEntity user = userService.save(UserEntity.builder()
                    .userEmail("potato")
                    .password(new BCryptPasswordEncoder().encode("talking"))
                    .enabled(true)
                    .build());
            userService.addAuthority(user.getUserId(),"ROLE_ADMIN");
        }
        if(!userService.findUser("sweet").isPresent())
        {
            UserEntity user = userService.save(UserEntity.builder()
                    .userEmail("sweet")
                    .password(new BCryptPasswordEncoder().encode("potato"))
                    .enabled(true)
                    .build());
            userService.addAuthority(user.getUserId(),"ROLE_USER");
        }
    }
}
