package com.example.vertragsservice.enitity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Partnervertrag extends Vertrag {

    private Long mitarbeiter;

    private BigDecimal tagessatz;
}
