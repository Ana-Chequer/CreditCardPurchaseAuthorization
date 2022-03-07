package br.com.anapaula.CreditCardPurchaseAuthorization.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16)
    private Long numero;

    @Column(nullable = false)
    private String nomeDoPortadorImpresso;

   @Column(nullable = false, length = 6)
    private LocalDate dataDeValidade;

    @Column(nullable = false, length = 3)
    private Integer codigoDeSeguranca;

    @Column(nullable = false)
    private BigDecimal valorDisponivel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardholder_id")
    private Cardholder cardholder;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "id_creditCardStatus_fk")
    private CreditCardStatus creditCardStatus;

    public CreditCard() {
    }

    public CreditCard(Long numero, String nomeDoPortadorImpresso, LocalDate dataDeValidade, Integer codigoDeSeguranca, BigDecimal valorDisponivel, Cardholder cardholder, CreditCardStatus creditCardStatus) {
        this.numero = numero;
        nomeDoPortadorImpresso = nomeDoPortadorImpresso;
        this.dataDeValidade = dataDeValidade;
        codigoDeSeguranca = codigoDeSeguranca;
        this.valorDisponivel = valorDisponivel;
        this.cardholder = cardholder;
        this.creditCardStatus = creditCardStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNomeDoPortadorImpresso() {
        return nomeDoPortadorImpresso;
    }

    public void setNomeDoPortadorImpresso(String nomeDoPortadorImpresso) {
        nomeDoPortadorImpresso = nomeDoPortadorImpresso;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public Integer getCodigoDeSeguranca() {
        return codigoDeSeguranca;
    }

    public void setCodigoDeSeguranca(Integer codigoDeSeguranca) {
        codigoDeSeguranca = codigoDeSeguranca;
    }

    public BigDecimal getValorDisponivel() {
        return valorDisponivel;
    }

   public void setCardholder(Cardholder cardholder) {
        this.cardholder = cardholder;
    }

    public Cardholder getCardholder() {
        return cardholder;
    }

    public CreditCardStatus getCreditCardStatus() {
        return creditCardStatus;
    }
}
