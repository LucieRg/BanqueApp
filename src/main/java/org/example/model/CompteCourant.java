package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
public class CompteCourant extends CompteBancaire {
    public CompteCourant(Client client, double solde) {
        super(client, solde);
    }
}
