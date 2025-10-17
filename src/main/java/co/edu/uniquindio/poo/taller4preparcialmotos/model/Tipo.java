package co.edu.uniquindio.poo.taller4preparcialmotos.model;

public enum Tipo { ELECTRICA("Electrica"),
    COMBUSTION("Combustion"),;

    private final String displayName;
    Tipo(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}
