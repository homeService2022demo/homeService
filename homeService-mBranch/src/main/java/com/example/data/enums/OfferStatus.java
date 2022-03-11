package com.example.data.enums;

public enum OfferStatus {
    NEW(0,"new"),
    WAITING(1,"waiting"),
    ACCEPTED(2,"accepted"),
    REJECTED(3,"rejected"),
    CANCELED(4,"canceled");

    private final int index;
    private final String title;

    OfferStatus(int index, String title) {
        this.index = index;
        this.title = title;
    }
}
