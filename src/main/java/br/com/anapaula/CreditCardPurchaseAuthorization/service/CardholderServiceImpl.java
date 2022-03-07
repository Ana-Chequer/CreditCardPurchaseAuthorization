package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.dao.CardholderDao;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Cardholder;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CardholderServiceImpl implements CardholderService {

    @Autowired
    private CardholderDao cardholderDao;

    @Override
    public boolean validateCardHolderByCpfAndName(String cpf, String nome) {
        boolean result = false;

        Cardholder cardholder = cardholderDao.findByCpfAndName(cpf, nome);
        if(cardholder != null) {
            result = true;
        }

        return result;
    }
}

