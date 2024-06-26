package com.flpbrrs.insight_suppliers.repositories;

import com.flpbrrs.insight_suppliers.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, UUID>, JpaSpecificationExecutor<Supplier> {
    boolean existsByEmail(String email);
    boolean existsByDocNumber(String docNumber);
    Optional<Supplier> findByEmail(String email);
    Optional<Supplier> findByDocNumber(String docNumber);
}
