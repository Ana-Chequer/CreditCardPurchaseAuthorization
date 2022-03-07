package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.dao.TransactionDao;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class TransactionServiceImpl implements TransactionService {

    @Override
    public boolean validateTransactionByValue(BigDecimal valorDaCompra, BigDecimal valorDisponivel) {
        boolean result = false;

        if( (valorDaCompra != null) && ( ((valorDisponivel.compareTo(valorDaCompra) == 1 )) || ( (valorDisponivel.compareTo(valorDaCompra) == 0 )))) {
            result = true;
        }

       return result;

    }

    @Override
    public boolean validateTransactionByDate(LocalDate dataDaCompra, LocalDate dataDeValidade) {
        boolean result = false;

        if((dataDaCompra.isBefore(dataDeValidade))) {
            result = true;
        }

        return result;
    }
}

