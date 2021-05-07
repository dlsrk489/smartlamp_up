package com.talkingpotato.smartlamp.domain.streetlamp;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class StreetlampEmpId implements Serializable {
    private Long no;

    private LocalDateTime date;
}
