package it.epicode.be.danielrrapi.dao;

import it.epicode.be.danielrrapi.abstracts.OperaEditoriale;
import it.epicode.be.danielrrapi.entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
    public OperaEditoriale findById(long id) {
        return em.find(OperaEditoriale.class, id);
    }
    public void deleteByIsbn(long isbn) {

        OperaEditoriale found = this.findById(isbn);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("OperaEditoriale" + found.getTitolo() + " eliminata!")
        } else {
            System.out.println("OperaEditoriale con id " + isbn + " non trovata!")
        }

    }
    public List<OperaEditoriale> findByAnnoPubblicazione(int anno) { // vuole un oggetto (?)
        TypedQuery<OperaEditoriale> getOpereByYear = em.createQuery("SELECT o FROM OperaEditoriale o WHERE o.annopubblicazione = :anno");
        getOpereByYear.setParameter("anno", anno); // vuole un oggetto (?)
        return getOpereByYear.getResultList();
    }
    public List<OperaEditoriale> findByAutore(String autore) {
        TypedQuery<OperaEditoriale> getOpereByAuthor = em.createQuery("SELECT o FROM OperaEditoriale o WHERE o.autore = :autore");
        getOpereByAuthor.setParameter("autore", autore);
        return getOpereByAuthor.getResultList();
    }
    public List<OperaEditoriale> findByTitle(String titolo) {
        TypedQuery<OperaEditoriale> getOpereBtTitle = em.createQuery("SELECT o FROM OperaEditoriale o WHERE LOWER(o.titolo) LIKE LOWER(CONCAT(:titolo, '%'))");
        getOpereBtTitle.setParameter("titolo", titolo);
        return getOpereBtTitle.getResultList();
    }
}
