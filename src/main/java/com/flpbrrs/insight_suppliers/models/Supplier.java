package com.flpbrrs.insight_suppliers.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "suppliers")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "doc_number", unique = true, nullable = false)
    private String docNumber;

    @Column(unique = true, nullable = false)
    private String email;
}
