package com.manage.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String id;
    @NotBlank(message = "customer name is required")
    private String name;
    private String email;
    private String phone;
    private String address;
    private String notes;

}
