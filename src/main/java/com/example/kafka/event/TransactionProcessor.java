package com.example.kafka.event;

import com.example.kafka.mapper.TransactionMapper;
import com.example.kafka.service.FraudDetectionService;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TransactionProcessor {

    private static final Logger LOG = Logger.getLogger(TransactionProcessor.class);

    private final TransactionMapper transactionMapper;
    private final FraudDetectionService fraudDetectionService;

    public TransactionProcessor(TransactionMapper transactionMapper, FraudDetectionService fraudDetectionService) {
        this.transactionMapper = transactionMapper;
        this.fraudDetectionService = fraudDetectionService;
    }
    
}
