package com.example.repository;

import com.example.entities.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinesRepository extends JpaRepository<Medicines, Long> {

}
