package com.example.backendspringboottechiteasycontrollerles10.services;

import com.example.backendspringboottechiteasycontrollerles10.dto.TelevisionDto;
import com.example.backendspringboottechiteasycontrollerles10.dto.TelevisionInputDto;
import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import com.example.backendspringboottechiteasycontrollerles10.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisionList = televisionRepository.findAll();
        List<TelevisionDto> televisionDtoList = new ArrayList<>();

        for (Television television : televisionList) {
            TelevisionDto televisionDto = fromTelevision(television);
            televisionDtoList.add(televisionDto);
        }
        return televisionDtoList;
    }

    public TelevisionDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television television = toTelevision(televisionInputDto);
        televisionRepository.save(television);
        return fromTelevision(television);
    }

    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> televisionId = televisionRepository.findById(id);
        if (televisionId.isPresent()) {
            Television television = televisionId.get();
            return fromTelevision(television);
        } else {
            throw new RecordNotFoundException("Er is geen televisie gevonden met id: " + id);
        }
    }

    public void deleteTelevision(@RequestParam Long id) {

        televisionRepository.deleteById(id);
    }

    public TelevisionDto updateTelevision(@PathVariable Long id, @RequestBody TelevisionDto updateTelevision) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new RecordNotFoundException("Er is geen televisie met id nummer: " + id);
        } else {
            Television television1 = television.get();
            television1.setType(updateTelevision.getType());
            television1.setBrand(updateTelevision.getBrand());
            television1.setName(updateTelevision.getName());
            television1.setPrice(updateTelevision.getPrice());
            television1.setAvailableSize(updateTelevision.getAvailableSize());
            television1.setRefreshRate(updateTelevision.getRefreshRate());
            television1.setScreenType(updateTelevision.getScreenType());
            television1.setScreenQuality(updateTelevision.getScreenQuality());
            television1.setSmartTv(updateTelevision.getSmartTv());
            television1.setWifi(updateTelevision.getWifi());
            television1.setVoiceControl(updateTelevision.getVoiceControl());
            television1.setHdr(updateTelevision.getHdr());
            television1.setBluetooth(updateTelevision.getBluetooth());
            television1.setAmbiLight(updateTelevision.getAmbiLight());
            television1.setOriginalStock(updateTelevision.getOriginalStock());
            television1.setSold(updateTelevision.getSold());
            Television television2 = televisionRepository.save(television1);
            return fromTelevision(television2);
        }
    }

    // stap 13 t/m 16 - maar de functie werkte niet bij aanroepen wanneer deze zich in de TelevisionDto.java bevond dus heb hem hierheen verplaatst.
    public TelevisionDto fromTelevision(Television television) {
        var televisionDto = new TelevisionDto();
        televisionDto.id = television.getId();
        televisionDto.type = television.getType();
        televisionDto.brand = television.getBrand();
        televisionDto.name = television.getName();
        televisionDto.price = television.getPrice();
        televisionDto.availableSize = television.getAvailableSize();
        televisionDto.refreshRate = television.getRefreshRate();
        televisionDto.screenType = television.getScreenType();
        televisionDto.screenQuality = television.getScreenQuality();
        televisionDto.smartTv = television.getSmartTv();
        televisionDto.wifi = television.getWifi();
        televisionDto.voiceControl = television.getVoiceControl();
        televisionDto.hdr = television.getHdr();
        televisionDto.bluetooth = television.getBluetooth();
        televisionDto.ambiLight = television.getAmbiLight();
        televisionDto.originalStock = television.getOriginalStock();
        televisionDto.sold = television.getSold();
        return televisionDto;
    }

    // stap 19 t/m 21 - maar de functie werkte niet bij aanroepen wanneer deze zich in de TelevisionInputDto.java bevond dus heb hem hierheen verplaatst.
    public Television toTelevision(TelevisionInputDto televisionInputDto) {
        var television = new Television();
        television.setType(televisionInputDto.type);
        television.setBrand(televisionInputDto.brand);
        television.setName(televisionInputDto.name);
        television.setPrice(televisionInputDto.price);
        television.setAvailableSize(televisionInputDto.availableSize);
        television.setRefreshRate(televisionInputDto.refreshRate);
        television.setScreenType(televisionInputDto.screenType);
        television.setScreenQuality(televisionInputDto.screenQuality);
        television.setSmartTv(televisionInputDto.smartTv);
        television.setWifi(televisionInputDto.wifi);
        television.setVoiceControl(televisionInputDto.voiceControl);
        television.setHdr(televisionInputDto.hdr);
        television.setBluetooth(televisionInputDto.bluetooth);
        television.setAmbiLight(televisionInputDto.ambiLight);
        television.setOriginalStock(televisionInputDto.originalStock);
        television.setSold(televisionInputDto.sold);
        return television;
    }
}
