package fr.microservice.ex2bdd.service;

import fr.microservice.ex2bdd.domain.Produit;
import fr.microservice.ex2bdd.exception.ProduitAlreadyExistsException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProduitService {
    Produit saveProduit (@NotNull @Valid final Produit produit);
    List<Produit> getList();
    Produit getProduit(Long produitId);
    void deleteProduit(final Long produitId);
}
