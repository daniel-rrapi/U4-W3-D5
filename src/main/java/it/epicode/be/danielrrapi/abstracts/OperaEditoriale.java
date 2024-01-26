package it.epicode.be.danielrrapi.abstracts;

import it.epicode.be.danielrrapi.entities.Prestito;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "opere_editoriali")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class OperaEditoriale {
    @Id
    @GeneratedValue()
    private long isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    @OneToOne(mappedBy = "elementoPrestato")
    private Prestito prestito;

    public OperaEditoriale() {
    }

    public OperaEditoriale(String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "OperaEditoriale{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
