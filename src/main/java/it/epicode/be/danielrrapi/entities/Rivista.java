package it.epicode.be.danielrrapi.entities;

import it.epicode.be.danielrrapi.abstracts.OperaEditoriale;
import it.epicode.be.danielrrapi.enums.RivistaPeriodicitaTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends OperaEditoriale {
    @Enumerated(EnumType.STRING)
    private RivistaPeriodicitaTypes periodicita;

    public Rivista() {
    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, RivistaPeriodicitaTypes periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public RivistaPeriodicitaTypes getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(RivistaPeriodicitaTypes periodicita) {
        this.periodicita = periodicita;
    }
}
