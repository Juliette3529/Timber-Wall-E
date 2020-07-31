package com.coffefreaks.timberwalle.model.enumerations;

public enum EngineStatus {
    MOVING("moving"),
    STOPPED("stopped"),
    ERROR("internal error");

    private final String label;

    EngineStatus(String value) {
        this.label = value;
    }

    public static EngineStatus valueOfLabel(String label){
        for (EngineStatus e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
