package br.com.anapaula.CreditCardPurchaseAuthorization.rest;

import br.com.anapaula.CreditCardPurchaseAuthorization.domain.Transaction;
import br.com.anapaula.CreditCardPurchaseAuthorization.dto.TransactionDto;
import br.com.anapaula.CreditCardPurchaseAuthorization.service.AuthorizeService;
import br.com.anapaula.CreditCardPurchaseAuthorization.service.AuthorizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/authorizationpurchase")
public class AuthorizationRestController {

    @Autowired
    private AuthorizeService authorizeService;

    @GetMapping("/providepurchasedata")
    public String providePurchaseData() {
        return "Forneça os dados da transação, por favor!";
    }

    @PostMapping("/approvepurchase")
    public String approvePurchase(@Valid @RequestBody TransactionDto transactionDto) {
        String response = "Transação Negada. Consulte o banco Emissor. ";

        boolean answer =  authorizeService.authorize(transactionDto);

        if(answer == true) {
            response = "Transação Aprovada.";
        }

        return response;
    }

}

