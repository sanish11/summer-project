package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {
    private Context context;
    private ArrayList<String> name_id, nationality_id, address_id, number_id, bike_id, bike_no_id,license_no_id,passport_no_id,visit_date_id, return_date_id, total_id;

    public MyAdapter4(Context context, ArrayList<String> name_id, ArrayList<String> nationality_id, ArrayList<String> address_id, ArrayList<String> number_id, ArrayList<String> bike_id,ArrayList<String> bike_no_id,ArrayList<String> license_no_id,ArrayList<String> passport_no_id, ArrayList<String> visit_date_id, ArrayList<String> return_date_id,  ArrayList<String> total_id) {
        this.context = context;
        this.name_id = name_id;
        this.nationality_id = nationality_id;
        this.address_id = address_id;
        this.number_id = number_id;
        this.bike_id = bike_id;
        this.bike_no_id = bike_no_id;
        this.license_no_id = license_no_id;
        this.passport_no_id = passport_no_id;
        this.visit_date_id = visit_date_id;
        this.return_date_id = return_date_id;

        this.total_id = total_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userdata, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(name_id.get(position));
        holder.nationality_id.setText(nationality_id.get(position));
        holder.address_id.setText(address_id.get(position));
        holder.number_id.setText(number_id.get(position));
        holder.bike_id.setText(bike_id.get(position));
        holder.bike_no_id.setText(bike_no_id.get(position));
        holder.license_no_id.setText(license_no_id.get(position));
        holder.passport_no_id.setText(passport_no_id.get(position));
        holder.visit_date_id.setText(visit_date_id.get(position));
        holder.return_date_id.setText(return_date_id.get(position));

        holder.total_id.setText(total_id.get(position));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, nationality_id, address_id, number_id, bike_id,bike_no_id,license_no_id,passport_no_id, visit_date_id, return_date_id, price_id, total_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.u_textname);
            nationality_id = itemView.findViewById(R.id.u_natio);
            address_id = itemView.findViewById(R.id.u_biike);//u_license
            number_id = itemView.findViewById(R.id.u_b_no);//u_passport
            bike_id = itemView.findViewById(R.id.u_license);//u_biike
            bike_no_id = itemView.findViewById(R.id.u_passport);//u_b_no
            license_no_id = itemView.findViewById(R.id.u_addres);//u_addres
            passport_no_id = itemView.findViewById(R.id.u_phu);//u_phu
            visit_date_id = itemView.findViewById(R.id.u_visiit);//u_visiit
            return_date_id = itemView.findViewById(R.id.u_retu);//u_retu
            total_id = itemView.findViewById(R.id.u_tootal);
        }
    }
}


