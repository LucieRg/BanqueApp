# Application Bancaire

Cette application bancaire permet de gérer les comptes bancaires d'un client. Elle permet de créer différents types de comptes, de réaliser des dépôts et des retraits, et d'afficher les opérations et les soldes des comptes.

## Structure du Projet

Le projet est organisé en plusieurs packages :

- `org.example.model` : contient les classes de modèle représentant les entités de l'application (Client, CompteBancaire, CompteCourant, CompteEpargne, ComptePayant, Operations).
- `org.example.view` : contient la classe ConsoleView qui gère l'interface utilisateur via la console.
- `org.example.controller` : contient la classe MainController qui orchestre les interactions entre la vue et le modèle.

## Fonctionnalités

- Lister les comptes bancaires d'un client.
- Créer un compte (compte courant, compte épargne, compte payant).
- Effectuer un dépôt sur un compte.
- Effectuer un retrait d'un compte.
- Afficher les opérations et le solde d'un compte.

## Prérequis

- Java 8 ou version supérieure.
- Maven (facultatif, pour gérer les dépendances).

## Exemple

### Lister les comptes

=== Menu Principal ===
1. Lister les comptes bancaires
2. Créer un compte
3. Effectuer un dépôt
4. Effectuer un retrait
5. Afficher opérations et le solde
6. Quitter

   
Choix: 1


- Comptes du client Doe John:
- Nombre de comptes courants: 1
- Nombre de comptes épargnes: 0
- Nombre de comptes payants: 1

### Créer un compte

=== Menu Principal ===
1. Lister les comptes bancaires
2. Créer un compte
3. Effectuer un dépôt
4. Effectuer un retrait
5. Afficher opérations et le solde
6. Quitter

   
Choix: 2


=== Création de compte ===
1. Créer un compte courant
2. Créer un compte épargne
3. Créer un compte payant
0. Annuler la création

   
Choix: 1
- Dépôt initial: 500
- Compte courant créé avec succès.


### Effectuer un dépôt 

=== Menu Principal ===
1. Lister les comptes bancaires
2. Créer un compte
3. Effectuer un dépôt
4. Effectuer un retrait
5. Afficher opérations et le solde
6. Quitter

   
Choix: 3


- Sélectionner un compte :
1. CompteCourant
2. ComptePayant

   
Choix: 1

  
- Montant à déposer: 200
- Dépôt effectué avec succès.


### Effectuer un retrait 

=== Menu Principal ===
1. Lister les comptes bancaires
2. Créer un compte
3. Effectuer un dépôt
4. Effectuer un retrait
5. Afficher opérations et le solde
6. Quitter

   
Choix: 4


- Sélectionner un compte :
1. CompteCourant
2. ComptePayant

   
Choix: 1


- Montant à retirer: 100
- Retrait effectué avec succès.

### Afficher opérations et soldes 

=== Menu Principal ===
1. Lister les comptes bancaires
2. Créer un compte
3. Effectuer un dépôt
4. Effectuer un retrait
5. Afficher opérations et le solde
6. Quitter

   
Choix: 5


- Sélectionner un compte :
1. CompteCourant
2. ComptePayant

   
Choix: 1


- Solde du compte: 600
Opérations:
- Dépot de 500.0
- Dépot de 200.0
- Retrait de 100.0



