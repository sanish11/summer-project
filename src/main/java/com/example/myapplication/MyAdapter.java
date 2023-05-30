package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private Context context;
    private ArrayList  name_id,nationality_id,address_id,number_id,bike_id,visit_date_id,return_date_id,price_id,total_id;
    ArrayList<String> duplicateList = new ArrayList<String>();

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

//        ArrayList<String> duplicateList = new ArrayList<String>();
        for (int i = 0; i < name_id.size(); i++) {
            String data = name_id.get(i) + " " + nationality_id.get(i) + " " + address_id.get(i) + " " + number_id.get(i) + " " + bike_id.get(i) + " " + visit_date_id.get(i) + " " + return_date_id.get(i) + " " + price_id.get(i) + " " + total_id.get(i);
            duplicateList.add(data);
        }
        Log.d("MyAdapter", "duplicateList: " + duplicateList);
        Log.d("MyAdapter", "name: " + name_id);
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
        Log.d("MyAdapter", "name_id: " + name_id.get(position));
        Log.d("MyAdapter", "nationality_id: " + nationality_id.get(position));
        Log.d("MyAdapter", "address_id: " + address_id.get(position));
        Log.d("MyAdapter", "number_id: " + number_id.get(position));
        Log.d("MyAdapter", "bike_id: " + bike_id.get(position));
        Log.d("MyAdapter", "visit_date_id: " + visit_date_id.get(position));
        Log.d("MyAdapter", "return_date_id: " + return_date_id.get(position));
        Log.d("MyAdapter", "price_id: " + price_id.get(position));
        Log.d("MyAdapter", "total_id: " + total_id.get(position));




    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                Log.d("MyAdapter","constraint:" + constraint);
//                FilterResults filterResults = new FilterResults();
//                ArrayList<String> filteredList = new ArrayList<>();
//                Log.d("MyAdapter", "performFiltering called");
//                Log.d("MyAdapter", "duplicate"+ duplicateList);
//                // If the search query is null or empty, return the full list
//                if (constraint == null || constraint.length() == 0) {
//                    filteredList.addAll(duplicateList);
//                } else {
//                    String filterPattern = constraint.toString().toLowerCase().trim();
//                    for (String item : duplicateList) {
//                        if (item.toLowerCase().contains(filterPattern)) {
//                            filteredList.add(item);
//                        }
//                    }
//                }
//
//                filterResults.values = filteredList;
//                filterResults.count = filteredList.size();
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                // Clear the lists before adding filtered results
//                name_id.clear();
//                nationality_id.clear();
//                address_id.clear();
//                number_id.clear();
//                bike_id.clear();
//                visit_date_id.clear();
//                return_date_id.clear();
//                price_id.clear();
//                total_id.clear();
//
//                Log.d("MyAdapter","result value:"+results.count);
//                Log.d("MyAdapter","const value:"+constraint);
//                if (results.count > 0) {
//                    Log.d("MyAdapter","k cvha");
//                    ArrayList<String> filteredList = (ArrayList<String>) results.values;
//                    for (String item : filteredList) {
//                        int index = duplicateList.indexOf(item);
//                        if (index != -1) {
//                            name_id.add(duplicateList.get(index+1));
//                            nationality_id.add(nationality_id.get(index+2));
//                            address_id.add(address_id.get(index+3));
//                            number_id.add(number_id.get(index+4));
//                            bike_id.add(bike_id.get(index+5));
//                            visit_date_id.add(visit_date_id.get(index+6));
//                            return_date_id.add(return_date_id.get(index+7));
//                            price_id.add(price_id.get(index+8));
//                            total_id.add(total_id.get(index+9));
//                        }
//                    }
//                    Log.d("MyAdapter", "name_id: " + name_id);
//                    Log.d("MyAdapter", "nationality_id: " + nationality_id);
//                    Log.d("MyAdapter", "address_id: " + address_id);
//                    Log.d("MyAdapter", "number_id: " + number_id);
//                    Log.d("MyAdapter", "bike_id: " + bike_id);
//                    Log.d("MyAdapter", "visit_date_id: " + visit_date_id);
//                    Log.d("MyAdapter", "return_date_id: " + return_date_id);
//                    Log.d("MyAdapter", "price_id: " + price_id);
//                    Log.d("MyAdapter", "total_id: " + total_id);
//                }
//
//                // Notify the adapter that the data has changed
//                notifyDataSetChanged();
//            }
//        };
//    }
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
