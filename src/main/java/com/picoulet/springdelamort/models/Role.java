package com.picoulet.springdelamort.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_nom", length = 60, nullable = false)
    private String roleNom;

    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateurs;

    //------------------------------------------------------------------------

    /**
     * Constructeur par défaut
     */
    public Role() {}

    /**
     * Constructeur
     * @param roleNom Nom du rôle
     */
    public Role(String roleNom) {
        this.roleNom = roleNom;
    }

    //------------------------------------------------------------------------

    public String getRoleNom() {
        return roleNom;
    }

    public void setRoleNom(String roleNom) {
        this.roleNom = roleNom.toLowerCase();
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    //------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Role{" +
                "roleNom='" + roleNom + '\'' +
                '}';
    }
}
