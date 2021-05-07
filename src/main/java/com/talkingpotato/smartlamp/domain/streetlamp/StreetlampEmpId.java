package com.talkingpotato.smartlamp.domain.streetlamp;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Explanation : 2개의 주키를 할당하기 위한 클래스 <br/>
 * date : 2021-05-08 오전 12:36
 * @author : wgPark
*/
@Data
@Embeddable
public class StreetlampEmpId implements Serializable {
    private Long no;

    private LocalDateTime date;
}
