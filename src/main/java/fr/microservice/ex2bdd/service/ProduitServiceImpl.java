package fr.microservice.ex2bdd.service;

import fr.microservice.ex2bdd.ProduitRepository;
import fr.microservice.ex2bdd.domain.Produit;
import fr.microservice.ex2bdd.exception.ProduitAlreadyExistsException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class ProduitServiceImpl implements ProduitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProduitServiceImpl.class);
    private final ProduitRepository repository;

    @Autowired
    public ProduitServiceImpl(final ProduitRepository repository) {

        this.repository = repository;
    }

    @Override
    @Transactional
    public Produit saveProduit(@NotNull @Valid Produit produit) {
        LOGGER.debug("Creaion {}", produit);
        if (repository.findById(produit.getId()).isPresent())
        {
            throw new ProduitAlreadyExistsException(
                    String.format("Il existe déjà un produit avec id=%s",produit.getId()));
        }
        return repository.save(produit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produit> getList() {
        LOGGER.debug("Liste de tous les produits");
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Produit getProduit(Long produitId) {
        LOGGER.debug("Affiche le produit id=%s",produitId);
        if (!repository.findById(produitId).isPresent())
        {
            throw new ProduitAlreadyExistsException(
                    String.format("Il n'existe pas de produit avec id=%s",produitId));
        }
        return repository.findById(produitId).get();
    }

    @Override
    public void deleteProduit(Long produitId) {
        LOGGER.debug("Suppression du produit id=%s",produitId);
        repository.deleteById(produitId);
    }
}
