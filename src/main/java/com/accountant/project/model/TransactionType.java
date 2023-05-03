package com.accountant.project.model;

public enum TransactionType {

    INCREMENT(1), DECREMENT(2);

    private Integer number;

    TransactionType(Integer number) {
        this.number = number;
    }
}
