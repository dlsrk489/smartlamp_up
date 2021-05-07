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

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserEntityByUserEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public Optional<UserEntity> findUser(String userId)
    {
        return userRepository.findUserEntityByUserEmail(userId);
    }
    public UserEntity save(UserEntity user)
    {
        return userRepository.save(user);
    }

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
