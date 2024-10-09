package com.hexagonal.services.bono.app.utils;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    BONO_NOT_FOUND("ERROR_BONO_001", "Bono not found."),
    DUPLICATE_BONO("ERROR_BONO_002", "Bono is duplicated."),
    INVALID_BONO("ERR_BONO_003", "Invalid bono parameters."),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");


    private final String code;
    private final String message;

    ErrorMessages(String code, String message){
        this.code = code;
        this.message = message;
    }

}
