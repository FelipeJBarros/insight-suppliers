package com.flpbrrs.insight_suppliers.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SupplierDTO {
    private UUID id;
    private String name;
    private String docNumber;
    private String email;
}
