package fr.microservice.ex2bdd.exception;

public class ProduitAlreadyExistsException extends RuntimeException{
    public ProduitAlreadyExistsException(final String message) {
        super(message);
    }
}
