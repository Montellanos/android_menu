package com.factorybyte.appbartoolbarcasero.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.factorybyte.appbartoolbarcasero.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment  implements SearchView.OnQueryTextListener{


    View viewRoot;
    TextView text;
    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewRoot = inflater.inflate(R.layout.fragment_c, container, false);
        text = (TextView) viewRoot.findViewById(R.id.textc);
        setHasOptionsMenu(true);
        return viewRoot;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("texto", "onQueryTextSubmit: " + query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        text.setText(newText);
        return false;
    }

}
