package com.example.kafka.service;

import com.example.kafka.model.Transaction;

/**
 * Service for detecting fraudulent transactions.
 *
 * @author Matej Bizjak
 */
public interface FraudDetectionService {

    /**
     * Checks if the transaction is suspicious.
     */
    boolean isSuspicious(Transaction transaction);
}
