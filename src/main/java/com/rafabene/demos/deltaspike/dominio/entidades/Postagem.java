package com.rafabene.demos.deltaspike.dominio.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Postagem extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 100)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date datetime;

    @Override
    public Long getId() {
        return id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Date getDatetime() {
        return datetime;
    }
    
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

}
