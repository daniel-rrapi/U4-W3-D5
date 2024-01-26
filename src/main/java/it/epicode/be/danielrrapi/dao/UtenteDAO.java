package it.epicode.be.danielrrapi.dao;

import it.epicode.be.danielrrapi.entities.Utente;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " aggiunto al DB");
    }
}
