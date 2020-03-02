package com.picoulet.springdelamort.models;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_reference", updatable = false, nullable = false)
    private Long articleReference;

    @Column(name = "article_description", columnDefinition = "TEXT")
    private String articleDescription;

    @Column(name = "article_prix")
    private Double articlePrix;
}
