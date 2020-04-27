package com.vedev.assignmentblackcoffer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SavedBrodcastAdapter extends  RecyclerView.Adapter<SavedBrodcastAdapter.MyViewHolder> {

    private List<SavedBrodcasts> savedBrodcastsList;

    public SavedBrodcastAdapter(List<SavedBrodcasts> savedBrodcastsList) {
        this.savedBrodcastsList = savedBrodcastsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_list, parent, false);
        return new SavedBrodcastAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SavedBrodcasts savedBrodcasts=savedBrodcastsList.get(position);
        holder.userLocation.setText(savedBrodcasts.getUserLocation());
        holder.tags.setText(savedBrodcasts.getTags());
        holder.brodcastDescription.setText(savedBrodcasts.getBrodCastDescription());
        holder.userName.setText(savedBrodcasts.getUserName());
        holder.userDesig.setText(savedBrodcasts.getUserDesig());
        holder.userDp.setImageResource(R.drawable.facebook_logo);


    }

    @Override
    public int getItemCount() {
        return savedBrodcastsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView userDp;
        public TextView userName,userLocation,userDesig,brodcastDescription,tags;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userDp=(CircleImageView)itemView.findViewById(R.id.savedUserDp);
            userDesig=(TextView) itemView.findViewById(R.id.savedUserDesignation);
            userName=(TextView) itemView.findViewById(R.id.savedUsername);
            brodcastDescription=(TextView) itemView.findViewById(R.id.savedBrodcastDescription);
            tags=(TextView) itemView.findViewById(R.id.savedTags);
            userLocation=(TextView) itemView.findViewById(R.id.savedUserLocation);

        }
    }
}
