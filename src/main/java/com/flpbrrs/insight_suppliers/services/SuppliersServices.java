package com.flpbrrs.insight_suppliers.services;

import com.flpbrrs.insight_suppliers.dtos.PageDTO;
import com.flpbrrs.insight_suppliers.dtos.SupplierDTO;
import com.flpbrrs.insight_suppliers.dtos.SupplierOption;
import com.flpbrrs.insight_suppliers.models.Supplier;
import com.flpbrrs.insight_suppliers.models.specifications.SupplierSpec;
import com.flpbrrs.insight_suppliers.repositories.SuppliersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SuppliersServices {
    private final SuppliersRepository suppliersRepository;
    private final ModelMapper modelMapper;

    public PageDTO<SupplierDTO> listAll(SupplierOption options, Pageable pagination) {
        Specification<Supplier> specification = SupplierSpec.withName(options.getName())
                .and(SupplierSpec.withDocNumber(options.getDocNumber()));

        Page<SupplierDTO> suppliers = suppliersRepository
                .findAll(specification, pagination)
                .map(supplier -> modelMapper.map(supplier, SupplierDTO.class));

        return PageDTO.from(suppliers);
    }

    public List<SupplierDTO> listAll() {
        return suppliersRepository
                .findAll()
                .stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDTO.class))
                .toList();
    }

    public SupplierDTO findById(UUID supplierId) {
        Supplier supplier = suppliersRepository
                .findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier don't exist"));

        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public SupplierDTO create(SupplierDTO dto) {
        Supplier supplier = suppliersRepository.save(modelMapper.map(dto, Supplier.class));
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public SupplierDTO update(UUID supplierId, SupplierDTO dto) {
        boolean supplierExists = suppliersRepository.findById(supplierId).isPresent();
        if(!supplierExists) throw new RuntimeException("Supplier don't exists");
        dto.setId(supplierId);
        Supplier supplier = suppliersRepository.save(modelMapper.map(dto, Supplier.class));
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public void delete(UUID supplierId) {
        suppliersRepository.deleteById(supplierId);
    }
}
