package fr.microservice.ex2bdd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CREATE TABLE panier (
 *    id INT NOT NULL,
 *    produit VARCHAR(50) NOT NULL,
 *    quantite INT NOT NULL,
 *    PRIMARY KEY (id)
 * );
 *
 * insert into panier value (produit,quantite) ("Tomates", 10);
 */

@Entity
public class Produit {

    @Id
    @NotNull
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "produit", nullable = false)
    private String produit;

    @NotNull
    @Column(name = "quantite", nullable = false)
    private Long quantite;

    public Produit() {
    }

    public Produit(@NotNull Long id, @NotNull @Size(max = 20) String produit, @NotNull Long quantite) {
        this.id = id;
        this.produit = produit;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", produit = '" + produit + '\'' +
                ", quantite = '" + quantite + '\'' +
                '}';
    }
}
