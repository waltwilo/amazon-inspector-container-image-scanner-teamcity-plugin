package com.amazon.inspector.teamcity.sbomparsing;

public enum Severity {
    CRITICAL("critical", 4),
    HIGH("high", 3),
    MEDIUM("medium", 2),
    LOW("low", 1),
    NONE("none", 0);

    private String severityName;
    private int rating;

    Severity(String severityName, int rating) {
        this.severityName = severityName;
        this.rating = rating;
    }

    public static Severity getHigherSeverity(Severity sevLeft, Severity sevRight) {
        if (sevLeft.rating > sevRight.rating) {
            return sevLeft;
        }
        return sevRight;
    }

    public static Severity getSeverityFromString(String severityName) {
        switch (severityName) {
            case "critical":
                return CRITICAL;
            case "high":
                return HIGH;
            case "medium":
                return MEDIUM;
            case "low":
                return LOW;
            case "none":
                return NONE;
            default:
                throw new RuntimeException("Severity value doesn't exist!");
        }
    }
}
