package com.ef.util;
/**
 * @author Ariel Morel
 */
public enum DurationEnum {
    DAILY("daily"), HOURLY("hourly");

    private final String value;

    DurationEnum(String value){
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
