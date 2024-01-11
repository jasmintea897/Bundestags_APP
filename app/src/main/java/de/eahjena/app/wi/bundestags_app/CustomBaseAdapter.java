package de.eahjena.app.wi.bundestags_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String plaenarprotokolle[];
    int listImages[];
    LayoutInflater inflater;
    //Anlegen der ListenFunktionen mit basic Adapter --> K.A. wie das funktioniert
    public CustomBaseAdapter(Context ctx, String [] plaenarprotokolle, int [] images){
        this.context =ctx;
        this.plaenarprotokolle =plaenarprotokolle;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return plaenarprotokolle.length;
        //Anzahl der Zeilen gleich der Anzahl der elemente des Strings Plaenarprotokolle
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView adlerImg = (ImageView) convertView.findViewById(R.id.imageIcon);
        textView.setText(plaenarprotokolle[position]);
        //Start mit Postition 0 im String Plaenarprotokolle
        adlerImg.setImageResource(listImages[position]);
        return convertView;
        // Erstellt für jede Zeile die Bild Text Ansicht und geht dann wieder zur Liste

        //return null;
    }
}
