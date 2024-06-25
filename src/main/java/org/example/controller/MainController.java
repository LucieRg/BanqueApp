package org.example.controller;

import org.example.model.*;
import org.example.view.ConsoleView;

public class MainController {
    private Client client;
    private ConsoleView view;

    public MainController(Client client, ConsoleView view) {
        this.client = client;
        this.view = view;
    }

    public void demarrerApplication() {
        int choix;
        do {
            view.afficherMenuPrincipal();
            choix = view.lireChoixUtilisateur();

            switch (choix) {
                case 1:
                    view.listerComptes(client);
                    break;
                case 2:
                    creerCompte();
                    break;
                case 3:
                    effectuerDepot();
                    break;
                case 4:
                    effectuerRetrait();
                    break;
                case 5:
                    afficherOperationsEtSolde();
                    break;
                case 6:
                    System.out.println("Merci d'avoir utilisé notre application !");
                    break;
                default:
                    view.afficherErreur("Choix invalide.");
            }
        } while (choix != 6);
    }

    private void creerCompte() {
        view.afficherMessage("=== Création de compte ===");
        view.afficherMessage("1. Créer un compte courant");
        view.afficherMessage("2. Créer un compte épargne");
        view.afficherMessage("3. Créer un compte payant");
        view.afficherMessage("0. Annuler la création");

        int choixCreation = view.lireChoixUtilisateur();
        double soldeInitial;
        CompteBancaire compte;

        switch (choixCreation) {
            case 1:
                soldeInitial = view.lireDepotInitial();
                compte = new CompteCourant(client, soldeInitial);
                client.ajouterCompte(compte);
                view.afficherMessage("Compte courant créé avec succès.");
                break;
            case 2:
                soldeInitial = view.lireDepotInitial();
                compte = new CompteEpargne(client, soldeInitial);
                client.ajouterCompte(compte);
                view.afficherMessage("Compte épargne créé avec succès.");
                break;
            case 3:
                soldeInitial = view.lireDepotInitial();
                compte = new ComptePayant(client, soldeInitial);
                client.ajouterCompte(compte);
                view.afficherMessage("Compte payant créé avec succès.");
                break;
            case 0:
                view.afficherMessage("Création de compte annulée.");
                break;
            default:
                view.afficherErreur("Choix invalide.");
        }
    }

    private void effectuerDepot() {
        CompteBancaire compte = choisirCompte("déposer de l'argent dans");
        if (compte != null) {
            double montant = view.lireMontantOperation("déposer");
            compte.deposer(montant);
            view.afficherMessage("Dépôt effectué avec succès.");
        }
    }

    private void effectuerRetrait() {
        CompteBancaire compte = choisirCompte("retirer de l'argent de");
        if (compte != null) {
            double montant = view.lireMontantOperation("retirer");
            try {
                if (compte.retirer(montant)) {
                    view.afficherMessage("Retrait effectué avec succès.");
                } else {
                    view.afficherErreur("Retrait impossible.");
                }
            } catch (SoldeInsuffisantException e) {
                view.afficherErreur(e.getMessage());
            }
        }
    }

    private void afficherOperationsEtSolde() {
        CompteBancaire compte = choisirCompte("afficher les opérations de");
        if (compte != null) {
            view.afficherOperationsEtSolde(compte);
        }
    }

    private CompteBancaire choisirCompte(String action) {
        CompteBancaire compte = view.selectionnerCompte(client);
        if (compte == null) {
            view.afficherErreur("Aucun compte sélectionné pour " + action + ".");
        }
        return compte;
    }
}
