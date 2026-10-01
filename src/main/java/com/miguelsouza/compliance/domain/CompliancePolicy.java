package com.miguelsouza.compliance.domain;

public class CompliancePolicy {

    public static RiskAssessment evaluate(ComplianceScreening screening) {
        var status = RiskAssessmentStatus.APPROVED;

    boolean hasCriticalSanctions = screening.sanctions().stream()
            .anyMatch(s -> s.confidence() > 0.8);

    if (hasCriticalSanctions) {
        status = RiskAssessmentStatus.REJECTED;
    } else if (screening.amlProfile().isPepPresent()) {
        status = RiskAssessmentStatus.MANUAL_REVIEW;
    }

    int amlScore = screening.amlProfile().riskScore();

    if (status == RiskAssessmentStatus.APPROVED && amlScore > 70) {
        status = RiskAssessmentStatus.MANUAL_REVIEW;
    }

    return new RiskAssessment(amlScore, status);
    }
}
