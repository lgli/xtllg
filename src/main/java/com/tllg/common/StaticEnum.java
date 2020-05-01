package com.tllg.common;


/**
 * StaticEnum
 * @author lgli
 * @since 1.0
 * @version 1.0
 */
public enum StaticEnum {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    ELEVEN("11"),
    TWELVE("12"),
    THIRTEEN("13"),
    FOURTEEN("14"),
    FIFTEEN("15"),
    SIXTEEN("16"),
    SEVENTEEN("17"),
    EIGHTEEN("18"),
    NINETEEN("19"),
    TWENTY("20"),
    NULL_STR("null");

    private final String value;

    StaticEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
