package com.company.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Repository.REPOSITORY_NAME )
public class Repository{
    public static final String REPOSITORY_NAME= "repository";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String organization;

    private String repository;


}
