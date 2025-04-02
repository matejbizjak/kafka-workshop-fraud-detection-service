package com.example.kafka.event;

import com.example.kafka.mapper.TransactionMapper;
import com.example.kafka.messaging.TransactionEvent;
import com.example.kafka.model.Transaction;
import com.example.kafka.service.FraudDetectionService;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
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

    @Channel("fraudulent-transactions")
    MutinyEmitter<TransactionEvent> fraudulentTransactionsEmitter;

    @Channel("verified-transactions")
    MutinyEmitter<TransactionEvent> verifiedTransactionsEmitter;

    @Incoming("transactions-fraud-detection")
    public Uni<Void> detectFraudReactive(TransactionEvent transactionEvent) {
        Transaction transaction = transactionMapper.eventToDto(transactionEvent);

        if (fraudDetectionService.isSuspicious(transaction)) {
            LOG.warn("Suspicious transaction: " + transaction.toString());
            return fraudulentTransactionsEmitter.send(transactionMapper.dtoToEvent(transaction));
        } else {
            return verifiedTransactionsEmitter.send(transactionMapper.dtoToEvent(transaction));
        }
    }
}
