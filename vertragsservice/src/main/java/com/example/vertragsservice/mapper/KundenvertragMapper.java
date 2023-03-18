package com.example.vertragsservice.mapper;

import com.example.vertragsservice.api.model.KundenvertragDto;
import com.example.vertragsservice.enitity.Kunde;
import com.example.vertragsservice.enitity.Kundenvertrag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KundenvertragMapper {

    @Mapping(source = "kunde", target = "kunde")
    KundenvertragDto toDto(Kundenvertrag kundenvertrag, Kunde kunde);
}
