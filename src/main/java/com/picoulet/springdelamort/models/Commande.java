package com.picoulet.springdelamort.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_reference", updatable = false, nullable = false)
    private Long commandeReference;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>();

    //------------------------------------------------------------------------

    /**
     * Constructeur
     */
    public Commande() {

    }

    /**
     * Constructeur
     *
     * @param utilisateur Utilisateur
     */
    public Commande(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    //------------------------------------------------------------------------

    public Long getCommandeReference() {
        return commandeReference;
    }

    public void setCommandeReference(Long commandeReference) {
        this.commandeReference = commandeReference;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        return "Commande{" +
                "commandeReference=" + commandeReference +
                ", utilisateur=" + utilisateur +
                '}';
    }

    //------------------------------------------------------------------------

    /**
     * Calcul le prix total d'une commande
     *
     * @return Retourne le montant total de la commandes
     */
    public Double getPrixTotal() {
        double total = 0.0;
        for (LigneCommande lc : ligneCommandes) {
            total += lc.getQuantiteArticle() * lc.getArticle().getArticlePrix();
        }
        return total;
    }
}
