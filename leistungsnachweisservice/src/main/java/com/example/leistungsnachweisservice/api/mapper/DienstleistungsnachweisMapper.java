package com.example.leistungsnachweisservice.api.mapper;

import com.example.leistungsnachweisservice.api.model.DienstleistungsnachweisDto;
import com.example.leistungsnachweisservice.api.model.KundenvertragDto;
import com.example.leistungsnachweisservice.api.model.PartnervertragDto;
import com.example.leistungsnachweisservice.enitity.Dienstleistungsnachweis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DienstleistungsnachweisMapper {

    @Mapping(source = "partnervertrag", target = "partnervertrag")
    @Mapping(source = "kundenvertrag", target = "kundenvertrag")
    DienstleistungsnachweisDto toDto(Dienstleistungsnachweis dienstleistungsnachweis,
                                     PartnervertragDto partnervertrag,
                                     KundenvertragDto kundenvertrag);
}
