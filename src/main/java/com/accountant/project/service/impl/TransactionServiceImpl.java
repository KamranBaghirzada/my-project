package com.accountant.project.service.impl;

import com.accountant.project.dto.request.CashPurchaseRequest;
import com.accountant.project.model.Account;
import com.accountant.project.model.Material;
import com.accountant.project.repository.AccountRepository;
import com.accountant.project.repository.MaterialRepository;
import com.accountant.project.repository.TransactionRepository;
import com.accountant.project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final MaterialRepository materialRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    public void creditSaleTransaction(BigDecimal amount) {

    }

    @Override
    public void cashPurchaseTransaction(CashPurchaseRequest request) {
        String materialName = request.getMaterial().getMaterialName();
        Material material = materialRepository.findByMaterialName(materialName);

        if (material == null) {
            Material newMaterial = new Material();
            newMaterial.setMaterialName(materialName);
            newMaterial.setMeasurementUnit(request.getMaterial().getMeasurementUnit());
            materialRepository.save(newMaterial);

        } else {
            material.setMaterialName(materialName);
            material.setMeasurementUnit(request.getMaterial().getMeasurementUnit());
            materialRepository.save(material);

        }
        cashPurchaseAccounting(request);
    }

    @Transactional
    public void cashPurchaseAccounting(CashPurchaseRequest request) {
        Account cashAccount = accountRepository.findByAccountName("cash");
        Account materialAccount = accountRepository.findByAccountName("material");

        cashAccount.setBalance(cashAccount.getBalance().subtract(request.getAmount()));
        materialAccount.setBalance(cashAccount.getBalance().subtract(request.getAmount()));

        accountRepository.save(cashAccount);
        accountRepository.save(materialAccount);
    }

}
