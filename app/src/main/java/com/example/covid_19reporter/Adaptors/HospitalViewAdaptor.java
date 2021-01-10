package com.example.covid_19reporter.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19reporter.DTO.HospitalsData;
import com.example.covid_19reporter.R;

import java.util.List;

public class HospitalViewAdaptor extends RecyclerView.Adapter<HospitalViewAdaptor.ViewHolder> {

    private final Context mContext;
    private final List<HospitalsData> hospitaldata;
    private final LayoutInflater mLayoutInflater;

    public HospitalViewAdaptor(Context context, List<HospitalsData> hdata) {
        mContext = context;
        hospitaldata=hdata;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView=mLayoutInflater.inflate(R.layout.recycler_view_item,parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HospitalsData data=hospitaldata.get(position);
        holder.hospital.setText(data.getHospital().getName());
        holder.foreginP.setText(data.getCumulative_foreign());
        holder.localP.setText(data.getCumulative_local());
    }


    @Override
    public int getItemCount() {
        return  hospitaldata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView hospital;
        private final TextView localP;
        private  final TextView foreginP;

        public ViewHolder(View itemView) {
            super(itemView);
            hospital=itemView.findViewById(R.id.txt_hospital);
            localP=itemView.findViewById(R.id.txt_local);
            foreginP=itemView.findViewById(R.id.txt_foreign);

        }
    }
}
