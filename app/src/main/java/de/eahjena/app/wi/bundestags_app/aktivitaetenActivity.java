package de.eahjena.app.wi.bundestags_app;

import androidx.appcompat.app.AppCompatActivity;
import de.eahjena.app.wi.bundestags_app.api.BundestagApiClient;

import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class aktivitaetenActivity extends AppCompatActivity {

    int aktivitaetenImages [] = {R.drawable.adler,R.drawable.adler,R.drawable.adler,R.drawable.adler,R.drawable.adler };

    private final BundestagApiClient bundestagApiClient = new BundestagApiClient();

    // Hier Müssen dann die Arrays eingepflegt werden

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drei);
        listView = (ListView) findViewById(R.id.customListView_2);
    }

    protected void onResume() {
        super.onResume();
        bundestagApiClient.requestAktivity(this);
    }

    public void fillListView(String[] personsFromApi){
        // HEY Die Methode wird vom BundestagApiClient aufgerufen
        // BundestagApiClient: Spricht API an und holt sich die Personen
        // Ihr bekommt vom BundestagApiClient eine Liste an Strings mit den Personen (personsFromApi)
        CustomBaseAdapter personArrayAdapter =
                new CustomBaseAdapter(getApplicationContext(), personsFromApi,
                        getPersonenImages(personsFromApi.length));

        listView.setAdapter(personArrayAdapter);
    }

    private int[] getPersonenImages(int numberOfTableEntries){
        int[] imageArray = new int[numberOfTableEntries];
        Arrays.fill(imageArray, R.drawable.adler);
        return imageArray;
    }
}