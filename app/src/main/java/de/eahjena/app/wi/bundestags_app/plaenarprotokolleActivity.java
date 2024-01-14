package de.eahjena.app.wi.bundestags_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class plaenarprotokolleActivity extends AppCompatActivity {

    public void fillListView(String[] data) {
        CustomBaseAdapter plaenarprotokolleArrayAdapter =
                new CustomBaseAdapter(getApplicationContext(), data,
                        getPlaenarprotokolleImages(data.length));

        listView.setAdapter(plaenarprotokolleArrayAdapter);
    }

    private int[] getPlaenarprotokolleImages(int length) {
    }


    String plaenarprotokolle[] = {"Protokoll_1", "Protokoll_2", "Protokoll_3", "Protokoll_4", "Protokoll_5"};
    // Hier müssen wir dann hinbekommen, dass die Sachen aus der API in die Schnittstelle eingefügt werden

    int adlerImages[] = {R.drawable.adler, R.drawable.adler, R.drawable.adler, R.drawable.adler, R.drawable.adler};
    // Hier müssen wir hinbekommen, dass X-mal der Adler angezeigt wird, ohne dass wir den jedes Mal neu anlegen müssen

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plenarprotokolle);
        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), plaenarprotokolle, adlerImages);
        listView.setAdapter(customBaseAdapter);
    }
}
 



