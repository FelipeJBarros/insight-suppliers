package com.flpbrrs.insight_suppliers.controllers;

import com.flpbrrs.insight_suppliers.dto.SupplierDTO;
import com.flpbrrs.insight_suppliers.services.SuppliersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public Page<SupplierDTO> listAll(@PageableDefault(size = 10) Pageable pagination) {
        return suppliersServices.listAll(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> findById(@PathVariable("id") UUID supplierId) {
        SupplierDTO supplier = suppliersServices.findById(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> hire(@RequestBody SupplierDTO dto, UriComponentsBuilder uriBuilder) {
        SupplierDTO supplier = suppliersServices.create(dto);
        URI uri = uriBuilder.path("/suppliers/{id}").buildAndExpand(supplier.getId()).toUri();
        return ResponseEntity.created(uri).body(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(@PathVariable("id") UUID supplierId, @RequestBody SupplierDTO dto) {
        SupplierDTO supplier = suppliersServices.update(supplierId, dto);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID supplierId) {
        suppliersServices.delete(supplierId);
        return ResponseEntity.noContent().build();
    }
}
