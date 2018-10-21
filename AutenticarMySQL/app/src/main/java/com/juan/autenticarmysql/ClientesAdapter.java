package com.juan.autenticarmysql;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClientesAdapter extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Cliente> items;

    public ClientesAdapter (Activity activity, ArrayList<Cliente> items) {
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

    public void addAll(ArrayList<Cliente> category) {
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
            view = inf.inflate(R.layout.listview_cliente, null);
        }
        Cliente dir = items.get(position);

        TextView nombre =  view.findViewById(R.id.nombre);
        nombre.setText(dir.getNombre());

        TextView description =  view.findViewById(R.id.direccion);
        description.setText(dir.getDireccion());

        ImageView imagen = view.findViewById(R.id.imgCliente);
        imagen.setImageResource(dir.getImagen());

        return view;
    }

}
