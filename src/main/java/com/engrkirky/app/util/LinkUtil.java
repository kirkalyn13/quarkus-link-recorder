package com.engrkirky.app.util;

public class LinkUtil {
    private LinkUtil(){}
    /**
     * Checks if the given short value is a valid HTTP status code.
     *
     * @param statusCode the short value to check
     * @return true if the status code is valid, false otherwise
     */
    public static boolean isValidHttpStatusCode(short statusCode) {
        return statusCode >= 100 && statusCode <= 599;
    }
}
