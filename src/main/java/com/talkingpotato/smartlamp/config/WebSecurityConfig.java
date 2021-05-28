package com.talkingpotato.smartlamp.config;

import com.talkingpotato.smartlamp.domains.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private DefaultLoginPageGeneratingFilter a;
    private final UserService userService;

    /**
     * Explanation : 비밀번호 암호화 방식 지정 BCrypt 방식 <br/>
     * date : 2021-05-08 오전 12:35
     * @author : yjChoi
    */
    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * Explanation : 보안 형식 지정 <br/>
     * date : 2021-05-08 오전 12:35
     * @author : yjChoi
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);
    }

    /**
     * Explanation : authorizeRequests anyRequest 들어오는 요청을 전부 허용한다. <br/>
     * date : 2021-05-08 오전 12:36
     * @author : yjChoi
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests( req ->
                        req.anyRequest().permitAll()
                )
                .formLogin(
                        login ->
                                login.permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll())
                ;
    }
}
