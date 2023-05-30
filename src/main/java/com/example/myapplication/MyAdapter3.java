package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    private Context context;
    private ArrayList<String> name_id, nationality_id, address_id, number_id, bike_id, visit_date_id, return_date_id, price_id, total_id;

    public MyAdapter3(Context context, ArrayList<String> name_id, ArrayList<String> nationality_id, ArrayList<String> address_id, ArrayList<String> number_id, ArrayList<String> bike_id, ArrayList<String> visit_date_id, ArrayList<String> return_date_id, ArrayList<String> price_id, ArrayList<String> total_id) {
        this.context = context;
        this.name_id = name_id;
        this.nationality_id = nationality_id;
        this.address_id = address_id;
        this.number_id = number_id;
        this.bike_id = bike_id;
        this.visit_date_id = visit_date_id;
        this.return_date_id = return_date_id;
        this.price_id = price_id;
        this.total_id = total_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.searchbook, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(name_id.get(position));
        holder.nationality_id.setText(nationality_id.get(position));
        holder.address_id.setText(address_id.get(position));
        holder.number_id.setText(number_id.get(position));
        holder.bike_id.setText(bike_id.get(position));
        holder.visit_date_id.setText(visit_date_id.get(position));
        holder.return_date_id.setText(return_date_id.get(position));
        holder.price_id.setText(price_id.get(position));
        holder.total_id.setText(total_id.get(position));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, nationality_id, address_id, number_id, bike_id, visit_date_id, return_date_id, price_id, total_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.t_name);
            nationality_id = itemView.findViewById(R.id.t_natio);
            address_id = itemView.findViewById(R.id.t_addres);
            number_id = itemView.findViewById(R.id.t_ph);
            bike_id = itemView.findViewById(R.id.t_biike);
            visit_date_id = itemView.findViewById(R.id.t_visiit);
            return_date_id = itemView.findViewById(R.id.t_retu);
            price_id = itemView.findViewById(R.id.t_pp);
            total_id = itemView.findViewById(R.id.t_tootal);
        }
    }
}


