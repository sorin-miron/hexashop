package com.vass.shop.domain.model;

public enum CartType {
    NORMAL("NORMAL"),

    VIP("VIP");

    private final String value;

    CartType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static CartType fromValue(String value) {
        for (CartType b : CartType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
