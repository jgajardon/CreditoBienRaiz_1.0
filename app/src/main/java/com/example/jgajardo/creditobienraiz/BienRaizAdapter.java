package com.example.jgajardo.creditobienraiz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Clase que genera nuestro listview como un objeto
public class BienRaizAdapter extends ArrayAdapter<BienRaiz> {
    Context myContext;
    int myLayoutResouceID;
    BienRaiz mydata[] = null;

    public BienRaizAdapter(Context context, int layoutResoucesID, BienRaiz[] data){
        super(context, layoutResoucesID, data);

        this.myContext = context;
        this.myLayoutResouceID = layoutResoucesID;
        this.mydata = data;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row =convertView;
        BienRaizHolder holder = new BienRaizHolder();

        if(row == null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            row = inflater.inflate(myLayoutResouceID, parent, false);


            holder.imagen = (ImageView) row.findViewById(R.id.image);
            holder.textView = (TextView) row.findViewById(R.id.tv);
            row.setTag(holder);

        }else{
            holder = (BienRaizHolder)row.getTag();
        }

        BienRaiz bienRaiz = mydata[position];
        holder.textView.setText(bienRaiz.title);
        holder.imagen.setImageResource(bienRaiz.icon);

        return row;
    }

    static class BienRaizHolder{
        ImageView imagen;
        TextView textView;
    }


}




