package com.harshharsora.cityguide.HelperClasses.HomeAdapter;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harshharsora.cityguide.R;

import java.util.ArrayList;

public class cardAdepter extends RecyclerView.Adapter<cardAdepter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;

    public cardAdepter(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeaturedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.image);
        holder.title.setText(featuredHelperClass.title);
        GradientDrawable Gardient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});
        holder.relative.setBackground(Gardient);
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        RelativeLayout relative;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cv_image);
            title = itemView.findViewById(R.id.cv_title);
            relative=itemView.findViewById(R.id.relative);
        }
    }
}