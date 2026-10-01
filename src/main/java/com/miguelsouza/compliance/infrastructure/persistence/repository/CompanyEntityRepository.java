package com.miguelsouza.compliance.infrastructure.persistence.repository;

import com.miguelsouza.compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "companies")
public interface CompanyEntityRepository extends CrudRepository<CompanyEntity, UUID> {
}
