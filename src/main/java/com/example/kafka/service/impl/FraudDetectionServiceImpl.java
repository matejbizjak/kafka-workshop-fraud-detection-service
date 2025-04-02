package com.example.kafka.service.impl;

import com.example.kafka.model.Transaction;
import com.example.kafka.service.FraudDetectionService;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.Set;

@ApplicationScoped
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private static final BigDecimal AMOUNT_THRESHOLD = BigDecimal.valueOf(10000);

    private static final Set<String> SAFE_LOCATIONS = Set.of("SI", "RS", "GB", "US", "IT", "AT", "DE", "HR");

    @Override
    public boolean isSuspicious(Transaction transaction) {
        return transaction.getAmount().compareTo(AMOUNT_THRESHOLD) > 0 ||
               !SAFE_LOCATIONS.contains(transaction.getLocation());
    }
}
