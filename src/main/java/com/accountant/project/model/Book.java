package com.accountant.project.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "page")
    private Long page;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "price")
    private BigDecimal price;
}
