package com.example.data.enums;

/**
 * @author fh.kazemi
 **/

public enum UserStatus {
    ACTIVE(0,"active"),
    DEACTIVATE(1,"deActive");

    private final int index;
    private final String title;

    UserStatus(int index, String title) {
        this.index = index;
        this.title = title;
    }
}
