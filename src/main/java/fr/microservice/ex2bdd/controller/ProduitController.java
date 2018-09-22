package fr.microservice.ex2bdd.controller;

import fr.microservice.ex2bdd.domain.Produit;
import fr.microservice.ex2bdd.exception.ProduitAlreadyExistsException;
import fr.microservice.ex2bdd.service.ProduitService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProduitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProduitController.class);
    private final ProduitService produitService;

    @Autowired
    public ProduitController(final ProduitService produitService)
    {
        this.produitService = produitService;
    }

    @ApiOperation(value = "Liste tous les produits", responseContainer = "List")
    @RequestMapping(value = "/produits", method = RequestMethod.GET, produces = {"application/json"})
    public List<Produit> listProduit() {
        LOGGER.debug("Récupération de tous les produits");
        return produitService.getList();
    }

    @RequestMapping(value = "/produits", method = RequestMethod.POST, consumes = {"application/json"})
    public Produit saveProduit(@RequestBody @Valid final Produit produit)
    {
        LOGGER.debug("Création du produit {}", produit);
        return produitService.saveProduit(produit);
    }

    @RequestMapping(value = "/produits/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Produit singleProduit(@PathVariable Long id) {
        LOGGER.debug("Demande de liste un produit spécifique");
        return produitService.getProduit(id);
    }

    @RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable Long id) {
        LOGGER.debug("Suppresion d'un produit");
        produitService.deleteProduit(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(ProduitAlreadyExistsException e)
    {
        return e.getMessage();
    }
}
