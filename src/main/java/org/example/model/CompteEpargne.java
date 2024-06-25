package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
public class CompteEpargne extends CompteBancaire {
    public CompteEpargne(Client client, double solde) {
        super(client, solde);
    }
}
