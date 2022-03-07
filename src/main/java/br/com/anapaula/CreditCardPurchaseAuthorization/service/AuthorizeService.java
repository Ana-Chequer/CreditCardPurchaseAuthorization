package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCardStatus;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.TransactionDto;

public interface AuthorizeService {

    public boolean authorize(TransactionDto transactionDto);


}
