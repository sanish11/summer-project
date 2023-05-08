package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id,nationality_id,address_id,number_id,bike_id,visit_date_id,return_date_id,price_id,total_id;
    SQLiteDatabase sq;

    public MyAdapter(Context context, ArrayList name_id, ArrayList nationality_id, ArrayList address_id, ArrayList number_id, ArrayList bike_id, ArrayList visit_date_id, ArrayList return_date_id, ArrayList price_id, ArrayList total_id) {
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
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.nationality_id.setText(String.valueOf(nationality_id.get(position)));
        holder.address_id.setText(String.valueOf(address_id.get(position)));
        holder.number_id.setText(String.valueOf(number_id.get(position)));
        holder.bike_id.setText(String.valueOf(bike_id.get(position)));
        holder.visit_date_id.setText(String.valueOf(visit_date_id.get(position)));
        holder.return_date_id.setText(String.valueOf(return_date_id.get(position)));
        holder.price_id.setText(String.valueOf(price_id.get(position)));
        holder.total_id.setText(String.valueOf(total_id.get(position)));
//   holder.delbtn.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Confirmation !!!");
//        builder.setMessage("Are you sure to delete?");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                MyDBHelper dbHelper = new MyDBHelper(context,"book",null,5);
//
//                dbHelper.deleteBook(model.getId());
//                name_id.remove(position);
//                nationality_id.remove(position);
//                address_id.remove(position);
//                number_id.remove(position);
//                bike_id.remove(position);
//                visit_date_id.remove(position);
//                return_date_id.remove(position);
//                price_id.remove(position);
//                total_id.remove(position);
//                notifyDataSetChanged();
//            }
//        });
//        builder.setNegativeButton("No", null);
//        builder.show();
//    }
//});



    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,nationality_id,address_id,number_id,bike_id,visit_date_id,return_date_id,price_id,total_id;
        Button delbtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            nationality_id = itemView.findViewById(R.id.natio);
            address_id = itemView.findViewById(R.id.addres);
            number_id = itemView.findViewById(R.id.ph);
            bike_id = itemView.findViewById(R.id.biike);
            visit_date_id = itemView.findViewById(R.id.visiit);
            return_date_id = itemView.findViewById(R.id.retu);
            price_id = itemView.findViewById(R.id.pp);
            total_id = itemView.findViewById(R.id.tootal);



        }
    }

}
