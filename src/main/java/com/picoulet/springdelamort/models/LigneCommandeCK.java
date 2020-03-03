package com.picoulet.springdelamort.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LigneCommandeCK implements Serializable {
    @Column(name = "commande_reference")
    private Long commandeReference;

    @Column(name = "article_reference")
    private Long articleReference;

    //------------------------------------------------------------------------

    /**
     * Constructeur
     */
    public LigneCommandeCK() {

    }

    /**
     * Constructeur
     * @param commandeReference Référence de la commande
     * @param articleReference Référence de l'article
     */
    public LigneCommandeCK(Long commandeReference, Long articleReference) {
        this.commandeReference = commandeReference;
        this.articleReference = articleReference;
    }

    //------------------------------------------------------------------------


    public Long getCommandeReference() {
        return commandeReference;
    }

    public void setCommandeReference(Long commandeReference) {
        this.commandeReference = commandeReference;
    }

    public Long getArticleReference() {
        return articleReference;
    }

    public void setArticleReference(Long articleReference) {
        this.articleReference = articleReference;
    }
}
