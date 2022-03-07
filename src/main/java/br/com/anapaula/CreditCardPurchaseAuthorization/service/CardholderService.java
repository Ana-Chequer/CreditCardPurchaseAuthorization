package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Cardholder;

public interface CardholderService {

    boolean validateCardHolderByCpfAndName(String cpf, String nome);
}
