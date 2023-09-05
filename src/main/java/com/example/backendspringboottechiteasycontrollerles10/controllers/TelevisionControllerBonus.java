package com.example.backendspringboottechiteasycontrollerles10.controllers;

import com.example.backendspringboottechiteasycontrollerles10.exceptions.TelevisionNameTooLongException;
import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionControllerBonus {

    public List<String> televisionDatabase = new ArrayList<>();


    @GetMapping("/televisions")
    public ResponseEntity<List<String>> getAllTelevisions() {
      return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable("id") int id) {
        if (id >= 0 && id < televisionDatabase.size()) {
            String t = televisionDatabase.get(id);
            return ResponseEntity.ok(t);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/televisions")
    // waarom krijg ik een foutmelding bij null?
    public ResponseEntity<String> createTelevision(@RequestBody String television) {
        if (television.length() > 1000) {
            throw new TelevisionNameTooLongException("Televisie naam mag niet meer dan 1000 karakters zijn.");
        } else {
            televisionDatabase.add(television);
            return ResponseEntity.created(null).body(television);
        }
    }

    @PutMapping("/televisions/{id}")
    // waarom kan ik binnen deze de id niet index noemen?
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody String television) {
        televisionDatabase.set(id, television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/televisions/{index}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int index) {
        televisionDatabase.set(index, null);
        return ResponseEntity.noContent().build();
    }
}