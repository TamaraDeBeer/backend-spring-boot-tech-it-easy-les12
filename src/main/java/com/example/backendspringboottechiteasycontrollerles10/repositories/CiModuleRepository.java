package com.example.backendspringboottechiteasycontrollerles10.repositories;

import com.example.backendspringboottechiteasycontrollerles10.models.CiModule;
import com.example.backendspringboottechiteasycontrollerles10.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiModuleRepository extends JpaRepository<CiModule, Long> {
}
