package com.jks.amal.CancerOthers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jks.amal.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RvAdapterOthers extends RecyclerView.Adapter<RvAdapterOthers.ViewHolder>{

    public ArrayList<ItemsOthers> mItems;
    public Context mContext;

    public RvAdapterOthers(ArrayList<ItemsOthers> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_others, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(mItems.get(position).getCircleImageView());
        holder.title.setText(mItems.get(position).getTitle());
        holder.description.setText(mItems.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView title;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_details);
            title = itemView.findViewById(R.id.tv_title_details);
            description = itemView.findViewById(R.id.tv_desc_details);
        }
    }
}
