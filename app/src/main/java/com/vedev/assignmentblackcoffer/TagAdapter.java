package com.vedev.assignmentblackcoffer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {

    private List<Tags> tagsList;

    @NonNull
    @Override
    public TagAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tags_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagAdapter.MyViewHolder holder, int position) {
        Tags tags = tagsList.get(position);
        holder.tagTitle.setText("#"+tags.getTagTitle());
        holder.noOfTags.setText(tags.getNoOfTags()+" people nearby");
    }

    @Override
    public int getItemCount() {
        return tagsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tagTitle, noOfTags;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tagTitle = (TextView) itemView.findViewById(R.id.tagTitle);
            noOfTags = (TextView) itemView.findViewById(R.id.noOfTags);
        }
    }

    public TagAdapter(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

}
