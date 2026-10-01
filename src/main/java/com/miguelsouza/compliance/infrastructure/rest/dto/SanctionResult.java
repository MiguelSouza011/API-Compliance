package com.miguelsouza.compliance.infrastructure.rest.dto;

import com.miguelsouza.compliance.domain.ComplianceScreening;

import java.util.List;

public record SanctionResult(List<SanctionMatch> matches) {
    public List<ComplianceScreening.SanctionIdentify> toDomain() {
        if (matches() == null) {
            return List.of();
        }


        return matches().stream()
                .map(match -> new ComplianceScreening.SanctionIdentify(
                        match.entity(),
                        match.list(),
                        match.reason(),
                        match.confidenceScore() != null ? match.confidenceScore() : 0.0
                ))
                .toList();
    }

    public record SanctionMatch(
            String entity,
            String list,
            String reason,
            Double confidenceScore
    ) {
    }

}
