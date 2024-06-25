package org.example.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class CompteBancaire {
    protected double solde;
    protected Client client;
    protected List<Operations> operations;

    public CompteBancaire(Client client, double solde) {
        this.client = client;
        this.solde = solde;
        this.operations = new ArrayList<>();
    }

    public void deposer(double montant) {
        solde += montant;
        effectuerOperation(montant, StatutOperations.DEPOT);
    }

    public boolean retirer(double montant) throws SoldeInsuffisantException {
        if (solde >= montant) {
            effectuerOperation(montant, StatutOperations.RETRAIT);
            return true;
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour effectuer le retrait.");
        }
    }

    public List<Operations> getOperations() {
        return new ArrayList<>(operations);
    }

    protected void effectuerOperation(double montant, StatutOperations statut) {
        solde += (statut == StatutOperations.DEPOT ? montant : -montant);
        operations.add(new Operations(montant, statut));
    }
}
