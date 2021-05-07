package com.talkingpotato.smartlamp.service;

import com.talkingpotato.smartlamp.domain.user.UserAuthority;
import com.talkingpotato.smartlamp.domain.user.UserEntity;
import com.talkingpotato.smartlamp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    /**
     * Explanation : 유저의 아이디로 디비에 검색을 하고 해당하는 유저가 있으면 유저 객체로 반환해준다. <br/>
     * date : 2021-05-08 오전 12:39
     * @author : wgPark
     */
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserEntityByUserEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public Optional<UserEntity> findUser(String userId)
    {
        return userRepository.findUserEntityByUserEmail(userId);
    }

    /**
     * Explanation : DB에 유저 저장 <br/>
     * date : 2021-05-08 오전 12:39
     * @author : wgPark
    */
    public UserEntity save(UserEntity user)
    {
        return userRepository.save(user);
    }

    /**
     * Explanation : 유저가 권한을 가지고 있지 않다면 권한을 할당해줌 <br/>
     * date : 2021-05-08 오전 12:39
     * @author : wgPark
    */
    public void addAuthority(Long userid,String authority)
    {
        userRepository.findById(userid).ifPresent(user -> {
            UserAuthority newRole = new UserAuthority(user.getUserId(),authority);
            if(user.getAuthorities() == null)
            {
                HashSet<UserAuthority> authorites = new HashSet<>();

                authorites.add(newRole);
                save(user);
            }else if(!user.getAuthorities().contains(newRole))
            {
                HashSet<UserAuthority> authorities = new HashSet<>();
                authorities.addAll(user.getAuthorities());
                authorities.add(newRole);
                user.setAuthorities((authorities));
                save(user);
            }
        });
    }
}
