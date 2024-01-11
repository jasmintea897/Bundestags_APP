package de.eahjena.app.wi.bundestags_app.personen;

/*
    Klasse, mit allen Feldern die im JSON enthalten sind
    https://search.dip.bundestag.de/api/v1/swagger-ui/
    Wichtig: Datentyp wie im JSON und gleicher Name,
    damit Jackson das Mapping JSON -> Objekt hinbekommt
*/
public class Person {
    private String id;
    private String nachname;
    private String vorname;
    private String namenszusatz;
    private String typ;
    private Integer wahlperiode;
    private String basisdatum;
    private String datum;
    private String aktualisiert;
    private String titel;
    // List<PersonRole> personRoles;

    public String getId() {
        return id;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNamenszusatz() {
        return namenszusatz;
    }

    public String getTyp() {
        return typ;
    }

    public Integer getWahlperiode() {
        return wahlperiode;
    }

    public String getBasisdatum() {
        return basisdatum;
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

    // HEY Jeder Listeneintrag (Person) auf der Oberfläche entspricht diesem Format
    @Override
    public String toString() {
        return id + ": " + titel + " (" + wahlperiode + ")";
    }
}
