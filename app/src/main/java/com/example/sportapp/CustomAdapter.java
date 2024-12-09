package com.example.sportapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {


    // Crée la liste d'éléments
    private List<Sport> sportList;

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Crée un élement représentant une vue du recyclerView et retourner cette élément
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_item_layout, parent, false);

        return new SportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        // Récuperer dans la liste de type Sport un objet
        Sport sport = sportList.get(position);

        // Lié les widgets d'un élement du recyclerView au valeur de l'objet
        holder.textView.setText(sport.getSportName());
        holder.imageView.setImageResource(sport.getSportImg());
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }


    public static class SportsViewHolder extends RecyclerView.ViewHolder {
        //1-  Liaison de réference des composants dans la vue d'un élément

        TextView textView;
        ImageView imageView;

        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageViewCard);
        }
    }
}