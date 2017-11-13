package com.factorybyte.appbartoolbarcasero.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.factorybyte.appbartoolbarcasero.Adapters.CardViewAdapter;
import com.factorybyte.appbartoolbarcasero.Models.Card;
import com.factorybyte.appbartoolbarcasero.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements SearchView.OnQueryTextListener {


    View viewRoot;

    RecyclerView recyclerView;

    ProgressBar loading;


    List<Card> cardList =  new ArrayList<>();

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewRoot = inflater.inflate(R.layout.fragment_a, container, false);
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) viewRoot.findViewById(R.id.recyclerA);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        loading = (ProgressBar) viewRoot.findViewById(R.id.loading);

        cardList.add(new Card("http://mty360.net/wp-content/uploads/2017/04/flor-cassi.jpg", "mi primier dato", "mi descripcion", "+591 75116755" , 1,0));
        cardList.add(new Card("https://www.laguiadelvaron.com/wp-content/uploads/2015/12/1597556_1502240563436303_1138651251_n.jpg", "mi segundo dato", "mi segunda descripcion", "+591 75116754" , 1,0));

        loading.setVisibility(View.GONE);

        CardViewAdapter adapter =  new CardViewAdapter(this.getContext(), cardList);

        recyclerView.setAdapter(adapter);

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

        return false;
    }
}
