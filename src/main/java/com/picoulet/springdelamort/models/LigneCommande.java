package com.picoulet.springdelamort.models;

import javax.persistence.*;

@Entity
@Table(name = " ligne_commande")
public class LigneCommande {
    @EmbeddedId
    private LigneCommandeCK ligneCommandeCK;

    @Column(name = "quantite_article")
    private long quantiteArticle;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @MapsId("commande_reference")
    @JoinColumn(name = "commande_reference")
    private Commande commande;

    @ManyToOne
    @MapsId("article_reference")
    @JoinColumn(name = "article_reference")
    private Article article;

    //------------------------------------------------------------------------

    /**
     * Constructeur
     */
    public LigneCommande() {

    }

    /**
     * Constructeur
     * @param ligneCommandeCK Clé composé (article_reference avec commande_reference)
     * @param quantiteArticle Nombre d'article
     */
    public LigneCommande(LigneCommandeCK ligneCommandeCK, long quantiteArticle) {
        this.ligneCommandeCK = ligneCommandeCK;
        this.quantiteArticle = quantiteArticle;
    }

    //------------------------------------------------------------------------


    public LigneCommandeCK getLigneCommandeCK() {
        return ligneCommandeCK;
    }

    public void setLigneCommandeCK(LigneCommandeCK ligneCommandeCK) {
        this.ligneCommandeCK = ligneCommandeCK;
    }

    public long getQuantiteArticle() {
        return quantiteArticle;
    }

    public void setQuantiteArticle(long quantiteArticle) {
        this.quantiteArticle = quantiteArticle;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
