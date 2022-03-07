package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;

import java.time.LocalDate;


public interface CreditCardService {

    CreditCard validateCreditCardByData(Long numero, String nomeDoPortadorImpresso, LocalDate dataDeValidade, Integer codigoDeSeguranca);

}
