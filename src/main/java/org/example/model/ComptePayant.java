package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
public class ComptePayant extends CompteBancaire {
    public ComptePayant(Client client, double solde) {
        super(client, solde);
    }
}
