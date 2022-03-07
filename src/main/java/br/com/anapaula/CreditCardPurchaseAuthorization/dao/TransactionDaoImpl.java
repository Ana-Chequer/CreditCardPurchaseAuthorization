package br.com.anapaula.CreditCardPurchaseAuthorization.dao;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTransaction(Transaction transaction) {
        entityManager.persist(transaction);
    }

}

