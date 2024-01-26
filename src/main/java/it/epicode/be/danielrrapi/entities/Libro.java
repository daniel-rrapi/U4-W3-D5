package it.epicode.be.danielrrapi.entities;

import it.epicode.be.danielrrapi.abstracts.OperaEditoriale;
import it.epicode.be.danielrrapi.enums.LibroGenereTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Libro extends OperaEditoriale {
    private String autore;
    @Enumerated(EnumType.STRING)
    private LibroGenereTypes genere;

    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, LibroGenereTypes genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public LibroGenereTypes getGenere() {
        return genere;
    }

    public void setGenere(LibroGenereTypes genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
