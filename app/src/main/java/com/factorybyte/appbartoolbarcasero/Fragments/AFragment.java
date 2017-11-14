package com.factorybyte.appbartoolbarcasero.Fragments;


import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements SearchView.OnQueryTextListener {


    View viewRoot;

    RecyclerView recyclerView;

    ProgressBar loading;


    List<Card> cardList =  new ArrayList<>();


    public String url_api = "https://api.androidhive.info/contacts/";

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


        new DownloadRawData().execute(url_api);




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

        String url_buscar = "https://api.androidhive.info/contacts/" +"?buscar="+ query;
        new DownloadRawData().execute(url_api);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("data", "entra");
        recyclerView.setAdapter(null);
        loading.setVisibility(View.VISIBLE);
        return false;
    }


    private class DownloadRawData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String link = params[0];
            try {
                URL url = new URL(link);
                InputStream is = url.openConnection().getInputStream();
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String res) {
            try {
                parseJSon(res);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJSon(String data) throws JSONException {
        if (data == null)
            return;

        JSONObject jsonData = new JSONObject(data);


        JSONArray jsonContacts = jsonData.getJSONArray("contacts");
        for (int i = 0; i < jsonContacts.length(); i++) {
            JSONObject jsonContact = jsonContacts.getJSONObject(i);
            Card card = new Card("url", jsonContact.getString("name"), "des", "75116755", 1,2);
            cardList.add(card);
        }

        loading.setVisibility(View.GONE);

        CardViewAdapter adapter =  new CardViewAdapter(this.getContext(), cardList);

        recyclerView.setAdapter(adapter);

    }

}
