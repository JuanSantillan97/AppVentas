package com.juan.autenticarmysql;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.juan.autenticarmysql.Model.Producto;

import java.util.ArrayList;

public class ProductosAdapter extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Producto> items;

    public ProductosAdapter (Activity activity, ArrayList<Producto> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Producto> category) {
        for (int i =0 ; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.listview_producto, null);
        }
        Producto dir = items.get(position);

        TextView nombreP =  view.findViewById(R.id.nombreP);
        nombreP.setText(dir.getNombreP());

        TextView descripcionP = view.findViewById(R.id.descripcionP);
        descripcionP.setText(dir.getDescripcion());

//        ImageView imagen = view.findViewById(R.id.imgProducto);
//        imagen.setImageResource(dir.getImagenP());

        return view;
    }

}
