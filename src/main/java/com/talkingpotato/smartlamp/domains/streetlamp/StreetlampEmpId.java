package com.talkingpotato.smartlamp.domains.streetlamp;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Explanation : 2개의 주키를 할당하기 위한 클래스 <br/>
 * date : 2021-05-08 오전 12:36
 * @author : yjChoi
*/
@Data
@Embeddable
public class StreetlampEmpId implements Serializable {
    private Long no;

    private LocalDateTime date;
}
