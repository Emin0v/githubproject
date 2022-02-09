package com.company.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long githubIssueId;

    private Integer githubIssueNumber;

    private String title;

    @Column(columnDefinition = "text")
    private String body;

    private String url;

    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    private Repository repository;

}
