package com.example.TechnicalTestBVK.modules.transaction.controller;

import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import com.example.TechnicalTestBVK.modules.transaction.dto.CheckoutDTO;
import com.example.TechnicalTestBVK.modules.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @Transactional
    @PutMapping("/cart-checkout/1")
    public CheckoutDTO checkout() throws Exception{
        return transactionService.checkout(1);
    }
}
