package com.talkingpotato.smartlamp.domains.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Explanation : 유저별 권한을 매핑해준다 <br/>
 * date : 2021-05-08 오전 12:37
 * @author : yjChoi
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_authority")
@IdClass(UserAuthority.class)
public class UserAuthority implements GrantedAuthority {

    @Id
    @Column(name="user_id")
    private Long userId;

    @Id
    @Column(length = 20)
    private String authority;
}
