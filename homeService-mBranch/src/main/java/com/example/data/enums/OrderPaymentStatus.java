package com.example.data.enums;

/**
 * @author fh.kazemi
 **/

public enum OrderPaymentStatus {
    PAID(0, "paid"),
    NOT_PAID(1, "notPaid");

    private final int index;
    private final String title;

    OrderPaymentStatus(int index, String title) {
        this.index = index;
        this.title = title;
    }
}
