package com.example.autoproapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListItemWithPriceAdapter extends RecyclerView.Adapter<ListItemWithPriceAdapter.ListViewHolder> {
    private ArrayList<Workshop> listWorkshop;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListItemWithPriceAdapter(ArrayList<Workshop> list){
        this.listWorkshop = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workshop_list_view, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        Workshop workshop = listWorkshop.get(position);

        holder.workshop_view.setText(workshop.getWorkshop_name() + workshop.getWorkshop_price());

        holder.workshop_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listWorkshop.get(holder.getAdapterPosition()));
                Intent intent = new Intent(v.getContext(), OrderTimeAndLocationActivity.class);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        System.out.println("Ada: " + listWorkshop.size());
        return listWorkshop.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView workshop_view;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            workshop_view = itemView.findViewById(R.id.workshop_name);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Workshop data);
    }
}
