package com.talismar.candeia_farm_api.repositories;

import com.talismar.candeia_farm_api.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}
