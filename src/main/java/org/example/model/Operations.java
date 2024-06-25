package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Operations {
    private static int nbOfOperations = 0;
    private final int id;
    private double montant;
    private StatutOperations statut;

    public Operations(double montant, StatutOperations statut) {
        this.id = ++nbOfOperations;
        this.montant = montant;
        this.statut = statut;
    }
}
