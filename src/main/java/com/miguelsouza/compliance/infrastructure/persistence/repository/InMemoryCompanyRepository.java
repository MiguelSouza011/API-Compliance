package com.miguelsouza.compliance.infrastructure.persistence.repository;

import com.miguelsouza.compliance.domain.Company;
import com.miguelsouza.compliance.domain.CompanyRepository;
import com.miguelsouza.compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCompanyRepository implements CompanyRepository {

    private final CompanyEntityRepository repository;

    public InMemoryCompanyRepository(CompanyEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company save(Company company) {
        var entity = CompanyEntity.from(company);
        repository.save(entity);
        return company;
    }
}
