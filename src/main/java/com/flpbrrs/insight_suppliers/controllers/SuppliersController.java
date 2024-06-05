package com.flpbrrs.insight_suppliers.controllers;

import com.flpbrrs.insight_suppliers.dtos.PageDTO;
import com.flpbrrs.insight_suppliers.dtos.SupplierDTO;
import com.flpbrrs.insight_suppliers.services.SuppliersServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("suppliers")
@RequiredArgsConstructor
public class SuppliersController {
    private final SuppliersServices suppliersServices;

    @GetMapping
    public PageDTO<SupplierDTO> listAll(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        return suppliersServices.listAll(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> findById(@PathVariable("id") @NotNull UUID supplierId) {
        SupplierDTO supplier = suppliersServices.findById(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> hire(@Valid @RequestBody SupplierDTO dto, UriComponentsBuilder uriBuilder) {
        SupplierDTO supplier = suppliersServices.create(dto);
        URI uri = uriBuilder.path("/suppliers/{id}").buildAndExpand(supplier.getId()).toUri();
        return ResponseEntity.created(uri).body(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(
            @PathVariable("id") @NotNull UUID supplierId,
            @Valid @RequestBody SupplierDTO dto
    ) {
        SupplierDTO supplier = suppliersServices.update(supplierId, dto);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @NotNull UUID supplierId) {
        suppliersServices.delete(supplierId);
        return ResponseEntity.noContent().build();
    }
}
