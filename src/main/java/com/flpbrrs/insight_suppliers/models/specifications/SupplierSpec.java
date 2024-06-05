package com.flpbrrs.insight_suppliers.models.specifications;

import com.flpbrrs.insight_suppliers.models.Supplier;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public class SupplierSpec {
    public static Specification<Supplier> withName(String name) {
        return (root, query, cb) -> name == null ? cb.and() : cb.like(root.get("name"), "%"+name+"%");
    }
    public static Specification<Supplier> withDocNumber(String docNumber) {
        return (root, query, cb) -> docNumber == null ? cb.and() : cb.equal(root.get("docNumber"), docNumber);
    }
}
