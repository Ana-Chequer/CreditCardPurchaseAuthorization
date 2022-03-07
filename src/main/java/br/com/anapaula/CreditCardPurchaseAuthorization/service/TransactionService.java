package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public interface TransactionService {

    boolean validateTransactionByValue(BigDecimal valorDaCompra, BigDecimal valorDisponivel);

    boolean validateTransactionByDate(LocalDate dataDaCompra, LocalDate dataDeValidade);




}
