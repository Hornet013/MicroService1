package fr.microservice.ex2bdd;

import fr.microservice.ex2bdd.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
