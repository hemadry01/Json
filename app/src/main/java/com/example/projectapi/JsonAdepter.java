package com.example.projectapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectapi.activity.DetailActivity;
import com.example.projectapi.model.SearchResult;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class JsonAdepter extends RecyclerView.Adapter<JsonAdepter.jsonViewHolder>{
    private List<SearchResult>searchResults;
    private Context mContext;

    public JsonAdepter(List<SearchResult> searchResults, Context mContext) {
        this.searchResults = searchResults;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public jsonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.project_layout,parent,false);
        return new jsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final jsonViewHolder holder, int position) {

        final SearchResult result = searchResults.get(position);
        holder.nameTV.setText(result.getName());
        holder.mobileTV.setText(result.getUser());
        holder.ocupactionTV.setText(result.getWho());
        Glide.with(mContext).load(result.getImage()).into(holder.pictureCI);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("name",result.getName());
                intent.putExtra("mobile",result.getUser());
                intent.putExtra("who",result.getWho());
                intent.putExtra("image",result.getImage());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    public class jsonViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView pictureCI;
        private TextView nameTV,mobileTV,ocupactionTV;
        private CardView cardView;
        public jsonViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureCI = itemView.findViewById(R.id.picture_image);
            nameTV = itemView.findViewById(R.id.textView_name);
            mobileTV = itemView.findViewById(R.id.textView_mobile);
            ocupactionTV = itemView.findViewById(R.id.textView_present);
            cardView = itemView.findViewById(R.id.card_id);
        }
    }
}
