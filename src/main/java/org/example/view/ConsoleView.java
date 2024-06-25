package org.example.view;

import org.example.controller.MainController;
import org.example.model.Client;
import org.example.model.CompteBancaire;
import org.example.model.Operations;
import org.example.model.SoldeInsuffisantException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Lister les comptes bancaires");
        System.out.println("2. Créer un compte");
        System.out.println("3. Effectuer un dépôt");
        System.out.println("4. Effectuer un retrait");
        System.out.println("5. Afficher opérations et le solde");
        System.out.println("6. Quitter");
    }

    public int lireChoixUtilisateur() {
        System.out.print("Choix: ");
        return scanner.nextInt();
    }

    public void listerComptes(Client client) {
        System.out.println("Comptes du client " + client.getNom() + " " + client.getPrenom() + ":");
        System.out.println("Nombre de comptes courants: " + client.getCompteCourantCount());
        System.out.println("Nombre de comptes épargnes: " + client.getCompteEpargneCount());
        System.out.println("Nombre de comptes payants: " + client.getComptePayantCount());
    }

    public CompteBancaire selectionnerCompte(Client client) {
        List<CompteBancaire> comptes = client.getComptes();
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte disponible.");
            return null;
        }

        System.out.println("Sélectionner un compte :");
        for (int i = 0; i < comptes.size(); i++) {
            CompteBancaire compte = comptes.get(i);
            System.out.println((i + 1) + ". " + compte.getClass().getSimpleName());
        }

        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix < 1 || choix > comptes.size()) {
            System.out.println("Choix invalide.");
            return null;
        }

        return comptes.get(choix - 1);
    }

    public void afficherOperationsEtSolde(CompteBancaire compte) {
        if (compte == null) {
            System.out.println("Aucun compte sélectionné.");
            return;
        }

        System.out.println("Solde du compte: " + compte.getSolde());
        List<Operations> operations = compte.getOperations();

        if (operations.isEmpty()) {
            System.out.println("Aucune opération effectuée sur ce compte.");
        } else {
            System.out.println("Opérations:");
            for (Operations operation : operations) {
                System.out.println(operation.getStatut() + " de " + operation.getMontant());
            }
        }
    }

    public double lireDepotInitial() {
        System.out.print("Dépôt initial: ");
        return scanner.nextDouble();
    }

    public double lireMontantOperation(String operation) {
        System.out.print("Montant à " + operation + ": ");
        return scanner.nextDouble();
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public void afficherErreur(String message) {
        System.err.println("Erreur: " + message);
    }
}
