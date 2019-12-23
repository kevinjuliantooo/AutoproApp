package com.example.autoproapp;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListDerekWithPriceAdapter extends RecyclerView.Adapter<ListDerekWithPriceAdapter.ListViewHolder> {

    private ArrayList<Derek> listDerek;
    private OnItemClickCallback onItemClickCallback;

    public ListDerekWithPriceAdapter(ArrayList<Derek> list){
        this.listDerek = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.derek_list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Derek derek = listDerek.get(position);
        holder.derek_name.setText(derek.getDerek_name() + " " + derek.getDerek_price());

        holder.derek_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listDerek.get(holder.getAdapterPosition()));
                Intent intent = new Intent(v.getContext(), PaymentActivity.class);
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listDerek.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView derek_name;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            derek_name = itemView.findViewById(R.id.derek_name);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Derek data);
    }


}
