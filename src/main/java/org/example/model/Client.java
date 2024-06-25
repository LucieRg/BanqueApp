package org.example.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Client {
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private List<CompteBancaire> comptes;

    private static int nbClient = 0;
    private final int id;
    private int compteCourantCount;
    private int compteEpargneCount;
    private int comptePayantCount;

    public Client(String nom, String prenom, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.id = ++nbClient;
        this.comptes = new ArrayList<>();
    }

    public void ajouterCompte(CompteBancaire compte) {
        comptes.add(compte);
        incrementerCompteCount(compte);
    }

    private void incrementerCompteCount(CompteBancaire compte) {
        if (compte instanceof CompteCourant) {
            compteCourantCount++;
        } else if (compte instanceof CompteEpargne) {
            compteEpargneCount++;
        } else if (compte instanceof ComptePayant) {
            comptePayantCount++;
        }
    }
}
