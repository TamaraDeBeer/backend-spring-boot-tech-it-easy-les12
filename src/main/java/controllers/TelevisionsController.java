package controllers;

import models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionsController {
    private final List<Television> televisions;

    public TelevisionsController() {
        televisions = new ArrayList<>();
        Television t = new Television();
        t.setName("Crystal");
        t.setBrand("Samsung");
        t.setPrice(549);
        t.setType("UHD 55AU7040");
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @GetMapping("/television/{index}")
    public ResponseEntity<Television> getTelevision(@PathVariable int index) {
        if (index >= 0 && index < televisions.size()) {
            Television t = televisions.get(index);
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/televisions")
    public ResponseEntity<Television> createTelevision(@RequestBody Television newTelevision) {
        televisions.add(newTelevision);
        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @PutMapping("/televisions/{index}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int index) {
        if (index >= 0 && index < televisions.size()) {
            Television t = televisions.get(index);
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/televisions/{index}")
    public ResponseEntity<Television> partialUpdateTelevision(@PathVariable int index) {
        if (index >= 0 && index < televisions.size()) {
            Television t = televisions.get(index);
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/televisions/{index}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int index) {
        if (index >= 0 && index < televisions.size()) {
            Television t = televisions.get(index);
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
