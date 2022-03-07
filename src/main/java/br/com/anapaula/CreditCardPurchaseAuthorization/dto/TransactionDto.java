package br.com.anapaula.CreditCardPurchaseAuthorization.dto;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.CreditCard;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Component
public class TransactionDto {

    @NotBlank(message = "O campo nome não pode estar em branco.")
    private String nome;

    @NotBlank(message = "Preencher apenas com os dígitos.")
    private String cpf;

    @NotBlank(message = "O campo endereço não pode estar em branco.")
    private String endereco;

    private Long numero;

    @NotBlank(message = "Preencher o campo conforme nome impresso no cartão de crédito.")
    private String nomeDoPortadorImpresso;

    private LocalDate dataDeValidade;

    @Length(min = 3, max = 3, message = "Digite os três números do código de segurança")
    private Integer codigoDeSeguranca;

    private LocalDate dataDaCompra;

    @Digits(integer = 7, fraction = 2, message = "Preencher o campo com ponto e duas casas decimais.")
    private BigDecimal valorDaCompra;

    @NotBlank(message = "O campo nome não pode estar em branco.")
    private String nomeDoEstabelecimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        this.nomeDoPortadorImpresso = nomeDoPortadorImpresso;
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
        this.codigoDeSeguranca = codigoDeSeguranca;
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
}
