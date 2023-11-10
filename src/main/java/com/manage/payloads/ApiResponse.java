package com.manage.payloads;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ApiResponse {
    private String response;
    private boolean status;
    private HttpStatus httpStatus;
}
