package br.com.anapaula.CreditCardPurchaseAuthorization.dao;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public interface TransactionDao {

    void saveTransaction(Transaction transaction);
}
