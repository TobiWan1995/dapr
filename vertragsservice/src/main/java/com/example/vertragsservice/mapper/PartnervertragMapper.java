package com.example.vertragsservice.mapper;

import com.example.vertragsservice.api.model.PartnervertragDto;
import com.example.vertragsservice.enitity.Mitarbeiter;
import com.example.vertragsservice.enitity.Partnervertrag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PartnervertragMapper {

    @Mapping(source = "mitarbeiter", target = "mitarbeiter")
    PartnervertragDto toDto(Partnervertrag partnervertrag, Mitarbeiter mitarbeiter);
}
