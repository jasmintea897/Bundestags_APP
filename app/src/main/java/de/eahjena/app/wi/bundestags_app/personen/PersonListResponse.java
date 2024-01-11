package de.eahjena.app.wi.bundestags_app.personen;


import java.util.List;

/*
    Klasse, mit allen Feldern die im JSON enthalten sind
    https://search.dip.bundestag.de/api/v1/swagger-ui/
    Wichtig: Datentyp wie im JSON und gleicher Name,
    damit Jackson das Mapping JSON -> Objekt hinbekommt

    Das Ding hier bekommst du beim Request auf
    https://search.dip.bundestag.de/api/v1/person?format=json zurück
*/
public class PersonListResponse {
    private Integer numFound;
    private String cursor;
    private List<Person> documents;

    public Integer getNumFound() {
        return numFound;
    }

    public String getCursor() {
        return cursor;
    }

    public List<Person> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "PersonListResponse{" +
                "numFound=" + numFound +
                ", cursor='" + cursor + '\'' +
                ", documents=" + documents +
                '}';
    }
}
