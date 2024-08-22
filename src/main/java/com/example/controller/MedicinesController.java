package com.example.controller;

import com.example.entities.Medicines;
import com.example.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medicines")
public class MedicinesController {

    @Autowired
    MedicinesRepository medicinesRepository;

    @GetMapping
    public List<Medicines> findAll(){
        List<Medicines> medicines = medicinesRepository.findAll();
        return medicines;
    }

    @GetMapping(value = "/{id}")
    public Medicines findById(@PathVariable Long id){
        Medicines medicines = medicinesRepository.findById(id).get();
        return  medicines;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Medicines> deleteById(@PathVariable Long id){
        Optional<Medicines> medicinesOptional = medicinesRepository.findById(id);

        if (medicinesOptional.isPresent()) {
            Medicines medicines = medicinesOptional.get();
            medicinesRepository.deleteById(id);
            return ResponseEntity.ok(medicines);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
