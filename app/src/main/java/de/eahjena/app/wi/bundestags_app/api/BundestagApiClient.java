package de.eahjena.app.wi.bundestags_app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import de.eahjena.app.wi.bundestags_app.PersonenActivity;
import de.eahjena.app.wi.bundestags_app.personen.Person;
import de.eahjena.app.wi.bundestags_app.personen.PersonListResponse;
import de.eahjena.app.wi.bundestags_app.plaenarprotokolle.Plaenarprotokolle;
import de.eahjena.app.wi.bundestags_app.plaenarprotokolle.PlaenarprotokolleListResponse;
import de.eahjena.app.wi.bundestags_app.plaenarprotokolleActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BundestagApiClient {
    private final OkHttpClient client; // Genutzt für HTTP-Anfragen (-> build.gradle)
    private final ObjectMapper objectMapper; // Genutzt zur Umwandlung JSON -> Objekt
    private static final String urlBundestagApi = "https://search.dip.bundestag.de/api/v1/";

    public BundestagApiClient() {
        client = new OkHttpClient();
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public void requestPersons(PersonenActivity personenActivity) {
        System.out.println("Exec requestPersons");

        // Zusammenbauen der URL: hier mit Filter auf Wahlperiode 20, musst auch immer mit angeben, dass du JSON willst
        String personsUri = urlBundestagApi + "person?f.wahlperiode=20&format=json";
        requestBundestagApi(personsUri, personenActivity);
    }

    // Methode zum Umwandeln von JSON (kommt hier als String in Methode rein) in Objekt und dann in ein Array von Strings die du an der Oberfläche anzeigen möchtest
    public final String[] processPersonResponse(String responseJson){
        if (responseJson != null && !responseJson.isEmpty()) {
            try {
                PersonListResponse personListResponse = objectMapper.readValue(responseJson, PersonListResponse.class); // JSON in Objekt vom Typ PersonListResponse laden
                System.out.println("Person objects could be created successfully: " + personListResponse.toString());

                List<Person> persons = personListResponse.getDocuments();
                String[] personsForUi = new String[persons.size()];

                // Liste von Person-Objekten durchgehen und die Werte so umformatieren, wie du sie in der UI haben willst
                // und in ein neues Array (personsForUi) packen
                for (int personIndex = 0; personIndex < persons.size(); personIndex++) {
                    personsForUi[personIndex] = persons.get(personIndex).toString();
                }

                return personsForUi;
            } catch (JsonProcessingException e) {
                System.out.println("Error occurred in ObjectMapper! " +
                        "The JSON from the Bundestag API could not be converted into an object!");
            }
        } else {
            System.out.println("Response Body from Bundestags API is null or empty!");
        }
        return null;
    }

    //Methode zur Umwandlung JSON in Objekt, welches dann als Array von Strings an der UI angezeigt wird
    public final String[] processPlaenarprotokolleResponse(String responseJson){
        if (responseJson != null && !responseJson.isEmpty()) {
            try {
                PlaenarprotokolleListResponse plaenarprotokolleListResponse = objectMapper.readValue(responseJson, PlaenarprotokolleListResponse.class); // JSON in Objekt vom Typ PersonListResponse laden
                System.out.println("Person objects could be created successfully: " + plaenarprotokolleListResponse.toString());

                List<Plaenarprotokolle> plaenarprotokolles = plaenarprotokolleListResponse.getDocuments();
                String[] plaenarprotokollesForUi = new String[plaenarprotokolles.size()];

                // Liste von Plaenar-Objekten durchgehen und die Werte so umformatieren, wie du sie in der UI haben willst
                // und in ein neues Array (personsForUi) packen
                for (int plaenarprotokolleIndex = 0; plaenarprotokolleIndex < plaenarprotokolles.size(); plaenarprotokolleIndex++) {
                    plaenarprotokollesForUi[plaenarprotokolleIndex] = plaenarprotokolles.get(plaenarprotokolleIndex).toString();
                }

                return plaenarprotokollesForUi;
            } catch (JsonProcessingException e) {
                System.out.println("Error occurred in ObjectMapper! " +
                        "The JSON from the Bundestag API could not be converted into an object!");
            }
        } else {
            System.out.println("Response Body from Bundestags API is null or empty!");
        }
        return null;
    }
    public final String[] processAktivitaetenResponse(String responseJson){
        if (responseJson != null && !responseJson.isEmpty()) {
            try {
                AktivitaetenListResponse aktivitaetenListResponse = objectMapper.readValue(responseJson, AktivitaetenListResponse.class); // JSON in Objekt vom Typ AktivitaetenListResponse laden
                System.out.println("Aktivitaeten objects could be created successfully: " + aktivitaetenListResponse.toString());

                List<Aktivitaeten> aktivitaetenList = aktivitaetenListResponse.getDocuments();
                String[] aktivitaetenForUi = new String[aktivitaetenList.size()];

                // Liste von Aktivitaeten-Objekten durchgehen und die Werte so umformatieren, wie du sie in der UI haben willst
                // und in ein neues Array (aktivitaetenForUi) packen
                for (int aktivitaetenIndex = 0; aktivitaetenIndex < aktivitaetenList.size(); aktivitaetenIndex++) {
                    aktivitaetenForUi[aktivitaetenIndex] = aktivitaetenList.get(aktivitaetenIndex).toString();
                }

                return aktivitaetenForUi;
            } catch (JsonProcessingException e) {
                System.out.println("Error occurred in ObjectMapper! " +
                        "The JSON from the Bundestag API could not be converted into an object!");
            }
        } else {
            System.out.println("Response Body from Bundestags API is null or empty!");
        }
        return null;
    }


    // Die Methode kannst du auch für andere API-Aufrufe verwenden (nicht nur Personen)
    private void requestBundestagApi(String uri, Object activity) {
        // Hier wird das Objekt für die Anfrage zusammengebaut: URL & den Key im Authorization-Header
        Request request = new Request.Builder()
                .url(uri)
                .addHeader("Authorization", "ApiKey rgsaY4U.oZRQKUHdJhF9qguHMkwCGIoLaqEcaHjYLF")
                .build();

        /*
            Anfrage muss in neuem Thread ausgeführt werden, sonst kommt Exception
            Mit System.out.println logge ich paar Infos raus
            -> Logs findest du unter "Logcat" in Android Studio, wenn du die App auf deinem Smartphone ausführst
        */
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Bundestag API could not be requested successfully: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    // -> Wenn Statuscode 200 (Alles passt) und die Antwort nicht leer ist
                    if (response.isSuccessful() && response.body() != null) {
                        final String responseJson = response.body().string();   // Im Body der Response ist das JSON - das rausholen
                        System.out.println("Bundestag API was successfully requested! Response Body: " + responseJson);

                        // Überprüfe den Typ der Activity und handle entsprechend
                        if (activity instanceof PersonenActivity) {
                            PersonenActivity personenActivity = (PersonenActivity) activity;
                            personenActivity.runOnUiThread(new Runnable() { // jetzt wieder zurückwechseln auf den Haupt-Thread
                                @Override
                                public void run() {
                                    System.out.println("Start to update table for PersonenActivity...");
                                    personenActivity.fillListView(processPersonResponse(responseJson));
                                }
                            });
                        } else if (activity instanceof plaenarprotokolleActivity) {
                            plaenarprotokolleActivity plaenarprotokolleActivity = (plaenarprotokolleActivity) activity;
                            plaenarprotokolleActivity.runOnUiThread(new Runnable() { // jetzt wieder zurückwechseln auf den Haupt-Thread
                                @Override
                                public void run() {
                                    System.out.println("Start to update table for plaenarprotokolleActivity...");
                                    plaenarprotokolleActivity.fillListView(processPlaenarprotokolleResponse(responseJson));
                                }
                            });
                        } else if (activity instanceof AktivitaetenActivity) {
                            AktivitaetenActivity aktivitaetenActivity = (AktivitaetenActivity) activity;
                            aktivitaetenActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println("Start to update table for AktivitaetenActivity...");
                                    aktivitaetenActivity.fillListView(processAktivitaetenResponse(responseJson));
                                }
                            });
                        }
                        // Rest ist bisschen Fehlerhandling
                    } else if (response.isSuccessful()) {
                        System.out.println("Bundestag API responds with a successful status code, but the response body is empty!");
                    } else {
                        System.out.println("Bundestag API has reported an error! Statuscode: " + response.code());
                    }
                } catch (Exception e) {
                    System.out.println("Exception occurred: " + e.getClass());
                }
            }
        });
    }
}