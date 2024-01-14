package de.eahjena.app.wi.bundestags_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter2 extends BaseAdapter {

    Context context;
    String listpersonen[];
    int listImages [];
    LayoutInflater inflater;

    public CustomBaseAdapter2 (Context ctx, String [] personenList, int [] personenImages){

        this.context = ctx;
        this.listpersonen = personenList;
        this.listImages =personenImages;
        inflater  = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listpersonen.length;
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
        ImageView personImg = (ImageView) convertView.findViewById((R.id.imageIcon));
        textView.setText(listpersonen[position]);
        personImg.setImageResource(listImages[position]);
        return convertView;
    }
}//Ich habe immer noch keinen blassen Schimmer was hier gemacht wird
//ich auch nicht
