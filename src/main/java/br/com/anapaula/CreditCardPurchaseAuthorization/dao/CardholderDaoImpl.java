package br.com.anapaula.CreditCardPurchaseAuthorization.dao;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Cardholder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CardholderDaoImpl implements CardholderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cardholder findByCpfAndName(String cpf, String nome) {
        String query = "SELECT c FROM Cardholder c WHERE c.cpf = :cpf AND c.nome = :nome";
        return entityManager.createQuery(query, Cardholder.class)
                .setParameter("cpf", cpf)
                .setParameter("nome", nome)
                .getSingleResult();
    }

}
