package com.accountant.project.model.type;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "type_books")
@NoArgsConstructor
@AllArgsConstructor
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "value")
    private String value;
    @Column(name = "description")
    private String description;
}
