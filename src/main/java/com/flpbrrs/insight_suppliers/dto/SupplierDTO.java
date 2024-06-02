package com.flpbrrs.insight_suppliers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SupplierDTO {
    private UUID id;
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    @Size(min = 11, max = 14)
    private String docNumber;
    @Email
    @NotBlank
    @Size(max = 255)
    private String email;
}
