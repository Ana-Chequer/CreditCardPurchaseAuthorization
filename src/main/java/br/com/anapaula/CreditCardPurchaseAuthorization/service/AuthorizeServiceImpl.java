package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.dao.CreditCardDao;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCardStatus;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Transactional
public class AuthorizeServiceImpl implements AuthorizeService {

    @Autowired
    private CardholderService cardholderService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private TransactionService transactionService;

    private CreditCardStatus creditCardStatus;

    @Override
    public boolean authorize(TransactionDto transactionDTO) {
        boolean result = false;

        CreditCard validateCreditCard = creditCardService.validateCreditCardByData(transactionDTO.getNumero(),
                transactionDTO.getNomeDoPortadorImpresso(),
                transactionDTO.getDataDeValidade(),
                transactionDTO.getCodigoDeSeguranca());

        if (validateCreditCard != null) {
           boolean validateCardHolder = cardholderService.validateCardHolderByCpfAndName(transactionDTO.getCpf(), transactionDTO.getNome());

            if (validateCardHolder == true) {
                boolean validatePurchaseByValue = transactionService.validateTransactionByValue(transactionDTO.getValorDaCompra(), validateCreditCard.getValorDisponivel());

                if (validatePurchaseByValue == true) {
                    boolean validatePurchaseByDate = transactionService.validateTransactionByDate(transactionDTO.getDataDaCompra(), validateCreditCard.getDataDeValidade());

                    if (validatePurchaseByDate == true) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }
}

