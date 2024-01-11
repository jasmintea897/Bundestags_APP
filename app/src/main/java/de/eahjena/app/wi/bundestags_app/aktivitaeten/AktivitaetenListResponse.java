package de.eahjena.app.wi.bundestags_app.aktivitaeten;

import java.util.List;

import de.eahjena.app.wi.bundestags_app.aktivitaeten.Aktivitaeten;

public class AktivitaetenListResponse {
        private Integer numFound;
        private String cursor;
        private List<Aktivitaeten> documents;

        public Integer getNumFound() {
            return numFound;
        }

        public String getCursor() {
            return cursor;
        }

        public List<Aktivitaeten> getDocuments() {
            return documents;
        }

        @Override
        public String toString() {
            return "AktivitaetenListResponse{" +
                    "numFound=" + numFound +
                    ", cursor='" + cursor + '\'' +
                    ", documents=" + documents +
                    '}';
        }

    }

