package de.eahjena.app.wi.bundestags_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter3 extends BaseAdapter {

    Context context;
    String listdrei[];
    int listImages [];
    LayoutInflater inflater;

    public CustomBaseAdapter3 (Context ctx, String [] dreiList, int [] dreiImages){

        this.context = ctx;
        this.listdrei = dreiList;
        this.listImages = dreiImages;
        inflater  = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listdrei.length;
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
        textView.setText(listdrei[position]);
        personImg.setImageResource(listImages[position]);
        return convertView;
    }
}