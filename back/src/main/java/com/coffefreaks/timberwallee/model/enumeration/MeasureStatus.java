package com.coffefreaks.timberwallee.model.enumeration;

public enum MeasureStatus {
    TOSTART("STARTING"),
    READY("READY"),
    WORKING("IN_PROGRESS");

    private final String label;

    MeasureStatus(String value) {
        this.label = value;
    }

    public static MeasureStatus valueOfLabel(String label){
        for (MeasureStatus e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
