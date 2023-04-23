package com.accountant.project.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "pin")
    private String pin;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "last_day_apply")
    private LocalDate lastDayApply;

    @Column(name = "is_student")
    private Boolean isStudent;
}
