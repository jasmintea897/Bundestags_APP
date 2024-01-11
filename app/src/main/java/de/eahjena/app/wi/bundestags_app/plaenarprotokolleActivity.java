package de.eahjena.app.wi.bundestags_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class plaenarprotokolleActivity extends AppCompatActivity {

    public void fillListView(String[] data) {

    }

    String plaenarprotokolle[]={"Protokoll_1", "Protokoll_2", "Protokoll_3", "Protokoll_4", "Protokoll_5"};
    //Hier müssen wir dann hinbekommen das die Sachen aus der API in die Schnittstelle eingefügt werden

    int AdlerImages [] = {R.drawable.adler, R.drawable.adler,R.drawable.adler,R.drawable.adler,R.drawable.adler,};
    //Hier müssen wir Hinbekommen das X-mal der Adler angezeigt wird, ohne das wir den jedes mal neu anlegen müssen


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plenarprotokolle);
        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),plaenarprotokolle,AdlerImages );
        listView.setAdapter(customBaseAdapter);

    }
}
