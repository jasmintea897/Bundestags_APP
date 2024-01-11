package de.eahjena.app.wi.bundestags_app.plaenarprotokolle;

public class Plaenarprotokolle {

    private String id;
    private String dokumentart;
    private String typ;
    private Integer dokumentnummer;
    private Integer wahlperiode;
    private String herausgeber;
    private String datum;
    private String aktualisiert;
    private String titel;

    // List<PlaenarprotokollRole> pleanarprotokollRoles;

    public String getId() {
        return id;
    }

    public String getDokumentart() {
        return dokumentart;
    }

    public String getTyp() {
        return typ;
    }

    public Integer getDokumentnummer() {
        return dokumentnummer;
    }

    public Integer getWahlperiode() {
        return wahlperiode;
    }

    public String getHerausgeber() {
        return herausgeber;
    }

    public String getDatum() {
        return datum;
    }

    public String getAktualisiert() {
        return aktualisiert;
    }

    public String getTitel() {
        return titel;
    }

    @Override
    public String toString() {
        return id + ": " + titel + " (" + wahlperiode + ")";
    }
}
