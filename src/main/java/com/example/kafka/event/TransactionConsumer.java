package com.example.kafka.event;

import com.example.kafka.mapper.TransactionMapper;
import com.example.kafka.messaging.TransactionEvent;
import com.example.kafka.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TransactionConsumer {

    private static final Logger LOG = Logger.getLogger(TransactionConsumer.class);

    private final TransactionMapper transactionMapper;

    public TransactionConsumer(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    @Incoming("transactions-log")
    public void logTransaction(TransactionEvent transactionEvent) {
        Transaction transaction = transactionMapper.eventToDto(transactionEvent);

        LOG.infof("Received transaction: " + transaction.toString());
    }

//    @Incoming("transactions-log")
//    @Acknowledgment(Acknowledgment.Strategy.MANUAL)
//    public CompletionStage<Void> logTransactionManualAck(Message<TransactionEvent> message) {
//        var metadata = message.getMetadata(IncomingKafkaRecordMetadata.class).orElseThrow();
//
//        TransactionEvent payload = message.getPayload();
//        Transaction transaction = transactionMapper.eventToDto(payload);
//
//        LOG.infof("Received transaction: %s, accountId: %s, timestamp: %s, amount: %s, location: %s",
//                transaction.getTransactionId(), transaction.getAccountId(), transaction.getTimestamp(),
//                transaction.getAmount(), transaction.getLocation());
//
//        return message.ack();
//    }
}
