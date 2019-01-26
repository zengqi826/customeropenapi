/**
 * 
 */
package com.example.openapi.model.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author 86211
 *
 */
public enum TypeEnum {

    ERROR("error"), WARN("warn"), INVALID("invalid"), FATAL("fatal");

    private String value;

    /**
     * 
     */
    TypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
        for (TypeEnum b : TypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

}
