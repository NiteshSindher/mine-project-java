package com.example.studentmgmt.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="transactions")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type; // "PAYMENT" or "REFUND"
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    public TransactionRecord() {}
    public TransactionRecord(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // getters/setters
    public int getId() { return id; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public Date getDate() { return date; }
}
