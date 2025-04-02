package com.example.kafka.model;

import com.example.kafka.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {

    private String transactionId;
    private String accountId;
    private Instant timestamp;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String location;
    private String description;

    public Transaction() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
               "transactionId='" + transactionId + '\'' +
               ", accountId='" + accountId + '\'' +
               ", timestamp=" + timestamp +
               ", transactionType=" + transactionType +
               ", amount=" + amount +
               ", location='" + location + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}
