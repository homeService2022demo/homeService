package com.example.data.enums;

public enum OrderStatus {
    NEW(0,"new"),
    WAIT_FOR_SUGGESTION(1,"waiteForSuggestion"),
    WAIT_FOR_EXPERT_SELECTION(2,"waitForExpertSelection"),
    WAIT_FOR_EXPERT_COME(3,"waitForExpertCome"),
    STARTED(4,"started"),
    FINISHED(5,"finished"),
    CANCELED(6, "canceled");

    private final int index;
    private final String title;

    OrderStatus(int index, String title) {
        this.index = index;
        this.title = title;
    }
}
