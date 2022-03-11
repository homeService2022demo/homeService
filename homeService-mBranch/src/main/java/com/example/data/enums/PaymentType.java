package com.example.data.enums;

public enum PaymentType {
    BY_CASH(0, "byCash"),
    BY_CARD(1, "byCard"),
    BY_WALLET(2, "byWallet");

    private final int index;
    private final String title;

    PaymentType(int index, String title) {
        this.index = index;
        this.title = title;
    }
}
