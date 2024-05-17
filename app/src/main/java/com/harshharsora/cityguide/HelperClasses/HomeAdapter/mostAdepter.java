package com.harshharsora.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harshharsora.cityguide.R;

import java.util.ArrayList;

public class mostAdepter extends RecyclerView.Adapter<mostAdepter.FeaturedViewHolder>{
    ArrayList<FeaturedHelperClass>featuredLocations;

    public mostAdepter(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeaturedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass  = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.mv_image);
            title=itemView.findViewById(R.id.mv_title);
            desc=itemView.findViewById(R.id.mv_desc);

        }
    }
}