package it.epicode.be.danielrrapi.dao;

import it.epicode.be.danielrrapi.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito con id " + prestito.getId() + " aggiunto al DB");
    }
}
