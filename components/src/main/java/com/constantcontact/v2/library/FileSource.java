package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 */
public enum FileSource {
    ALL,
    MY_COMPUTER,
    STOCK_IMAGE,
    FACEBOOK,
    INSTAGRAM,
    SHUTTERSTOCK,
    MOBILE;

    @JsonValue
    @Override
    public String toString() {
        switch (this) {
            default:
            case ALL:
                return "ALL";

            case MY_COMPUTER:
                return "MyComputer";

            case STOCK_IMAGE:
                return "StockImage";

            case FACEBOOK:
                return "Facebook";

            case INSTAGRAM:
                return "Instagram";

            case SHUTTERSTOCK:
                return "Shutterstock";

            case MOBILE:
                return "Mobile";
        }
    }

    @JsonCreator
    public static FileSource create(String str) {
        if (str.equalsIgnoreCase("all")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("mycomputer")) {
            return MY_COMPUTER;
        }
        if (str.equalsIgnoreCase("stockimage")) {
            return STOCK_IMAGE;
        }
        if (str.equalsIgnoreCase("facebook")) {
            return FACEBOOK;
        }
        if (str.equalsIgnoreCase("instagram")) {
            return INSTAGRAM;
        }
        if (str.equalsIgnoreCase("shutterstock")) {
            return SHUTTERSTOCK;
        }
        if (str.equalsIgnoreCase("mobile")) {
            return MOBILE;
        }

        throw new IllegalArgumentException("Invalid file source passed: " + str);
    }
}
