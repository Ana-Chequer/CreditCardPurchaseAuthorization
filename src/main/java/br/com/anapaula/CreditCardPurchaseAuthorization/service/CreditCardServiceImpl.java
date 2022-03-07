package br.com.anapaula.CreditCardPurchaseAuthorization.service;

import br.com.anapaula.CreditCardPurchaseAuthorization.dao.CreditCardDao;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Cardholder;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCardStatus;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.CreditCardDto;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardDao creditCardDao;

    @Override
    public CreditCard validateCreditCardByData(Long numero, String nomeDoPortadorImpresso, LocalDate dataDeValidade, Integer codigoDeSeguranca) {
        CreditCard result = null;

        System.out.println(numero + " " + nomeDoPortadorImpresso + " " + dataDeValidade + " " + codigoDeSeguranca);

        CreditCardDto creditCardDto = creditCardDao.findByData(nomeDoPortadorImpresso, numero, dataDeValidade, codigoDeSeguranca);

        if((creditCardDto.getStatus() == 0) && (this.checkStatus(creditCardDto.getCreditCard()))){
            result = creditCardDto.getCreditCard();
        }

        return result;
    }

    private boolean checkStatus(CreditCard creditCard) {
        boolean result = false;

        if (creditCard.getCreditCardStatus().equals(CreditCardStatus.ATIVO)) {
            result = true;
        }
        return result;
    }

}