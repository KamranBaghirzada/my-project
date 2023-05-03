package com.accountant.project.model;

public enum AccountType {

    ASSET(1), LIABILITY(2), CAPITAL(3);

    private Integer number;

    AccountType(Integer number) {
        this.number = number;
    }

    public static AccountType fromNumber(Integer number) {
        for (AccountType accountType : AccountType.values()) {
            if (accountType.number.equals(number)) {
                return accountType;
            }
        }
        throw new IllegalArgumentException("Invalid AccountType number: " + number);
    }
}
