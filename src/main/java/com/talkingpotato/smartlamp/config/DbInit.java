package com.talkingpotato.smartlamp.config;

import com.talkingpotato.smartlamp.domains.user.UserEntity;
import com.talkingpotato.smartlamp.domains.user.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements InitializingBean {

    @Autowired
    private UserService userService;

    /**
     * Explanation : 디비에서 아이디를 조회한후 해당하는 유저가 없으면 생성하면서 권한을 부여한다. <br/>
     * date : 2021-05-08 오전 12:34
     * @author : yjChoi
    */
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
