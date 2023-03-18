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
public class Kundenvertrag extends Vertrag {

    private Long kunde;

    private BigDecimal leistungssatz;
}
