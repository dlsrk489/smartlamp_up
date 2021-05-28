package com.talkingpotato.smartlamp.domains.streetlamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Explanation : Jpa를 이용하기위한 엔티티 클래스 <br/>
 * date : 2021-05-08 오전 12:37
 * @author : yjChoi
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="streetlamp")
public class StreetlampEntity{

    @EmbeddedId
    private StreetlampEmpId id;

    private float fineDust;
    private String network;

}
