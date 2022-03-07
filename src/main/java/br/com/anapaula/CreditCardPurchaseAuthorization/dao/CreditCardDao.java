package br.com.anapaula.CreditCardPurchaseAuthorization.dao;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.CreditCardDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreditCardDao {

    CreditCardDto findByData(String nomeImpressoNoCartao, Long numero, LocalDate validadeDoCartao, Integer codigoDeSeguranca);

    public CreditCard checkAvailableValue(BigDecimal valorDisponivel);

}
