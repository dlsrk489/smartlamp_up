package com.talkingpotato.smartlamp.domain.streetlamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
