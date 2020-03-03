package com.picoulet.springdelamort.models;

import com.github.slugify.Slugify;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Transient
    private Slugify slugify;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", updatable = false, nullable = false)
    private Long roleId;

    @Column(name = "role_nom", length = 60, nullable = false)
    @NotNull
    @Size(min=2, max=60, message = "Le nombre de caractères du nom du role doit être compris entre {min} et {max}")
    private String roleNom;

    @Column(name = "role_slug", nullable = false)
    private String roleSlug;

    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateurs;

    //------------------------------------------------------------------------

    /**
     * Constructeur par défaut
     */
    public Role() {
        this.slugify = new Slugify();
    }

    /**
     * Constructeur
     * @param roleNom Nom du rôle
     *
     */
    public Role(String roleNom) {
        this.slugify = new Slugify();
        this.roleNom = roleNom;
        this.roleSlug = slugify.slugify(roleNom);
    }

    //------------------------------------------------------------------------

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleNom() {
        return roleNom;
    }

    public void setRoleNom(String roleNom) {
        this.roleNom = roleNom.toLowerCase();
        this.roleSlug = slugify.slugify(roleNom.toLowerCase());
    }

    public String getRoleSlug() {
        return roleSlug;
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
