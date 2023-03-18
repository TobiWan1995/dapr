package com.example.zeiterfassungservice.service;

import com.example.zeiterfassungservice.enitity.Taetigkeit;
import com.example.zeiterfassungservice.repository.TaetigkeitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service("projektService")
@RequiredArgsConstructor
public class TaetigkeitServiceImpl implements TaetigkeitService {

    private final TaetigkeitRepository taetigkeitRepository;


    @Override
    public Taetigkeit saveTaetigkeit(Taetigkeit taetigkeit) {
        return taetigkeitRepository.save(taetigkeit);
    }

    @Override
    public Taetigkeit updateTaetigkeit(Taetigkeit taetigkeit) {
        if (!taetigkeitRepository.existsById(taetigkeit.getId()))
            taetigkeitNotExistingForId(taetigkeit.getId());
        return taetigkeitRepository.save(taetigkeit);
    }

    @Override
    public void deleteTaetigkeitById(Long id) {
        if (!taetigkeitRepository.existsById(id))
            taetigkeitNotExistingForId(id);
        taetigkeitRepository.deleteById(id);
    }

    @Override
    public List<Taetigkeit> retrieveTaetigkeitenForMitarbeiter(Long mitarbeiterId) {
        return taetigkeitRepository.findAllByMitarbeiter(mitarbeiterId);
    }

    @Override
    public List<Taetigkeit> retrieveTaetigkeitenForMitarbeiterInMonat(Long mitarbeiterId, LocalDate monat) {
        LocalDate startDate = LocalDate.of(monat.getYear(), monat.getMonth(), 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.MAX);
        return taetigkeitRepository.findAllByMitarbeiterAndBeginnBetween(
                mitarbeiterId,
                startDateTime,
                endDateTime
        );
    }

    private void taetigkeitNotExistingForId(Long id) {
        throw new RuntimeException(String.format("Tätigkeit with Id %d does not exists!", id));
    }
}
