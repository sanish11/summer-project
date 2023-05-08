
package com.example.myapplication;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private Context context;
    private ArrayList name_id,nationality_id,address_id,number_id,License_no_id,Passport_no_id,bike_id,bike_no_id,visit_date_id,end_date_id,total_price_id;

    public MyAdapter2(Context context, ArrayList name_id, ArrayList nationality_id, ArrayList address_id, ArrayList number_id, ArrayList License_no_id,ArrayList Passport_no_id,ArrayList bike_id,ArrayList bike_no_id, ArrayList visit_date_id, ArrayList end_date_id, ArrayList total_price_id) {
        this.context = context;
        this.name_id = name_id;
        this.nationality_id = nationality_id;
        this.address_id = address_id;
        this.number_id = number_id;
        this.License_no_id = License_no_id;
        this.Passport_no_id = Passport_no_id;
        this.bike_id = bike_id;
        this.bike_no_id = bike_no_id;
        this.visit_date_id = visit_date_id;
        this.end_date_id = end_date_id;

        this.total_price_id = total_price_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userdata,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.nationality_id.setText(String.valueOf(nationality_id.get(position)));
        holder.address_id.setText(String.valueOf(address_id.get(position)));
        holder.number_id.setText(String.valueOf(number_id.get(position)));
        holder.License_no_id.setText(String.valueOf(License_no_id.get(position)));
        holder.Passport_no_id.setText(String.valueOf(Passport_no_id.get(position)));
        holder.bike_id.setText(String.valueOf(bike_id.get(position)));
        holder.bike_no_id.setText(String.valueOf(bike_no_id.get(position)));
        holder.visit_date_id.setText(String.valueOf(visit_date_id.get(position)));
        holder.end_date_id.setText(String.valueOf(end_date_id.get(position)));

        holder.total_id.setText(String.valueOf(total_price_id.get(position)));



    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,nationality_id,address_id,number_id,bike_id,bike_no_id,License_no_id,Passport_no_id,visit_date_id,end_date_id,total_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.u_textname);
            nationality_id = itemView.findViewById(R.id.u_natio);
            address_id = itemView.findViewById(R.id.u_addres);
            number_id = itemView.findViewById(R.id.u_phu);
            bike_id = itemView.findViewById(R.id.u_biike);
            bike_no_id = itemView.findViewById(R.id.u_b_no);
            License_no_id = itemView.findViewById(R.id.u_license);
            Passport_no_id = itemView.findViewById(R.id.u_passport);
            visit_date_id = itemView.findViewById(R.id.u_visiit);
            end_date_id = itemView.findViewById(R.id.u_retu);

            total_id = itemView.findViewById(R.id.u_tootal);


        }
    }
}
