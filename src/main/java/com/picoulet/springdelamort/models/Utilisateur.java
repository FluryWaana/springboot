package com.picoulet.springdelamort.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id", updatable = false, nullable = false)
    private Long utilisateurId;

    @Column(name = "utilisateur_email", unique = true, length = 180)
    private String utilisateurEmail;

    @Column(name = "utilisateur_password", columnDefinition = "TEXT")
    private String utilisateurPassword;

    @Column(name = "utilisateur_nom", length = 60, nullable = false)
    private String utilisateurNom;

    @Column(name = "utilisateur_prenom", length = 60, nullable = false)
    private String utilisateurPrenom;

    @Column(name = "utilisateur_created_at")
    @CreatedDate
    private Date utilisateurCreatedAt;

    @Column(name = "utilisateur_updated_at")
    @LastModifiedDate
    private Date utilisateurUpdatedAt;

    @ManyToOne
    @JoinColumn(name = "role_nom")
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade=CascadeType.REMOVE)
    private List<Commande> commandes;

    // ------------------------------------------------------------------------

    public Utilisateur() {}

    public Utilisateur(String utilisateurNom, String utilisateurPrenom) {
        this.utilisateurNom = utilisateurNom;
        this.utilisateurPrenom = utilisateurPrenom;
    }

    public Utilisateur(String utilisateurNom, String utilisateurPrenom, Role role) {
        this.utilisateurNom = utilisateurNom;
        this.utilisateurPrenom = utilisateurPrenom;
        this.role = role;
    }

    public Utilisateur(String utilisateurEmail, String utilisateurPassword, String utilisateurNom,
                       String utilisateurPrenom, Date utilisateurCreatedAt, Date utilisateurUpdatedAt) {
        this.utilisateurEmail = utilisateurEmail;
        this.utilisateurPassword = utilisateurPassword;
        this.utilisateurNom = utilisateurNom;
        this.utilisateurPrenom = utilisateurPrenom;
        this.utilisateurCreatedAt = utilisateurCreatedAt;
        this.utilisateurUpdatedAt = utilisateurUpdatedAt;
    }

    // ------------------------------------------------------------------------

    /**
     * @return the utilisateurId
     */
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    /**
     * @return the utilisateurEmail
     */
    public String getUtilisateurEmail() {
        return utilisateurEmail;
    }

    /**
     * @param utilisateurEmail the utilisateurEmail to set
     */
    public void setUtilisateurEmail(String utilisateurEmail) {
        this.utilisateurEmail = utilisateurEmail;
    }

    /**
     * @return the utilisateurPassword
     */
    @JsonIgnore
    public String getUtilisateurPassword() {
        return utilisateurPassword;
    }

    /**
     * @param utilisateurPassword the utilisateurPassword to set
     */
    @JsonProperty
    public void setUtilisateurPassword(String utilisateurPassword) {
        this.utilisateurPassword = utilisateurPassword;
    }

    /**
     * @return the utilisateurNom
     */
    public String getUtilisateurNom() {
        return utilisateurNom;
    }

    /**
     * @param utilisateurNom the utilisateurNom to set
     */
    public void setUtilisateurNom(String utilisateurNom) {
        this.utilisateurNom = utilisateurNom.toLowerCase();
    }

    /**
     * @return the utilisateurPrenom
     */
    public String getUtilisateurPrenom() {
        return utilisateurPrenom;
    }

    /**
     * @param utilisateurPrenom the utilisateurPrenom to set
     */
    public void setUtilisateurPrenom(String utilisateurPrenom) {
        this.utilisateurPrenom = utilisateurPrenom.toLowerCase();
    }

    /**
     * @return the utilisateurCreatedAt
     */
    public Date getUtilisateurCreatedAt() {
        return utilisateurCreatedAt;
    }

    /**
     * @param utilisateurCreatedAt the utilisateurCreatedAt to set
     */
    public void setUtilisateurCreatedAt(Date utilisateurCreatedAt) {
        this.utilisateurCreatedAt = utilisateurCreatedAt;
    }

    /**
     * @return the utilisateurUpdatedAt
     */
    public Date getUtilisateurUpdatedAt() {
        return utilisateurUpdatedAt;
    }

    /**
     * @param utilisateurUpdatedAt the utilisateurUpdatedAt to set
     */
    public void setUtilisateurUpdatedAt(Date utilisateurUpdatedAt) {
        this.utilisateurUpdatedAt = utilisateurUpdatedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Utilisateur{" +
                "utilisateurId=" + utilisateurId +
                ", utilisateurEmail='" + utilisateurEmail + '\'' +
                ", utilisateurPassword='" + utilisateurPassword + '\'' +
                ", utilisateurNom='" + utilisateurNom + '\'' +
                ", utilisateurPrenom='" + utilisateurPrenom + '\'' +
                ", utilisateurCreatedAt=" + utilisateurCreatedAt +
                ", utilisateurUpdatedAt=" + utilisateurUpdatedAt +
                ", role=" + role +
                '}';
    }

    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(utilisateurId, that.utilisateurId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId);
    }
}
