package com.hexagonal.services.bono.app.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ErrorMessageResponse {

    private String exception;
    private String code;
    private String message;
    private List<String> details;
    private String path;

}
