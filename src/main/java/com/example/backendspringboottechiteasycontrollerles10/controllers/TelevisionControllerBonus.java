package com.example.backendspringboottechiteasycontrollerles10.controllers;

import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import com.example.backendspringboottechiteasycontrollerles10.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionControllerBonus {

    private final TelevisionRepository televisionRepository;

    public TelevisionControllerBonus(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable("id") Long id) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new RecordNotFoundException("Er is geen televisie met dit id nummer: " + id);
        } else {
            Television television1 = television.get();
            return ResponseEntity.ok(television1);
        }
    }

    @PostMapping("/televisions")
    // waarom krijg ik een foutmelding bij null?
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        televisionRepository.save(television);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + television.getId()).toUriString());
        return  ResponseEntity.created(uri).body(television);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television updateTelevision) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new RecordNotFoundException("Er is geen televisie met dit id nummer: " + id);
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
            return ResponseEntity.ok(television2);
        }
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable("id") Long id) {
        televisionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}