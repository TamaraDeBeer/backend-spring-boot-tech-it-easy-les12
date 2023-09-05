//package com.example.backendspringboottechiteasycontrollerles10.controllers;
//
//import com.example.backendspringboottechiteasycontrollerles10.exceptions.RecordNotFoundException;
//import com.example.backendspringboottechiteasycontrollerles10.exceptions.TelevisionNameTooLongException;
//import com.example.backendspringboottechiteasycontrollerles10.models.Television;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class TelevisionController {
//    private final List<Television> televisions;
//    public TelevisionController() {
//        televisions = new ArrayList<>();
//        Television t = new Television();
//        t.setName("Crystal");
//        t.setBrand("Samsung");
//        t.setPrice(549);
//        t.setType("UHD 55AU7040");
//        televisions.add(t);
//    }
//
//    @GetMapping("/televisions")
//    public ResponseEntity<List<Television>> getAllTelevisions() {
//        return new ResponseEntity<>(televisions, HttpStatus.OK);
////      return ResponseEntity.ok(televisions);
//    }
//
//    @GetMapping("/televisions/{id}")
//    public ResponseEntity<Object> getTelevision(@PathVariable("id") int id) {
//        if (id >= 0 && id < televisions.size()) {
//            Television t = televisions.get(id);
//            return ResponseEntity.ok(t);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/televisions")
//    public ResponseEntity<Television> createTelevision(@RequestBody Television newTelevision) {
//        televisions.add(newTelevision);
//        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/televisions/{id}")
//    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody String television) {
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/televisions/{index}")
//    public ResponseEntity<Television> deleteTelevision(@PathVariable int index) {
//        return ResponseEntity.noContent().build();
//    }
//}