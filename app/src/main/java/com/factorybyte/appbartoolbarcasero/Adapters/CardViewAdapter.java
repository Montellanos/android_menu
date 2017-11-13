package com.factorybyte.appbartoolbarcasero.Adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.factorybyte.appbartoolbarcasero.Maps.MapsActivity;
import com.factorybyte.appbartoolbarcasero.Models.Card;
import com.factorybyte.appbartoolbarcasero.R;

import java.util.List;

/**
 * Created by Jorge on 13/11/2017.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.viewHolder> {

    Context context;
    List<Card> cardList;

    public class viewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name, description;
        public ImageButton call, ubication;

        public viewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);

            call = (ImageButton) itemView.findViewById(R.id.call);
            ubication = (ImageButton) itemView.findViewById(R.id.ubication);

        }
    }


    public CardViewAdapter(Context context, List<Card> cardList) {
        this.context = context;
        this.cardList = cardList;
    }


    @Override
    public CardViewAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewAdapter.viewHolder holder, int position) {
        final Card card = cardList.get(position);
        holder.name.setText(card.getName());
        holder.description.setText(card.getDescription());
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.placeholder);
        Glide.with(context).load(card.getImage()).apply(options).into(holder.image);


        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:" + card.getTelefono()));
                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) v.getContext(), new String[] {Manifest.permission.CALL_PHONE}, 1);
                }else{
                    v.getContext().startActivity(llamar);
                }
            }
        });

        holder.ubication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa =  new Intent(v.getContext(), MapsActivity.class);
                v.getContext().startActivity(mapa);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
