package com.rafabene.demos.deltaspike.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class Usuario extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private char[] password;

    private String role = "guest";

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(name = "usuario_segue_outrosusuarios",
        joinColumns = { @JoinColumn(name = "usuario_id") },
        inverseJoinColumns = { @JoinColumn(name = "seguido_id") })
    private List<Usuario> seguidos = new ArrayList<Usuario>();

    @Override
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public List<Usuario> getSeguidos() {
        return seguidos;
    }

}
