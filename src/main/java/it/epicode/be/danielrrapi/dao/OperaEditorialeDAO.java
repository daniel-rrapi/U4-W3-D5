package it.epicode.be.danielrrapi.dao;

import it.epicode.be.danielrrapi.abstracts.OperaEditoriale;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class OperaEditorialeDAO {
    private final EntityManager em;

    public OperaEditorialeDAO(EntityManager em) {
        this.em = em;
    }
    public void save(OperaEditoriale opera) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(opera);
        transaction.commit();
        System.out.println("Opera editoriale " + opera.getTitolo() + " aggiunta al DB");
    }
}
