package com.picoulet.springdelamort.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_reference", updatable = false, nullable = false)
    private Long articleReference;

    @Column(name = "article_nom", length = 120)
    private String articleNom;

    @Column(name = "article_description", columnDefinition = "TEXT")
    private String articleDescription;

    @Column(name = "article_prix")
    private Double articlePrix;

    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>();

    //------------------------------------------------------------------------

    /**
     * Constructeur
     */
    public Article() {

    }

    /**
     * Constructeur
     * @param articleNom Nom de l'article
     * @param articleDescription Description de l'article
     * @param articlePrix Prix de l'article
     */
    public Article(String articleNom, String articleDescription, Double articlePrix) {
        this.articleNom = articleNom;
        this.articleDescription = articleDescription;
        this.articlePrix = articlePrix;
    }

    //------------------------------------------------------------------------

    public Long getArticleReference() {
        return articleReference;
    }

    public void setArticleReference(Long articleReference) {
        this.articleReference = articleReference;
    }

    public String getArticleNom() {
        return articleNom;
    }

    public void setArticleNom(String articleNom) {
        this.articleNom = articleNom;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public Double getArticlePrix() {
        return articlePrix;
    }

    public void setArticlePrix(Double articlePrix) {
        this.articlePrix = articlePrix;
    }

    public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

//------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Article{" +
                "articleReference=" + articleReference +
                ", articleDescription='" + articleDescription + '\'' +
                ", articlePrix=" + articlePrix +
                '}';
    }
}
