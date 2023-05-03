package com.accountant.project.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kg_materials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "measurement_unit")
    private String measurementUnit;
}
