package com.talkingpotato.smartlamp.domains.covid.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "covid")
public class CovidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String gu;

    private LocalDateTime date;

    String num;
}
