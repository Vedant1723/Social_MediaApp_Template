package com.vedev.assignmentblackcoffer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BrodcastAdapter extends RecyclerView.Adapter<BrodcastAdapter.MyViewHolder> {
   private List<Brodcasts> brodcastsList;

    public BrodcastAdapter(List<Brodcasts> brodcastsList) {
        this.brodcastsList = brodcastsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.brodcast_list, parent, false);
        return new BrodcastAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Brodcasts brodcasts=brodcastsList.get(position);
        holder.userLocation.setText(brodcasts.getUserLocation());
        holder.tags.setText(brodcasts.getTags());
        holder.brodcastDescription.setText(brodcasts.getBrodCastDescription());
        holder.userName.setText(brodcasts.getUserName());
        holder.userDesig.setText(brodcasts.getUserDesig());
        holder.userDp.setImageResource(R.drawable.facebook_logo);

    }

    @Override
    public int getItemCount() {
        return brodcastsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView userDp;
        public TextView userName,userLocation,userDesig,brodcastDescription,tags;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userDp=(CircleImageView)itemView.findViewById(R.id.brodUserDp);
            userDesig=(TextView) itemView.findViewById(R.id.brodUserDesig);
            userName=(TextView) itemView.findViewById(R.id.brodUserName);
            brodcastDescription=(TextView) itemView.findViewById(R.id.brodDescription);
            tags=(TextView) itemView.findViewById(R.id.brodTags);
            userLocation=(TextView) itemView.findViewById(R.id.brodUserLocation);


        }
    }
}
