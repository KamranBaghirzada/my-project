package com.accountant.project.repository;

import com.accountant.project.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Material findByMaterialName(String materialName);
}
