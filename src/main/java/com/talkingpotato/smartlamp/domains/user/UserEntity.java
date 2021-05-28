package com.talkingpotato.smartlamp.domains.user;

import com.talkingpotato.smartlamp.config.BaseTimeEntity;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

/**
 * Explanation : User 클래스로 테이블을 생성하고 Spring Web Security의 UserDetails를 구현해한다. <br/>
 * date : 2021-05-08 오전 12:38
 * @author : yjChoi
*/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false,unique = true)
    private String userEmail;
    private boolean enabled;
    private String password;

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",foreignKey = @ForeignKey(name="user_id"))
    private Set<UserAuthority> authorities;


}
