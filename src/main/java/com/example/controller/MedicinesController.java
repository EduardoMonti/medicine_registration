package com.example.controller;

import com.example.entities.Medicines;
import com.example.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
