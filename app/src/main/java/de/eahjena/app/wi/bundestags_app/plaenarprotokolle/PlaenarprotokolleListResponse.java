package de.eahjena.app.wi.bundestags_app.plaenarprotokolle;

import java.util.List;

import de.eahjena.app.wi.bundestags_app.plaenarprotokolle.Plaenarprotokolle;

public class PlaenarprotokolleListResponse {
        private Integer numFound;
        private String cursor;
        private List<Plaenarprotokolle> documents;

        public Integer getNumFound() {
            return numFound;
        }

        public String getCursor() {
            return cursor;
        }

        public List<Plaenarprotokolle> getDocuments() {
            return documents;
        }

        @Override
        public String toString() {
            return "PlaenarprotokolleListResponse{" +
                    "numFound=" + numFound +
                    ", cursor='" + cursor + '\'' +
                    ", documents=" + documents +
                    '}';
        }

}
