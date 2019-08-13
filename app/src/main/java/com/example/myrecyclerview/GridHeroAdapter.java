package com.example.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {

    private ArrayList<Hero> listhero;

    public GridHeroAdapter(ArrayList<Hero> list){
        this.listhero = list;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
