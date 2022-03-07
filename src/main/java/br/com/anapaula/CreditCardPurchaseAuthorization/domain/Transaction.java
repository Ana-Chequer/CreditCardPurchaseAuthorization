package br.com.anapaula.CreditCardPurchaseAuthorization.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private LocalDate dataDaCompra;

    @Column(nullable = false)
    private BigDecimal valorDaCompra;

    @Column(nullable = false)
    private String nomeDoEstabelecimento;

    @ManyToOne
    @JoinColumn(name = "id_CreditCard_fk")
    private CreditCard creditCard;

    public Transaction() {
    }

    public Transaction(LocalDate dataDaCompra, BigDecimal valorDaCompra, String nomeDoEstabelecimento, CreditCard creditCard) {
        this.dataDaCompra = dataDaCompra;
        this.valorDaCompra = valorDaCompra;
        this.nomeDoEstabelecimento = nomeDoEstabelecimento;
        this.creditCard = creditCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public BigDecimal getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(BigDecimal valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public String getNomeDoEstabelecimento() {
        return nomeDoEstabelecimento;
    }

    public void setNomeDoEstabelecimento(String nomeDoEstabelecimento) {
        this.nomeDoEstabelecimento = nomeDoEstabelecimento;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
