package br.com.anapaula.CreditCardPurchaseAuthorization.dto;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardDto {

    private CreditCard creditCard;

    private Integer status;

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
