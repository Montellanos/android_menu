package com.factorybyte.appbartoolbarcasero.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.factorybyte.appbartoolbarcasero.R;

/**
 * Created by Jorge on 9/11/2017.
 */

public class Adapter_Grid extends BaseAdapter {


    Context context;
    String textos[];
    LayoutInflater inflater;

    public Adapter_Grid(Context context, String textos[]){
        this.textos = textos;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return textos.length;
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
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.grid_a_item, null);
        TextView text = (TextView) view.findViewById(R.id.textGrid);
        text.setText(textos[position]);
        return view;
    }
}
