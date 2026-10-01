package com.miguelsouza.compliance.domain;

import java.util.List;

public record ComplianceScreening(
        List<SanctionIdentify> sanctions,
        AmlProfile amlProfile
) {
    public record SanctionIdentify(
            String name,
            String sourceList,
            String reason,
            double confidence) {
    }

    public record AmlProfile(
            int riskScore,
            List<String> riskFlags,
            boolean isPepPresent,
            List<PoliticalExposure> politicalExposures) {

        public record PoliticalExposure(
                String personName,
                String publicOffice) {

        }
    }
}
