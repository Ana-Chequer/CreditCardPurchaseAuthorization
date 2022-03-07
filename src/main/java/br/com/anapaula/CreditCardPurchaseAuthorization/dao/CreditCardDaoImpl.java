package br.com.anapaula.CreditCardPurchaseAuthorization.dao;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.CreditCardDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;


@Repository
public class CreditCardDaoImpl implements CreditCardDao{

    @PersistenceContext
    private EntityManager entityManager;

    private CreditCard findByData2(String nomeDoPortadorImpresso, Long numero, LocalDate dataDeValidade, Integer codigoDeSeguranca) {
        String query = "SELECT c FROM CreditCard c WHERE c.nomeDoPortadorImpresso = :nomeDoPortadorImpresso AND c.numero = :numero AND c.dataDeValidade = :dataDeValidade AND c.codigoDeSeguranca = :codigoDeSeguranca";
        try {
            return entityManager.createQuery(query, CreditCard.class)
                    .setParameter("nomeDoPortadorImpresso", nomeDoPortadorImpresso)
                    .setParameter("numero", numero)
                    .setParameter("dataDeValidade", dataDeValidade)
                    .setParameter("codigoDeSeguranca", codigoDeSeguranca)
                    .getSingleResult();
        } catch(NoResultException nre) {
            return null;

        }
    }

    @Override
    public CreditCardDto findByData(String nomeDoPortadorImpresso, Long numero, LocalDate dataDeValidade, Integer codigoDeSeguranca) {
        CreditCardDto creditCardDto = new CreditCardDto();

            CreditCard creditCard = this.findByData2(nomeDoPortadorImpresso, numero, dataDeValidade, codigoDeSeguranca);
            if (creditCard == null){
                creditCardDto.setStatus(1);
            }else{
                creditCardDto.setStatus(0);
                creditCardDto.setCreditCard(creditCard);
            }

        return creditCardDto;
    }

    @Override
    public CreditCard checkAvailableValue(BigDecimal valorDisponivel) {
        String query = "SELECT v FROM CreditCard v WHERE v.valorDisponivel = :valorDisponivel";
        return entityManager.createQuery(query, CreditCard.class)
                .setParameter("valorDisponivel", valorDisponivel)
                .getSingleResult();
    }


}
