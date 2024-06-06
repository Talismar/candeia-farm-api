package com.talismar.candeia_farm_api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "supplier")
    private List<PurchaseEntity> purchases;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public SupplierEntity() { }

    public SupplierEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonManagedReference
    public List<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
