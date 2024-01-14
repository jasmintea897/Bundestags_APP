package de.eahjena.app.wi.bundestags_app.aktivitaeten;

public class Aktivitaeten {
        private String id;
        private String aktivitaetsart;
        private String dokumentart;
        private String typ;
        private Integer wahlperiode;
        private String datum;
        private String aktualisiert;
        private String titel;
        // List<PersonRole> personRoles;

        public String getId() {
            return id;
        }

        public String getAktivitaetsart() {
            return aktivitaetsart;
        }

        public String getTyp() {
            return typ;
        }

        public String getDokumentart() {
            return dokumentart;
        }

        public String getTyp() {return typ;}

        public Integer getWahlperiode() {
            return wahlperiode;
        }

        public String getAktualisiert() {
            return aktualisiert;
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
