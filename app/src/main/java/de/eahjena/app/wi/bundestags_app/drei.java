package de.eahjena.app.wi.bundestags_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Aktivitaeten extends AppCompatActivity {
    String AktivitaetenList[] = {"Platzhalter_1","Platzhalter_2","Platzhalter_3","Platzhalter_4","Platzhalter_5" };

    int AktivitaetenImages [] = {R.drawable.adler,R.drawable.adler,R.drawable.adler,R.drawable.adler,R.drawable.adler };

    //Hier müssen dann die Arrays eingefügt werden


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drei);
        listView = (ListView) findViewById(R.id.customListView_3);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), dreiList, dreiImages);
        listView.setAdapter(customBaseAdapter);
    }
}