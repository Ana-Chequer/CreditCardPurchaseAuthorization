package br.com.anapaula.CreditCardPurchaseAuthorization.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

public enum CreditCardStatus {

    ATIVO("Ativo"),
    PERDIDO("Perdido"),
    ROUBADO("Roubado"),
    FALSIFICADO("Falsificado"),
    EXTRAVIADO("Extraviado"),
    VENCIDO("Vencido");

    private String status;

    CreditCardStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
