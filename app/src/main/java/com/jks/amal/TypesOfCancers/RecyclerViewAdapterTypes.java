package com.jks.amal.TypesOfCancers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jks.amal.R;

import java.util.List;

public class RecyclerViewAdapterTypes extends RecyclerView.Adapter<RecyclerViewAdapterTypes.MyViewHolder> {

    Context mContext;
    List<ItemsTypes> mItems;

    public RecyclerViewAdapterTypes(Context mContext, List<ItemsTypes> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.items_types, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ItemsTypes temp = mItems.get(position);

        holder.tv_name.setText(mItems.get(position).getName());
        holder.tv_desc.setText(mItems.get(position).getDescription());
        holder.tv_causes.setText(mItems.get(position).getCauses());
        holder.tv_symptoms.setText(mItems.get(position).getSymptoms());
        holder.tv_diagnosis.setText(mItems.get(position).getDiagnosis());
        holder.tv_therapy.setText(mItems.get(position).getTherapy());

        holder.tv_details.setOnClickListener(v -> {

            Intent intent = new Intent(mContext, Details.class);
            intent.putExtra("name", temp.getName());
            intent.putExtra("desc", temp.getDescription());
            intent.putExtra("causes", temp.getCauses());
            intent.putExtra("symptoms", temp.getSymptoms());
            intent.putExtra("diagnosis", temp.getDiagnosis());
            intent.putExtra("therapy", temp.getTherapy());

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final TextView tv_desc;
        private final TextView tv_causes;
        private final TextView tv_symptoms;
        private final TextView tv_diagnosis;
        private final TextView tv_therapy;
        private final TextView tv_details;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_causes = itemView.findViewById(R.id.tv_causes);
            tv_symptoms = itemView.findViewById(R.id.tv_symptoms);
            tv_diagnosis = itemView.findViewById(R.id.tv_diagnosis);
            tv_therapy = itemView.findViewById(R.id.tv_therapy);
            tv_details = itemView.findViewById(R.id.tv_details);

        }
    }
}
