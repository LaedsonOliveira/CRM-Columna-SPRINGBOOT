package com.dev.laedson.crmColumna.repository;

import com.dev.laedson.crmColumna.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, UUID> {
}
