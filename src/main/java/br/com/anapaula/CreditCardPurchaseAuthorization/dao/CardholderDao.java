package br.com.anapaula.CreditCardPurchaseAuthorization.dao;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Cardholder;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;


public interface CardholderDao {

    Cardholder findByCpfAndName(String cpf, String nome);

}
